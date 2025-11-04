package com.airfore.cell_info.models.lte

import com.airfore.cell_info.models.common.Signal
import java.io.Serializable

class SignalLTE : Signal(), Serializable {
    var rssi: Int? = null
    var rsrp: Double? = null
    var rsrq: Double? = null
    var snr: Double? = null
    var cqi: Int? = null
    var timingAdvance: Int? = null
    var rssiAsu: Int? = null
    var rsrpAsu: Int? = null
}
