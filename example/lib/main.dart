import 'dart:async';
import 'dart:convert';

import 'package:cell_info/CellResponse.dart';
import 'package:cell_info/SIMInfoResponse.dart';
import 'package:cell_info/cell_info.dart';
import 'package:cell_info/models/common/cell_type.dart';
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
  CellsResponse _cellsResponse;

  @override
  void initState() {
    super.initState();
    initPlatformState();
  }

  String currentDBM = "";

  // Platform messages are asynchronous, so we initialize in an async method.
  Future<void> initPlatformState() async {
    CellsResponse cellsResponse;
    // Platform messages may fail, so we use a try/catch PlatformException.
    try {
      String platformVersion = await CellInfo.getCellInfo;
      final body = json.decode(platformVersion);

      cellsResponse = CellsResponse.fromJson(body);

      CellType currentCellInFirstChip = cellsResponse.primaryCellList[0];
      if (currentCellInFirstChip.type == "LT  E") {
        currentDBM =
            "LTE dbm = " + currentCellInFirstChip.lte.signalLTE.dbm.toString();
      } else if (currentCellInFirstChip.type == "NR") {
        currentDBM =
            "NR dbm = " + currentCellInFirstChip.nr.signalNR.dbm.toString();
      } else if (currentCellInFirstChip.type == "WCDMA") {
        currentDBM = "WCDMA dbm = " +
            currentCellInFirstChip.wcdma.signalWCDMA.dbm.toString();

        print('currentDBM = ' + currentDBM);
      }

      String simInfo = await CellInfo.getSIMInfo;
      final simJson = json.decode(simInfo);
      print("desply name ${SIMInfoResponse.fromJson(simJson).simInfoList[0].displayName}");

    } on PlatformException {
      _cellsResponse = null;
    }

    // If the widget was removed from the tree while the asynchronous platform
    // message was in flight, we want to discard the reply rather than calling
    // setState to update our non-existent appearance.
    if (!mounted) return;

    setState(() {
      _cellsResponse = cellsResponse;
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: _cellsResponse != null
            ? Center(
                child: Text(
                    'mahmoud = ${currentDBM}\n primary = ${_cellsResponse.primaryCellList.length.toString()} \n neighbor = ${_cellsResponse.neighboringCellList.length}'),
              )
            : null,
      ),
    );
  }
}
