package com.airfore.cell_info.models.tdscdma

import com.airfore.cell_info.models.common.Band
import java.io.Serializable

class BandTDSCDMA : Band(), Serializable {
    var downlinkUarfcn: Int? = null
}
