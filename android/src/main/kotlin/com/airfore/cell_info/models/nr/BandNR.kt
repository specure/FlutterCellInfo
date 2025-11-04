package com.airfore.cell_info.models.nr

import com.airfore.cell_info.models.common.Band
import java.io.Serializable

class BandNR : Band(), Serializable {
    var downlinkArfcn: Int? = null
    var downlinkFrequency: Int? = null
}
