package com.airfore.cell_info.models.wcdma


import com.airfore.cell_info.models.common.Cell
import java.io.Serializable

class CellWCDMA : Cell(), Serializable {
    var ci: Int? = null
    var lac: Int? = null
    var psc: Int? = null
    var cid: Int? = null
    var rnc: Int? = null
    var cgi: String? = null

    var bandWCDMA: BandWCDMA? = null
    var signalWCDMA: SignalWCDMA? = null
}

