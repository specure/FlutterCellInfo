
import 'package:cell_info/models/common/cell_type.dart';
import 'package:flutter/widgets.dart';

class TdscdmaMainCellInfoWidget extends StatelessWidget {

  TdscdmaMainCellInfoWidget({
    Key? key,
    this.cellInfo
  }) : super (key: key);

  final CellType? cellInfo;

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.start,
      children: [
        Text("SubId: ${cellInfo?.tdscdma?.subscriptionId}, Type: ${cellInfo?.type} * ${cellInfo?.tdscdma?.type} * ${cellInfo?.tdscdma?.network?.mcc}-${cellInfo?.tdscdma?.network?.mnc} * ${cellInfo?.tdscdma?.bandTDSCDMA?.name} * ${cellInfo?.tdscdma?.connectionStatus}"),
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
                  Text("${cellInfo?.tdscdma?.ci}"),
                  Text("CPID:"),
                  Text("${cellInfo?.tdscdma?.cpid}"),
                ]
            ),
            TableRow(
                children: [
                  Text("RNC:"),
                  Text("${cellInfo?.tdscdma?.rnc}"),
                  Text("RSSI:"),
                  Text("${cellInfo?.tdscdma?.signalTDSCDMA?.rssi}"),
                ]
            ),
            TableRow(
                children: [
                  Text("CID:"),
                  Text("${cellInfo?.tdscdma?.cid}"),
                  Text("BER:"),
                  Text("${cellInfo?.tdscdma?.signalTDSCDMA?.bitErrorRate}"),
                ]
            ),
            TableRow(
                children: [
                  Text("LAC:"),
                  Text("${cellInfo?.tdscdma?.lac}"),
                  Text("RSCP:"),
                  Text("${cellInfo?.tdscdma?.signalTDSCDMA?.rscp}"),
                ]
            ),
          ],
        )],
    );
  }
}
