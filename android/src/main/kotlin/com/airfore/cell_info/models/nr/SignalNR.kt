package com.airfore.cell_info.models.nr

import com.airfore.cell_info.models.common.Signal
import java.io.Serializable

class SignalNR : Signal(), Serializable {
    var csiRsrp: Int? = null
    var csiRsrq: Int? = null
    var csiSinr: Int? = null
    var ssRsrp: Int? = null
    var ssRsrq: Int? = null
    var ssSinr: Int? = null
    var csiRsrpAsu: Int? = null
    var ssRsrpAsu: Int? = null
}
