package com.airfore.cell_info.models.gsm


import com.airfore.cell_info.models.common.Cell
import java.io.Serializable

class CellGSM : Cell(), Serializable {
    var cid: Int? = null
    var lac: Int? = null
    var bsic: Int? = null
    var ncc: Int? = null
    var bcc: Int? = null
    var cgi: Int? = null
    var bandGSM: BandGSM? = null
    var signalGSM: SignalGSM? = null
}

