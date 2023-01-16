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

    cellNR.bandNR = BandNR()
    cellNewRadio.band?.let {
        cellNR.bandNR.channelNumber = it.channelNumber
        cellData.bandChannelNumber = it.channelNumber

        cellNR.bandNR.number = it.number ?: 0
        cellData.bandNumber = it.number ?: 0

        cellNR.bandNR.downlinkArfcn = it.downlinkArfcn
        cellData.bandDownlinkArfcn = it.downlinkArfcn

        cellNR.bandNR.downlinkFrequency = it.downlinkFrequency
        cellData.bandDownlinkFrequency = it.downlinkFrequency

        cellNR.bandNR.name = it.name ?: ""
        cellData.bandName = it.name
    }

    cellNR.network =
        Network()
    cellNewRadio.network?.let {
        cellNR.network.iso = it.iso
        cellData.iso = it.iso

        cellNR.network.mcc = it.mcc
        cellData.mcc = it.mcc

        cellNR.network.mnc = it.mnc
        cellData.mnc = it.mnc
    }

    cellNR.signalNR = SignalNR()
    val signalNR = cellNewRadio.signal
    signalNR?.let {
        try {
            Log.d("signalNR:", "$signalNR")
            cellNR.signalNR.csiRsrp = it.csiRsrp ?: 0
            cellData.csiRsrp = it.csiRsrp ?: 0

            cellNR.signalNR.csiRsrpAsu = it.csiRsrpAsu ?: 0
            cellData.csiRsrpAsu = it.csiRsrpAsu ?: 0

            cellNR.signalNR.csiRsrq = it.csiRsrq ?: 0
            cellData.csiRsrq = it.csiRsrq ?: 0

            cellNR.signalNR.csiSinr = it.csiSinr ?: 0
            cellData.csiSinr = it.csiSinr ?: 0

            cellNR.signalNR.ssRsrq = it.ssRsrq ?: 0
            cellData.ssRsrq = it.ssRsrq ?: 0

            cellNR.signalNR.ssSinr = it.ssSinr ?: 0
            cellData.ssSinr = it.ssSinr ?: 0

            cellNR.signalNR.ssRsrp = it.ssRsrp ?: 0
            cellData.ssRsrp = it.ssRsrp ?: 0

            cellNR.signalNR.ssRsrpAsu = it.ssRsrpAsu ?: 0
            cellData.ssRsrpAsu = it.ssRsrpAsu ?: 0

            cellNR.signalNR.dbm = it.dbm ?: 0
            cellData.dbm = it.dbm ?: 0
        } catch (e: Exception) {
            e.localizedMessage?.let { ex -> Log.e("signalNR", ex) }
        }
    }

    cellNR.subscriptionId = cellNewRadio.subscriptionId
    cellData.subscriptionId = cellNewRadio.subscriptionId

    return cellNR
}