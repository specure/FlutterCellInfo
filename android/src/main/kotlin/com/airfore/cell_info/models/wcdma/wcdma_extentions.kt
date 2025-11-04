package com.airfore.cell_info.models.wcdma

import com.airfore.cell_info.models.CellData
import com.airfore.cell_info.models.common.Network
import cz.mroczis.netmonster.core.model.band.BandWcdma
import cz.mroczis.netmonster.core.model.cell.CellWcdma
import cz.mroczis.netmonster.core.model.connection.PrimaryConnection
import cz.mroczis.netmonster.core.model.signal.SignalWcdma

fun getWcdma(cell: CellWcdma, cellData: CellData): CellWCDMA {

    val cellWCDMA = CellWCDMA()
    cellWCDMA.type = "WCDMA"
    cellData.type = "WCDMA"

    cellWCDMA.bandWCDMA = BandWCDMA()
    cellWCDMA.connectionStatus = cell.connectionStatus.toString()
    cellData.connectionStatus = cell.connectionStatus.toString()

    cellWCDMA.ci = cell.ci
    cellData.ci = cell.ci

    cellWCDMA.cid = cell.cid
    cellData.cid = cell.cid

    cellWCDMA.lac = cell.lac
    cellData.lac = cell.lac

    cellWCDMA.psc = cell.psc
    cellData.psc = cell.psc

    cellWCDMA.rnc = cell.rnc
    cellData.rnc = cell.rnc

    cellWCDMA.cgi = cell.cgi
    cellData.cgi = cell.cgi

    cellWCDMA.bandWCDMA = BandWCDMA().apply {
        cell.band?.let {
            channelNumber = it.channelNumber
            number = it.number
            name = it.name
        }
    }
    cell.band?.let {
        cellData.bandChannelNumber = it.channelNumber
        cellData.bandNumber = it.number
        cellData.bandName = it.name
        cellData.downlinkUarfcn = it.downlinkUarfcn
    }

    cellWCDMA.network = Network().apply {
        cell.network?.let {
            iso = it.iso
            mcc = it.mcc
            mnc = it.mnc
        }
    }
    cell.network?.let {
        cellData.iso = it.iso
        cellData.mcc = it.mcc
        cellData.mnc = it.mnc
    }

    cellWCDMA.signalWCDMA = SignalWCDMA().apply {
        cell.signal.let {
            bitErrorRate = it.bitErrorRate
            rssi = it.rssi
            rscp = it.rscp
            rscpAsu = it.rscpAsu
            rssiAsu = it.rssiAsu
            ecno = it.ecno
            ecio = it.ecio
            dbm = it.dbm
        }
    }
    cell.signal.let {
        cellData.bitErrorRate = it.bitErrorRate
        cellData.rssi = it.rssi
        cellData.rscp = it.rscp
        cellData.rscpAsu = it.rscpAsu
        cellData.rssiAsu = it.rssiAsu
        cellData.ecno = it.ecno
        cellData.ecio = it.ecio
        cellData.dbm = it.dbm
    }

    cellWCDMA.subscriptionId = cell.subscriptionId
    cellData.subscriptionId = cell.subscriptionId

    return cellWCDMA
}


fun getWcdmaFake(
    cell: CellWcdma = CellWcdma(
        network = cz.mroczis.netmonster.core.model.Network(
            "",
            "",
            ""
        ),
        band = BandWcdma(
            downlinkUarfcn = 0,
            name = "",
            number = 0
        ),
        ci = 0,
        connectionStatus = PrimaryConnection(),
        lac = 0,
        psc = 0,
        signal = SignalWcdma(
            rssi = -100,
            bitErrorRate = 0,
            ecio = 0, ecno = 0, rscp = -100

        ),
        subscriptionId = 0,
        timestamp = System.currentTimeMillis()
    )
): CellWCDMA {

    val cellGSM = CellWCDMA()
    cellGSM.type = "WCDMA"

    cellGSM.bandWCDMA = BandWCDMA()
    cellGSM.connectionStatus = "cell.connectionStatus.toString()"

    cellGSM.bandWCDMA = BandWCDMA().apply {
        cell.band?.let {
            channelNumber = 0
            number = 0
            name = "0"
            downlinkUarfcn = 0
        }
    }

    cellGSM.network =
        Network().apply {
            cell.network?.let {
                 iso = "it.iso"
                 mcc = "it.mcc"
                 mnc = "it.mnc"
            }
        }

    cellGSM.signalWCDMA = SignalWCDMA().apply {
        cell.signal.let {
            bitErrorRate = 0
            rssi = 0
            rscp = 0
            rscpAsu = 0
            rssiAsu = 0
            ecno = 0
            ecio = 0
            dbm = 0
        }
    }

    return cellGSM
}