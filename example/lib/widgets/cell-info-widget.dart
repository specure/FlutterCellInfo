import 'package:cell_info/models/common/cell_type.dart';
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