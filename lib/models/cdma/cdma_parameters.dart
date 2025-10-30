import 'package:cell_info/models/common/network.dart';

import 'cdma_band.dart';
import 'cdma_signal.dart';

class Cdma {
  int? sid;
  int? nid;
  double? lat;
  double? lon;
  Band? band;
  int? bid;
  SignalCDMA? signalCDMA;
  String? connectionStatus;
  Network? network;
  int? subscriptionId;
  String? type;

  Cdma(
      {
        this.sid,
        this.nid,
        this.lat,
        this.lon,
        this.band,
        this.bid,
        this.signalCDMA,
        this.connectionStatus,
        this.network,
        this.subscriptionId,
        this.type});

  Cdma.fromJson(Map<String, dynamic> json) {
    band = json['band'] != null ? new Band.fromJson(json['band']) : null;
    bid = json['bid'];
    sid = json['sid'];
    nid = json['nid'];
    lat = json['lat'];
    lon = json['lon'];
    signalCDMA = json['signalCDMA'] != null
        ? new SignalCDMA.fromJson(json['signalCDMA'])
        : null;
    connectionStatus = json['connectionStatus'];
    subscriptionId = json['subscriptionId'];
    network =
    json['network'] != null ? new Network.fromJson(json['network']) : null;
    type = json['type'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    if (this.band != null) {
      data['band'] = this.band!.toJson();
    }
    data['bid'] = this.bid;
    data['sid'] = this.sid;
    data['nid'] = this.nid;
    data['lat'] = this.lat;
    data['lon'] = this.lon;
    data['subscriptionId'] = this.subscriptionId;
    if (this.signalCDMA != null) {
      data['signalCDMA'] = this.signalCDMA!.toJson();
    }
    data['connectionStatus'] = this.connectionStatus;
    if (this.network != null) {
      data['network'] = this.network!.toJson();
    }
    data['type'] = this.type;
    return data;
  }
}