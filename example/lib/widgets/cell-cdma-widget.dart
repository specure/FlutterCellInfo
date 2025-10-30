
import 'package:cell_info/models/common/cell_type.dart';
import 'package:flutter/widgets.dart';

class CdmaMainCellInfoWidget extends StatelessWidget {

  CdmaMainCellInfoWidget({
    Key? key,
    this.cellInfo
  }) : super (key: key);

  final CellType? cellInfo;

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.start,
      children: [
        Text("SubId: ${cellInfo?.cdma?.subscriptionId}, Type: ${cellInfo?.type} * ${cellInfo?.cdma?.type} * ${cellInfo?.cdma?.network?.mcc}-${cellInfo?.cdma?.network?.mnc} * ${cellInfo?.cdma?.band?.name} * ${cellInfo?.cdma?.connectionStatus}"),
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
                  Text("SID:"),
                  Text("${cellInfo?.cdma?.sid}"),
                  Text("CD EC/IO:"),
                  Text("${cellInfo?.cdma?.signalCDMA?.cdmaEcio}"),
                ]
            ),
            TableRow(
                children: [
                  Text("NID:"),
                  Text("${cellInfo?.cdma?.nid}"),
                  Text("CD RSSI:"),
                  Text("${cellInfo?.cdma?.signalCDMA?.cdmaRssi}"),
                ]
            ),
            TableRow(
                children: [
                  Text("BID:"),
                  Text("${cellInfo?.cdma?.bid}"),
                  Text("EV EC/IO:"),
                  Text("${cellInfo?.cdma?.signalCDMA?.evdoEcio}"),
                ]
            ),
            TableRow(
                children: [
                  Text("LAT:"),
                  Text("${cellInfo?.cdma?.lat}"),
                  Text("EV RSSI:"),
                  Text("${cellInfo?.cdma?.signalCDMA?.evdoRssi}"),
                ]
            ),
            TableRow(
                children: [
                  Text("LON:"),
                  Text("${cellInfo?.cdma?.lon}"),
                  Text("EV SNR:"),
                  Text("${cellInfo?.cdma?.signalCDMA?.evdoSnr}"),

                ]
            ),
          ],
        )],
    );
  }
}
