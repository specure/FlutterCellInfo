import 'package:cell_info/models/common/cell_type.dart';
import 'package:cell_info_example/widgets/cell-lte-widget.dart';
import 'package:cell_info_example/widgets/cell-nr-widget.dart';
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
          case "LTE":
            return Padding(
              padding: const EdgeInsets.symmetric(vertical: 8),
              child: LteMainCellInfoWidget(cellInfo: cellInfo),
            );
          case "NR":
            return NrMainCellInfoWidget(cellInfo: cellInfo);
          default:
            return const SizedBox(); // Fallback widget
        }
      }).toList() ?? [], // Null-safety fallback
    );
  }
}

