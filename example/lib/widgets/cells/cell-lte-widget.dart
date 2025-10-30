
import 'package:cell_info/models/common/cell_type.dart';
import 'package:flutter/widgets.dart';

class LteMainCellInfoWidget extends StatelessWidget {

  LteMainCellInfoWidget({
    Key? key,
    this.cellInfo
  }) : super (key: key);

  final CellType? cellInfo;

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.start,
      children: [
        Text("SubId: ${cellInfo?.lte?.subscriptionId}, Type: ${cellInfo?.type} * ${cellInfo?.lte?.type} * ${cellInfo?.lte?.network?.mcc}-${cellInfo?.lte?.network?.mnc} * ${cellInfo?.lte?.bandLTE?.name} * ${cellInfo?.lte?.connectionStatus}"),
        Table (
          defaultVerticalAlignment: TableCellVerticalAlignment.middle,
          columnWidths: const {
            0: FractionColumnWidth(1/6),
            1: FractionColumnWidth(2/6),
            2: FractionColumnWidth(1/6),
            3: FractionColumnWidth(2/6),
          },
          children: [
            TableRow(
                children: [
                  Text("CI:"),
                  Text("${cellInfo?.lte?.eci}"),
                  Text("EARFCN:"),
                  Text("${cellInfo?.lte?.bandLTE?.channelNumber}"),
                ]
            ),
            TableRow(
                children: [
                  Text("eNb:"),
                  Text("${cellInfo?.lte?.enb}"),
                  Text("RSSI:"),
                  Text("${cellInfo?.lte?.signalLTE?.rssi}"),
                ]
            ),
            TableRow(
                children: [
                  Text("CID:"),
                  Text("${cellInfo?.lte?.cid}"),
                  Text("RSRP:"),
                  Text("${cellInfo?.lte?.signalLTE?.rsrp}"),
                ]
            ),
            TableRow(
                children: [
                  Text("TAC:"),
                  Text("${cellInfo?.lte?.tac}"),
                  Text("RSRQ:"),
                  Text("${cellInfo?.lte?.signalLTE?.rsrq}"),
                ]
            ),
            TableRow(
                children: [
                  Text("PCI:"),
                  Text("${cellInfo?.lte?.pci}"),
                  Text("SNR:"),
                  Text("${cellInfo?.lte?.signalLTE?.snr}"),

                ]
            ),
            TableRow(
                children: [
                  Text("BW:"),
                  Text("${cellInfo?.lte?.bandwidth}"),
                  Text("TA:"),
                  Text("${cellInfo?.lte?.signalLTE?.timingAdvance}"),
                ]
            ),
          ],
        )],
    );
  }
}
