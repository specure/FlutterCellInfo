
import 'package:cell_info/models/common/cell_type.dart';
import 'package:flutter/widgets.dart';

class NrMainCellInfoWidget extends StatelessWidget {

  NrMainCellInfoWidget({
    Key? key,
    this.cellInfo
  }) : super (key: key);

  final CellType? cellInfo;

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.start,
      children: [
        Text("SubId: ${cellInfo?.nr?.subscriptionId}, Type: ${cellInfo?.type} * ${cellInfo?.nr?.type} * ${cellInfo?.nr?.network?.mcc}-${cellInfo?.nr?.network?.mnc} * ${cellInfo?.nr?.bandNR?.channelNumber} #${cellInfo?.nr?.bandNR?.number}, ${cellInfo?.nr?.bandNR?.name}"),
        Table (
          defaultVerticalAlignment: TableCellVerticalAlignment.middle,
          columnWidths: const {
            0: FractionColumnWidth(1/4),
            1: FractionColumnWidth(1/4),
            2: FractionColumnWidth(1/4),
            3: FractionColumnWidth(1/4),
          },
          children: [
            TableRow(
                children: [
                  Text("NCI:"),
                  Text("${cellInfo?.nr?.nci}"),
                  Text("CSI SINR:"),
                  Text("${cellInfo?.nr?.signalNR?.csiSinr}"),
                ]
            ),
            TableRow(
                children: [
                  Text("TAC:"),
                  Text("${cellInfo?.nr?.tac}"),
                  Text("SS RSRP:"),
                  Text("${cellInfo?.nr?.signalNR?.ssRsrp}"),
                ]
            ),
            TableRow(
                children: [
                  Text("PCI:"),
                  Text("${cellInfo?.nr?.pci}"),
                  Text("SS RSRQ:"),
                  Text("${cellInfo?.nr?.signalNR?.ssRsrq}"),
                ]
            ),
            TableRow(
                children: [
                  Text("CSI RSRP:"),
                  Text("${cellInfo?.nr?.signalNR?.csiRsrp}"),
                  Text("SS SINR:"),
                  Text("${cellInfo?.nr?.signalNR?.ssSinr}"),
                ]
            ),
            TableRow(
                children: [
                  Text("CSI RSRQ:"),
                  Text("${cellInfo?.nr?.signalNR?.csiRsrq}"),
                  Text(""),
                  Text(""),
                ]
            ),
          ],
        )],
    );
  }
}