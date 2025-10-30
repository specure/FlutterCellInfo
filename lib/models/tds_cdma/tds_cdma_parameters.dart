import 'package:cell_info/models/common/network.dart';
import 'package:cell_info/models/tds_cdma/tds_cdma_signal.dart';
import 'package:cell_info/models/wcdma/wcdma_band.dart';

class Tdscdma {
  int? subscriptionId;
  int? ci;
  int? cid;
  int? lac;
  int? cpid;
  int? rnc;
  String? cgi;
  BandWCDMA? bandTDSCDMA;
  SignalTDSCDMA? signalTDSCDMA;
  String? connectionStatus;
  Network? network;
  String? type;

  Tdscdma(
      {
        this.subscriptionId,
        this.ci,
        this.cid,
        this.lac,
        this.cpid,
        this.rnc,
        this.cgi,
        this.bandTDSCDMA,
        this.signalTDSCDMA,
        this.connectionStatus,
        this.network,
        this.type});

  Tdscdma.fromJson(Map<String, dynamic> json) {
    bandTDSCDMA = json['bandTDSCDMA'] != null
        ? new BandWCDMA.fromJson(json['bandTDSCDMA'])
        : null;
    signalTDSCDMA = json['signalTDSCDMA'] != null
        ? new SignalTDSCDMA.fromJson(json['signalTDSCDMA'])
        : null;
    connectionStatus = json['connectionStatus'];
    subscriptionId = json['subscriptionId'];
    ci = json['ci'];
    cid = json['cid'];
    lac = json['lac'];
    cpid = json['cpid'];
    rnc = json['rnc'];
    cgi = json['cgi'];
    network =
    json['network'] != null ? new Network.fromJson(json['network']) : null;
    type = json['type'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    if (this.bandTDSCDMA != null) {
      data['bandTDSCDMA'] = this.bandTDSCDMA!.toJson();
    }
    if (this.signalTDSCDMA != null) {
      data['signalTDSCDMA'] = this.signalTDSCDMA!.toJson();
    }
    data['connectionStatus'] = this.connectionStatus;
    data['subscriptionId'] = this.subscriptionId;
    data['ci'] = this.ci;
    data['cid'] = this.cid;
    data['lac'] = this.lac;
    data['cpid'] = this.cpid;
    data['cgi'] = this.cgi;
    data['rnc'] = this.rnc;;
    if (this.network != null) {
      data['network'] = this.network!.toJson();
    }
    data['type'] = this.type;
    return data;
  }
}