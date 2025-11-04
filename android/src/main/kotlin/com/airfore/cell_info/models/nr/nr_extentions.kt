package com.airfore.cell_info.models.nr

import android.util.Log
import com.airfore.cell_info.models.CellData
import com.airfore.cell_info.models.common.Network
import cz.mroczis.netmonster.core.model.cell.CellNr
import java.lang.Exception

fun getNr(cell: CellNr, cellData: CellData): CellNR {
    val cellNewRadio = cell.copy()
    val cellNR = CellNR()
    cellNR.type = "NR"
    cellData.type = "NR"

    cellNR.nci = cellNewRadio.nci
    cellData.nci = cellNewRadio.nci

    cellNR.pci = cellNewRadio.pci
    cellData.pci = cellNewRadio.pci

    cellNR.tac = cellNewRadio.tac
    cellData.tac = cellNewRadio.tac

    cellNR.connectionStatus = cellNewRadio.connectionStatus.toString()
    cellData.connectionStatus = cellNewRadio.connectionStatus.toString()

    cellNR.bandNR = BandNR().apply {
        this.name = cellNewRadio.band?.name
        this.number = cellNewRadio.band?.number
        this.channelNumber = cellNewRadio.band?.channelNumber
        this.downlinkArfcn = cellNewRadio.band?.downlinkArfcn
        this.downlinkFrequency = cellNewRadio.band?.downlinkFrequency
    }
    cellNewRadio.band?.let {
        cellData.bandChannelNumber = it.channelNumber
        cellData.bandNumber = it.number
        cellData.bandDownlinkArfcn = it.downlinkArfcn
        cellData.bandDownlinkFrequency = it.downlinkFrequency
        cellData.bandName = it.name
    }

    cellNR.network = Network().apply {
        this.iso = cellNewRadio.network?.iso
        this.mcc = cellNewRadio.network?.mcc
        this.mnc = cellNewRadio.network?.mnc
    }
    cellNewRadio.network?.let {
        cellData.iso = it.iso
        cellData.mcc = it.mcc
        cellData.mnc = it.mnc
    }

    cellNR.signalNR = SignalNR().apply {
        this.dbm = cellNewRadio.signal?.dbm
        this.ssRsrp = cellNewRadio.signal?.ssRsrp
        this.ssRsrq = cellNewRadio.signal?.ssRsrq
        this.ssSinr = cellNewRadio.signal?.ssSinr
        this.ssRsrpAsu = cellNewRadio.signal?.ssRsrpAsu
        this.csiRsrp = cellNewRadio.signal?.csiRsrp
        this.csiRsrpAsu = cellNewRadio.signal?.csiRsrpAsu
        this.csiRsrq = cellNewRadio.signal?.csiRsrq
        this.csiSinr = cellNewRadio.signal?.csiSinr
    }
    val signalNR = cellNewRadio.signal
    signalNR?.let {
        cellData.csiRsrp = it.csiRsrp
        cellData.csiRsrpAsu = it.csiRsrpAsu
        cellData.csiRsrq = it.csiRsrq
        cellData.csiSinr = it.csiSinr
        cellData.ssRsrq = it.ssRsrq
        cellData.ssSinr = it.ssSinr
        cellData.ssRsrp = it.ssRsrp
        cellData.ssRsrpAsu = it.ssRsrpAsu
        cellData.dbm = it.dbm
    }

    cellNR.subscriptionId = cellNewRadio.subscriptionId
    cellData.subscriptionId = cellNewRadio.subscriptionId

    return cellNR
}