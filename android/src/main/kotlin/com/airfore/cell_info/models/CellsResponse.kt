package com.airfore.cell_info.models

import java.io.Serializable

class CellsResponse : Serializable {
    var primaryCellList: List<CellType?>? = ArrayList()
    var neighboringCellList: List<CellType?>? = ArrayList()
    var cellDataList: List<CellData?>? = ArrayList()
}
