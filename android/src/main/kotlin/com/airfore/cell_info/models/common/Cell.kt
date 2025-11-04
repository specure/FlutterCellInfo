package com.airfore.cell_info.models.common

import java.io.Serializable

open class Cell() : Serializable {
    var subscriptionId: Int? = null
    var connectionStatus: String? = null
    var type: String? = null
    var network: Network? = null
}
