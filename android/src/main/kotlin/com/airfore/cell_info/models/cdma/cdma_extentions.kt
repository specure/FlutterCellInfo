package com.airfore.cell_info.models.cdma

import com.airfore.cell_info.models.CellData
import com.airfore.cell_info.models.common.Band
import com.airfore.cell_info.models.common.Network
import cz.mroczis.netmonster.core.model.cell.CellCdma

fun getCdma(cell: CellCdma, cellData: CellData): CellCDMA {

    val cellCDMA = CellCDMA()
    cellCDMA.type = "CDMA"
    cellData.type = "CDMA"

    cellCDMA.bid = cell.bid
    cellData.bid = cell.bid

    cellCDMA.sid = cell.sid
    cellData.sid = cell.sid

    cellCDMA.nid = cell.nid
    cellData.nid = cell.nid

    cellCDMA.lat = cell.lat
    cellData.lat = cell.lat

    cellCDMA.lon = cell.lon
    cellData.lon = cell.lon

    cellCDMA.connectionStatus = cell.connectionStatus.toString()
    cellData.connectionStatus = cell.connectionStatus.toString()

    cellCDMA.band = Band().apply {
        channelNumber = cell.band?.channelNumber
        number = cell.band?.number
        name = cell.band?.name
    }
    cell.band?.also {
        cellData.bandChannelNumber = it?.channelNumber
        cellData.bandNumber = it?.number
        cellData.bandName = it?.name
    }

    cellCDMA.network = Network().apply {
        iso = cell.network?.iso
        mcc = cell.network?.mcc
        mnc = cell.network?.mnc
    }
    cell.network?.also {
        cellData.iso = it?.iso
        cellData.mcc = it?.mcc
        cellData.mnc = it?.mnc
    }
    cellCDMA.signalCDMA = SignalCDMA().apply {
        cdmaRssi = cell.signal?.cdmaRssi
        cdmaEcio = cell.signal?.cdmaEcio
        evdoRssi = cell.signal?.evdoRssi
        evdoSnr = cell.signal?.evdoSnr
        evdoEcio = cell.signal?.evdoEcio
        dbm = cell.signal?.dbm
    }
    cell.signal?.also {
        cellData.cdmaEcio = it?.cdmaEcio
        cellData.cdmaRssi = it?.cdmaRssi
        cellData.evdoRssi = it?.evdoRssi
        cellData.evdoSnr = it?.evdoSnr
        cellData.evdoEcio = it?.evdoEcio
        cellData.dbm = it?.dbm
    }

    cellCDMA.subscriptionId = cell.subscriptionId
    cellData.subscriptionId = cell.subscriptionId

    return cellCDMA
}

fun getCdmaFake(cell: CellCdma? = null): CellCDMA {

    val cellCDMA = CellCDMA()
    cellCDMA.type = "CDMA"

    cellCDMA.bid = 0
    cellCDMA.connectionStatus =" cell.connectionStatus.toString()"

    cellCDMA.band = Band().apply {
        channelNumber = 0
        number = 0
        name = ""
    }

    cellCDMA.network = Network().apply {
        iso = ""
        mcc = ""
        mnc = ""
    }

    cellCDMA.signalCDMA = SignalCDMA().apply {
        cdmaRssi = 0
        cdmaEcio = 0.0
        evdoRssi = 0
        evdoSnr = 0
        evdoEcio = 0.0
        dbm = 0
    }

    return cellCDMA
}