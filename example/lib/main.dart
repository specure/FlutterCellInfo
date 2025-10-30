import 'dart:async';
import 'dart:convert';

import 'package:cell_info/CellResponse.dart';
import 'package:cell_info/SIMInfoResponse.dart';
import 'package:cell_info/cell_info.dart';
import 'package:cell_info/models/common/cell_type.dart';
import 'package:cell_info_example/widgets/cells-info-widget.dart';
import 'package:cell_info_example/widgets/sims-info-widget.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  WidgetsFlutterBinding.ensureInitialized();
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  CellsResponse? _cellsResponse;
  SIMInfoResponse? _simInfoResponse;
  Timer? _timer;

  @override
  void initState() {
    super.initState();
    initPlatformState();

    _timer = Timer.periodic(Duration(seconds: 1), (timer) {
      initPlatformState();
    });

  }

  @override
  void dispose() {
    _timer?.cancel(); // Cancel the timer when widget is disposed
    super.dispose();
  }

  String currentDBM = "";

  // Platform messages are asynchronous, so we initialize in an async method.
  Future<void> initPlatformState() async {
    CellsResponse? cellsResponse;
    SIMInfoResponse? simsResponse;
    // Platform messages may fail, so we use a try/catch PlatformException.
    try {
      String? platformVersion = await CellInfo.getCellInfo;
      if (platformVersion != null) {
        final body = json.decode(platformVersion);

        cellsResponse = CellsResponse.fromJson(body);

        CellType? currentCellInFirstChip = (cellsResponse.primaryCellList?.isNotEmpty == true) ?  cellsResponse.primaryCellList?.first : null;
        if (currentCellInFirstChip?.type == "LTE") {
          currentDBM =
              "LTE dbm = " + (currentCellInFirstChip?.lte?.signalLTE?.dbm.toString() ?? "-");
        } else if (currentCellInFirstChip?.type == "NR") {
          currentDBM =
              "NR dbm = " + (currentCellInFirstChip?.nr?.signalNR?.dbm.toString() ?? "-");
        } else if (currentCellInFirstChip?.type == "WCDMA") {
          currentDBM = "WCDMA dbm = " +
              (currentCellInFirstChip?.wcdma?.signalWCDMA?.dbm?.toString() ?? "-");

          print('currentDBM = ' + currentDBM);
        }

        String? simInfo = await CellInfo.getSIMInfo;

        if (simInfo != null) {
          final simJson = json.decode(simInfo);
          if (simJson['error'] != null) {
            print("there is an error: ${simJson['error']}");
          } else {
            simsResponse = SIMInfoResponse.fromJson(simJson);
            print("display name ${simsResponse.simInfoList?.first.displayName}");
          }
        } else {
          print("Error while getting siminfo");
        }

      } else {
        print("Error while getting cellinfo");
      }
    } on PlatformException {
      _cellsResponse = null;
      _simInfoResponse = null;
    }

    // If the widget was removed from the tree while the asynchronous platform
    // message was in flight, we want to discard the reply rather than calling
    // setState to update our non-existent appearance.
    if (!mounted) return;

    setState(() {
      _cellsResponse = cellsResponse;
      _simInfoResponse = simsResponse;
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Cell info plugin example app'),
        ),
        body: _cellsResponse != null
            ? SingleChildScrollView(
          padding: const EdgeInsets.all(16.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              SimsInfoWidget(
                sims: _simInfoResponse?.simInfoList,
              ),
              const SizedBox(height: 8),
              const Text(
                "Primary cells:",
                style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
              ),
              CellsInfoWidget(
                cellInfos: _cellsResponse?.primaryCellList,
              ),
              const SizedBox(height: 8), // optional small spacing
              const Text(
                "Secondary cells:",
                style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
              ),
              CellsInfoWidget(
                cellInfos: _cellsResponse?.neighboringCellList,
              ),
            ],
          ),
        )
            : const Center(
          child: CircularProgressIndicator(),
        ),
      ),
    );
  }
}

/*
Text(
'mahmoud = ${currentDBM}\n primary = ${_cellsResponse?.primaryCellList?.length.toString()} \n neighbor = ${_cellsResponse?.neighboringCellList?.length}'),
)

 */