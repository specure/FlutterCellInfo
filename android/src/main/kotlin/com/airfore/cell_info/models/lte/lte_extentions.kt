package com.airfore.cell_info.models.lte

import com.airfore.cell_info.models.CellData
import com.airfore.cell_info.models.common.Network
import cz.mroczis.netmonster.core.model.cell.CellLte


fun getLte(cell: CellLte, cellData: CellData): CellLTE {

    val cellLTE = CellLTE()
    cellLTE.type = "LTE"
    cellData.type = "LTE"

    cellLTE.bandwidth = cell.bandwidth
    cellData.bandwidth = cell.bandwidth

    cellLTE.connectionStatus = cell.connectionStatus.toString()
    cellData.connectionStatus = cell.connectionStatus.toString()

    cellLTE.bandLTE = BandLTE().apply {
        channelNumber = cell.band?.channelNumber
        number = cell.band?.number
        name = cell.band?.name
        downlinkEarfcn = cell.band?.downlinkEarfcn
    }
    cell.band?.let {
        cellData.bandChannelNumber = it.channelNumber
        cellData.bandNumber = it.number
        cellData.bandName = it.name
        cellData.downlinkEarfcn = it.downlinkEarfcn
    }
    cellLTE.network = Network().apply {
      iso = cell.network?.iso
      mcc = cell.network?.mcc
      mnc = cell.network?.mnc

    }
    cell.network?.let {
        cellData.iso = it.iso
        cellData.mcc = it.mcc
        cellData.mnc = it.mnc
    }

    cellLTE.signalLTE = SignalLTE().apply {
        cqi = cell.signal?.cqi
        rsrpAsu = cell.signal?.rsrpAsu
        rssiAsu = cell.signal?.rssiAsu
        snr = cell.signal?.snr
        timingAdvance = cell.signal?.timingAdvance
        dbm = cell.signal?.dbm
        rssi = cell.signal?.rssi
        rsrp = cell.signal?.rsrp
        rsrq = cell.signal?.rsrq
    }
    cell.signal?.let {
        cellData.cqi = it.cqi
        cellData.rsrpAsu = it.rsrpAsu
        cellData.rssiAsu = it.rssiAsu
        cellData.snr = it.snr
        cellData.timingAdvance = it.timingAdvance
        cellData.dbm = it.dbm
        cellData.rssi = it.rssi
        cellData.rsrp = it.rsrp
        cellData.rsrq = it.rsrq
    }

    cellLTE.eci = cell.eci
    cellData.eci = cell.eci

    cellLTE.cid = cell.cid
    cellData.cid = cell.cid

    cellLTE.enb = cell.enb
    cellData.enb = cell.enb
    cellLTE.tac = cell.tac
    cellData.tac = cell.tac
    cellLTE.pci = cell.pci
    cellLTE.ecgi = cell.ecgi
    cellData.ecgi = cell.ecgi
    cellLTE.subscriptionId = cell.subscriptionId
    cellData.subscriptionId = cell.subscriptionId

    return cellLTE
}

fun getLteFake(cell: CellLte? = null): CellLTE {

    val cellLTE = CellLTE()
    cellLTE.type = "LTE"

    cellLTE.bandwidth = 0
    cellLTE.connectionStatus = " cell.connectionStatus.toString()"

    cellLTE.bandLTE = BandLTE().apply {
        channelNumber = 0
        number = 0
        name = ""
        downlinkEarfcn = 0
    }

    cellLTE.network = Network().apply {
        iso = ""
        mcc = "it.mcc"
        mnc = ""
    }

    cellLTE.signalLTE = SignalLTE().apply {
        cqi = 0
        rsrpAsu = 0
        rssiAsu = 0
        snr = 0.0
        timingAdvance = 0
        dbm = 0
        rssi = 0
        rsrp = 0.0
        rsrq = 0.0
    }

    cellLTE.eci = 0
    cellLTE.cid = 0
    cellLTE.enb = 0
    cellLTE.tac = 0
    cellLTE.pci = 0
    cellLTE.subscriptionId = 0

    return cellLTE
}