
import 'package:cell_info/models/common/cell_type.dart';
import 'package:flutter/widgets.dart';

class WcdmaMainCellInfoWidget extends StatelessWidget {

  WcdmaMainCellInfoWidget({
    Key? key,
    this.cellInfo
  }) : super (key: key);

  final CellType? cellInfo;

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.start,
      children: [
        Text("SubId: ${cellInfo?.wcdma?.subscriptionId}, Type: ${cellInfo?.type} * ${cellInfo?.wcdma?.type} * ${cellInfo?.wcdma?.network?.mcc}-${cellInfo?.wcdma?.network?.mnc} * ${cellInfo?.wcdma?.bandWCDMA?.channelNumber} * ${cellInfo?.wcdma?.connectionStatus}"),
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
                  Text("${cellInfo?.wcdma?.ci}"),
                  Text("RSSI:"),
                  Text("${cellInfo?.wcdma?.signalWCDMA?.rssi}"),
                ]
            ),
            TableRow(
                children: [
                  Text("RNC:"),
                  Text("${cellInfo?.wcdma?.rnc}"),
                  Text("BER:"),
                  Text("${cellInfo?.wcdma?.signalWCDMA?.bitErrorRate}"),
                ]
            ),
            TableRow(
                children: [
                  Text("CID:"),
                  Text("${cellInfo?.wcdma?.cid}"),
                  Text("RSCP:"),
                  Text("${cellInfo?.wcdma?.signalWCDMA?.rscp}"),
                ]
            ),
            TableRow(
                children: [
                  Text("LAC:"),
                  Text("${cellInfo?.wcdma?.lac}"),
                  Text("ECIO:"),
                  Text("${cellInfo?.wcdma?.signalWCDMA?.ecio}"),
                ]
            ),
            TableRow(
                children: [
                  Text("PSC:"),
                  Text("${cellInfo?.wcdma?.psc}"),
                  Text("ECNO:"),
                  Text("${cellInfo?.wcdma?.signalWCDMA?.ecno}"),
                ]
            ),
          ],
        )],
    );
  }
}
