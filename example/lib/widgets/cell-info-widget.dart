import 'package:cell_info/models/common/cell_type.dart';
import 'package:cell_info_example/widgets/cell-cdma-widget.dart';
import 'package:cell_info_example/widgets/cell-gsm-widget.dart';
import 'package:cell_info_example/widgets/cell-lte-widget.dart';
import 'package:cell_info_example/widgets/cell-nr-widget.dart';
import 'package:cell_info_example/widgets/cell-tdscdma-widget.dart';
import 'package:cell_info_example/widgets/cell-wcdma-widget.dart';
import 'package:flutter/material.dart';

class CellInfoWidget extends StatelessWidget {

  CellInfoWidget({
    Key? key,
    this.cellInfos
  }) : super (key: key);

  final List<CellType?>? cellInfos;

  @override
  Widget build(BuildContext context) {
    return ListView(
      shrinkWrap: true,
      physics: const NeverScrollableScrollPhysics(),
      children: cellInfos?.map((cellInfo) {
        switch (cellInfo?.type) {
          case "GSM":
            return Padding(
              padding: const EdgeInsets.symmetric(vertical: 8),
              child: GsmMainCellInfoWidget(cellInfo: cellInfo),
            );
          case "CDMA":
            return Padding(
              padding: const EdgeInsets.symmetric(vertical: 8),
              child: CdmaMainCellInfoWidget(cellInfo: cellInfo),
            );
          case "WCDMA":
            return Padding(
              padding: const EdgeInsets.symmetric(vertical: 8),
              child: WcdmaMainCellInfoWidget(cellInfo: cellInfo),
            );
          case "TDSCDMA":
            return Padding(
              padding: const EdgeInsets.symmetric(vertical: 8),
              child: TdscdmaMainCellInfoWidget(cellInfo: cellInfo),
            );
          case "LTE":
            return Padding(
              padding: const EdgeInsets.symmetric(vertical: 8),
              child: LteMainCellInfoWidget(cellInfo: cellInfo),
            );
          case "NR":
            return Padding(
              padding: const EdgeInsets.symmetric(vertical: 8),
              child: NrMainCellInfoWidget(cellInfo: cellInfo),
            );
          default:
            return Padding(
              padding: const EdgeInsets.symmetric(vertical: 8),
              child: Text("Missing implementation for ${cellInfo?.type}"),
            ); // Fallback widget
        }
      }).toList() ?? [], // Null-safety fallback
    );
  }
}

