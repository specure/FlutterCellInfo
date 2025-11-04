package com.airfore.cell_info.models

import java.io.Serializable

class SIMInfoResponse : Serializable {
    var simInfoList: List<SIMInfo?>? = ArrayList()

    constructor()

    constructor(simInfoList: List<SIMInfo?>?) {
        this.simInfoList = simInfoList
    }
}
