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

    cellTDSCDMA.bandTDSCDMA = BandTDSCDMA().apply {
        this.channelNumber = cell.band?.channelNumber
        this.name = cell.band?.name
        this.number = cell.band?.number
        this.downlinkUarfcn = cell.band?.downlinkUarfcn
    }
    cell.band?.let {
        cellData.bandChannelNumber = it.channelNumber
        cellData.bandNumber = it.number
        cellData.bandName = it.name
        cellData.downlinkUarfcn = it.downlinkUarfcn
    }

    cellTDSCDMA.network = Network().apply {
        this.iso = cell.network?.iso
        this.mcc = cell.network?.mcc
        this.mnc = cell.network?.mnc
    }
    cell.network?.let {
        cellData.iso = it.iso
        cellData.mcc = it.mcc
        cellData.mnc = it.mnc
    }

    cellTDSCDMA.signalTDSCDMA = SignalTDSCDMA().apply {
        this.bitErrorRate = cell.signal?.bitErrorRate
        this.rssi = cell.signal?.rssi
        this.rscp = cell.signal?.rscp
        this.rscpAsu = cell.signal?.rscpAsu
        this.rssiAsu = cell.signal?.rssiAsu
        this.dbm = cell.signal?.dbm
    }
    cell.signal.let {
        cellData.bitErrorRate = cell.signal?.bitErrorRate
        cellData.rssi = cell.signal?.rssi
        cellData.rscp = cell.signal?.rscp
        cellData.rscpAsu = cell.signal?.rscpAsu
        cellData.rssiAsu = cell.signal?.rssiAsu
        cellData.dbm = cell.signal?.dbm
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

    cellGSM.bandTDSCDMA = BandTDSCDMA().apply {
        this.channelNumber = 0
        this.name = " it.name!!"
        this.number = 0
        this.downlinkUarfcn = 0
    }

    cellGSM.network = Network().apply {
        this.iso = ""
        this.mcc = ""
        this.mnc = ""
    }

    cellGSM.signalTDSCDMA = SignalTDSCDMA().apply {
        this.bitErrorRate = 0
        this.rssi = 0
        this.rscp = 0
        this.rscpAsu = 0
        this.rssiAsu = 0
        this.dbm = 0
    }

    return cellGSM
}
