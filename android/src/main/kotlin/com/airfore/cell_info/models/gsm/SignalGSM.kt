package com.airfore.cell_info.models.gsm

import com.airfore.cell_info.models.common.Signal
import java.io.Serializable

class SignalGSM : Signal(), Serializable {
    var rssi: Int? = null
    var bitErrorRate: Int? = null
    var timingAdvance: Int? = null
}
