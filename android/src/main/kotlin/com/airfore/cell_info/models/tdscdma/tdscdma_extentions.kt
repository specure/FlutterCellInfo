package com.airfore.cell_info.models.tdscdma

import com.airfore.cell_info.models.CellData
import com.airfore.cell_info.models.common.Network
import cz.mroczis.netmonster.core.model.cell.CellTdscdma

fun getTdscdma(cell: CellTdscdma, cellData: CellData): CellTDSCDMA {

    val cellTDSCDMA = CellTDSCDMA()
    cellTDSCDMA.type = "TDSCDMA"
    cellData.type = "TDSCDMA"

    cellTDSCDMA.bandTDSCDMA = BandTDSCDMA()
    cellTDSCDMA.connectionStatus = cell.connectionStatus.toString()
    cellData.connectionStatus = cell.connectionStatus.toString()

    cellTDSCDMA.ci = cell.ci
    cellData.ci = cell.ci

    cellTDSCDMA.cid = cell.cid
    cellData.cid = cell.cid

    cellTDSCDMA.lac = cell.lac
    cellData.lac = cell.lac

    cellTDSCDMA.cpid = cell.cpid
    cellData.cpid = cell.cpid

    cellTDSCDMA.rnc = cell.rnc
    cellData.rnc = cell.rnc

    cellTDSCDMA.cgi = cell.cgi
    cellData.cgi = cell.cgi

    cellTDSCDMA.bandTDSCDMA = BandTDSCDMA()
    cell.band?.let {
        cellTDSCDMA.bandTDSCDMA.channelNumber = it.channelNumber
        cellData.bandChannelNumber = it.channelNumber

        cellTDSCDMA.bandTDSCDMA.number = it.number!!
        cellData.bandNumber = it.number

        cellTDSCDMA.bandTDSCDMA.name = it.name!!
        cellData.bandName = it.name!!

        cellTDSCDMA.bandTDSCDMA.downlinkUarfcn = it.downlinkUarfcn
        cellData.downlinkUarfcn = it.downlinkUarfcn
    }

    cellTDSCDMA.network =
            Network()
    cell.network?.let {
        cellTDSCDMA.network.iso = it.iso
        cellData.iso = it.iso
        cellTDSCDMA.network.mcc = it.mcc
        cellData.mcc = it.mcc
        cellTDSCDMA.network.mnc = it.mnc
        cellData.mnc = it.mnc
    }

    cellTDSCDMA.signalTDSCDMA = SignalTDSCDMA()
    cell.signal.let {
        cellTDSCDMA.signalTDSCDMA.bitErrorRate = cell.signal.bitErrorRate!!
        cellData.bitErrorRate = cell.signal.bitErrorRate!!
        cellTDSCDMA.signalTDSCDMA.rssi = cell.signal.rssi!!
        cellData.rssi = cell.signal.rssi!!
        cellTDSCDMA.signalTDSCDMA.rscp = cell.signal.rscp!!
        cellData.rscp = cell.signal.rscp!!
        cellTDSCDMA.signalTDSCDMA.rscpAsu = cell.signal.rscpAsu!!
        cellData.rscpAsu = cell.signal.rscpAsu!!
        cellTDSCDMA.signalTDSCDMA.rssiAsu = cell.signal.rssiAsu!!
        cellData.rssiAsu = cell.signal.rssiAsu!!
        cellTDSCDMA.signalTDSCDMA.dbm = cell.signal.dbm!!
        cellData.dbm = cell.signal.dbm!!
    }


    cellTDSCDMA.subscriptionId = cell.subscriptionId
    cellData.subscriptionId = cell.subscriptionId


    return cellTDSCDMA
}

fun getTdscdmaFake(cell: CellTdscdma? = null): CellTDSCDMA {

    val cellGSM = CellTDSCDMA()
    cellGSM.type = "TDSCDMA"

    cellGSM.bandTDSCDMA = BandTDSCDMA()
    cellGSM.connectionStatus = "cell.connectionStatus.toString()"

    cellGSM.bandTDSCDMA = BandTDSCDMA()
    cellGSM.bandTDSCDMA.channelNumber = 0
    cellGSM.bandTDSCDMA.number = 0
    cellGSM.bandTDSCDMA.name = " it.name!!"
    cellGSM.bandTDSCDMA.downlinkUarfcn = 0

    cellGSM.network =
            Network()
    cellGSM.network.iso = ""
    cellGSM.network.mcc = ""
    cellGSM.network.mnc = ""

    cellGSM.signalTDSCDMA = SignalTDSCDMA()
    cellGSM.signalTDSCDMA.bitErrorRate = 0
    cellGSM.signalTDSCDMA.rssi = 0
    cellGSM.signalTDSCDMA.rscp = 0
    cellGSM.signalTDSCDMA.rscpAsu = 0
    cellGSM.signalTDSCDMA.rssiAsu = 0
    cellGSM.signalTDSCDMA.dbm = 0

    return cellGSM
}
