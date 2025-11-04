package com.airfore.cell_info.models.gsm

import com.airfore.cell_info.models.common.Band
import java.io.Serializable

class BandGSM() : Band(), Serializable {
    var arfcn: Int? = null
}
