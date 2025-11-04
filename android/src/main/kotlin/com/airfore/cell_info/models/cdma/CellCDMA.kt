package com.airfore.cell_info.models.cdma


import com.airfore.cell_info.models.common.Band
import com.airfore.cell_info.models.common.Cell
import cz.mroczis.netmonster.core.SubscriptionId
import java.io.Serializable

class CellCDMA() : Cell(), Serializable {
    var sid: Int? = null
    var nid: Int? = null
    var bid: Int? = null
    var lat: Double? = null
    var lon: Double? = null
    var band: Band? = null
    var signalCDMA: SignalCDMA? = null
}

