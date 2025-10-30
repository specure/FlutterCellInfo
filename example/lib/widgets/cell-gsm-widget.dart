
import 'package:cell_info/models/common/cell_type.dart';
import 'package:flutter/widgets.dart';

class GsmMainCellInfoWidget extends StatelessWidget {

  GsmMainCellInfoWidget({
    Key? key,
    this.cellInfo
  }) : super (key: key);

  final CellType? cellInfo;

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.start,
      children: [
        Text("SubId: ${cellInfo?.gsm?.subscriptionId}, Type: ${cellInfo?.type} * ${cellInfo?.gsm?.type} * ${cellInfo?.gsm?.network?.mcc}-${cellInfo?.gsm?.network?.mnc} * ${cellInfo?.gsm?.bandGSM?.name} * ${cellInfo?.gsm?.connectionStatus}"),
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
                  Text("CID:"),
                  Text("${cellInfo?.gsm?.cid}"),
                  Text("RSSI:"),
                  Text("${cellInfo?.gsm?.signalGSM?.rssi}"),
                ]
            ),
            TableRow(
                children: [
                  Text("LAC:"),
                  Text("${cellInfo?.gsm?.lac}"),
                  Text("BER:"),
                  Text("${cellInfo?.gsm?.signalGSM?.bitErrorRate}"),
                ]
            ),
            TableRow(
                children: [
                  Text("BSIC:"),
                  Text("${cellInfo?.gsm?.bsic}"),
                  Text("TA:"),
                  Text("${cellInfo?.gsm?.signalGSM?.timingAdvance}"),
                ]
            ),
          ],
        )],
    );
  }
}
