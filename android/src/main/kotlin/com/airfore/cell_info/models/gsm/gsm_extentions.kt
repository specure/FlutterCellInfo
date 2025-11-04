package com.airfore.cell_info.models.gsm

import com.airfore.cell_info.models.CellData
import com.airfore.cell_info.models.common.Network
import cz.mroczis.netmonster.core.model.cell.CellGsm

fun getGsm(cell: CellGsm, cellData: CellData): CellGSM {

    val cellGSM = CellGSM()
    cellGSM.type = "GSM"
    cellData.type = "GSM"

    cellGSM.connectionStatus = cell.connectionStatus.toString()
    cellData.connectionStatus = cell.connectionStatus.toString()

    cellGSM.cid = cell.cid
    cellData.cid = cell.cid

    cellGSM.lac = cell.lac
    cellData.lac = cell.lac

    cellGSM.bsic = cell.bsic
    cellData.bsic = cell.bsic

    cellGSM.bandGSM = BandGSM().apply {
        channelNumber = cell.band?.channelNumber
        number = cell.band?.number
        name = cell.band?.name
        arfcn = cell.band?.arfcn
    }
    cellData.bandChannelNumber = cell.band?.channelNumber
    cellData.bandNumber = cell.band?.number
    cellData.bandName = cell.band?.name
    cellData.arfcn = cell.band?.arfcn

    cellGSM.network = Network().apply {
        iso = cell.network?.iso
        mcc = cell.network?.mcc
        mnc = cell.network?.mnc
    }

    cellGSM.signalGSM = SignalGSM().apply {
        bitErrorRate = cell.signal.bitErrorRate
        rssi = cell.signal.rssi
        timingAdvance = cell.signal.timingAdvance
        dbm = cell.signal.dbm
    }

    cellData.dbm = cell.signal.dbm
    cellData.bitErrorRate = cell.signal.bitErrorRate
    cellData.rssi = cell.signal.rssi
    cellData.timingAdvance = cell.signal.timingAdvance

    cellGSM.subscriptionId = cell.subscriptionId
    cellData.subscriptionId = cell.subscriptionId

    return cellGSM
}

fun getGsmFake(cell: CellGsm? = null): CellGSM {

    val cellGSM = CellGSM()
    cellGSM.type = "GSM"

    cellGSM.bandGSM = BandGSM()
    cellGSM.connectionStatus = "cell.connectionStatus.toString()"

    cellGSM.bandGSM = BandGSM().apply {
        channelNumber = 2
        number = 0
        name = ""
        arfcn = 0
    }

    cellGSM.network = Network().apply {
        iso = ""
        mcc = ""
        mnc = ""
    }

    cellGSM.signalGSM = SignalGSM().apply {
        bitErrorRate = 0
        rssi = 0
        timingAdvance = 0
        dbm = 0
    }

    return cellGSM
}