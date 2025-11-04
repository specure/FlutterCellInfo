package com.airfore.cell_info.models.tdscdma


import com.airfore.cell_info.models.common.Cell
import java.io.Serializable

class CellTDSCDMA : Cell(), Serializable {
    var ci: Int? = null
    var lac: Int? = null
    var cpid: Int? = null
    var cid: Int? = null
    var rnc: Int? = null
    var cgi: String? = null
    var bandTDSCDMA: BandTDSCDMA? = null
    var signalTDSCDMA: SignalTDSCDMA? = null
}

