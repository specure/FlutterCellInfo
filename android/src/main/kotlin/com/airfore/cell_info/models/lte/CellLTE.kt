package com.airfore.cell_info.models.lte


import com.airfore.cell_info.models.common.Cell
import java.io.Serializable

class CellLTE : Cell(), Serializable {
    var bandwidth: Int? = null
    var eci: Int? = null
    var tac: Int? = null
    var pci: Int? = null
    var enb: Int? = null
    var cid: Int? = null
    var ecgi: String? = null
    var bandLTE: BandLTE? = null
    var signalLTE: SignalLTE? = null
}

