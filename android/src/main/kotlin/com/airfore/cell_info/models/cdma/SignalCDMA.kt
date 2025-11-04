package com.airfore.cell_info.models.cdma

import com.airfore.cell_info.models.common.Signal
import java.io.Serializable

class SignalCDMA : Signal(), Serializable {
    var cdmaRssi: Int? = null
    var evdoRssi: Int? = null
    var evdoSnr: Int? = null
    var cdmaEcio: Double? = null
    var evdoEcio: Double? = null
}
