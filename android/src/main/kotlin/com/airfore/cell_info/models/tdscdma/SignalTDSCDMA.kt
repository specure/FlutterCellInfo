package com.airfore.cell_info.models.tdscdma

import com.airfore.cell_info.models.common.Signal
import java.io.Serializable

class SignalTDSCDMA : Signal(), Serializable {
    var rssi: Int? = null
    var bitErrorRate: Int? = null
    var rscp: Int? = null
    var rscpAsu: Int? = null
    var rssiAsu: Int? = null
}
