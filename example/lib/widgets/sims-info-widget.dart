import 'package:cell_info/SIMInfoResponse.dart';
import 'package:flutter/material.dart';

class SimsInfoWidget extends StatelessWidget {

  SimsInfoWidget({
    Key? key,
    this.sims,
  }) : super (key: key);

  final List<SimInfoList?>? sims;

  @override
  Widget build(BuildContext context) {
    return ListView(
      shrinkWrap: true,
      physics: const NeverScrollableScrollPhysics(),
      children: sims?.map((simInfo) {
        return Padding(
          padding: const EdgeInsets.symmetric(vertical: 8),
          child: Table (
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
                    Text("SubId:"),
                    Text("${simInfo?.subscriptionId}"),
                    Text("Carrier:"),
                    Text("${simInfo?.carrierName}"),
                  ]
                ),
                TableRow(
                    children: [
                      Text("mcc-mnc:"),
                      Text("${simInfo?.mcc}-${simInfo?.mnc}"),
                      Text("Display:"),
                      Text("${simInfo?.displayName}"),
                    ]
                ),
                TableRow(
                    children: [
                      Text("Country:"),
                      Text("${simInfo?.countryIso}"),
                      Text("NetworkCountry:"),
                      Text("${simInfo?.networkCountryIso}"),
                    ]
                ),
                TableRow(
                    children: [
                      Text("Primary Data:"),
                      Text("${simInfo?.isDefaultDataSubscription}"),
                      Text("Roaming:"),
                      Text("${simInfo?.roaming}"),
                    ]
                ),
              ],
          ),
        );
      }).toList() ?? [], // Null-safety fallback
    );
  }
}

