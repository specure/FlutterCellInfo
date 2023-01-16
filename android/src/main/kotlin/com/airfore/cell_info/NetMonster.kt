package com.airfore.cell_info

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.telephony.SubscriptionManager
import android.telephony.SubscriptionManager.INVALID_SUBSCRIPTION_ID
import android.util.Log
import androidx.annotation.RequiresApi
import com.airfore.cell_info.extensions.io
import com.airfore.cell_info.models.*
import com.airfore.cell_info.models.cdma.getCdma
import com.airfore.cell_info.models.gsm.getGsm
import com.airfore.cell_info.models.lte.getLte
import com.airfore.cell_info.models.nr.getNr
import com.airfore.cell_info.models.tdscdma.getTdscdma
import com.airfore.cell_info.models.wcdma.getWcdma
import com.google.gson.Gson
import cz.mroczis.netmonster.core.db.model.NetworkType
import cz.mroczis.netmonster.core.factory.NetMonsterFactory
import cz.mroczis.netmonster.core.model.cell.*
import cz.mroczis.netmonster.core.model.connection.PrimaryConnection
import cz.mroczis.netmonster.core.model.nr.NrNsaState
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList


class NetMonster {
    private val TAG = "NetMonster"

    private val primaryCellList: MutableList<CellType> = ArrayList()
    private val neighboringCellList: MutableList<CellType> = ArrayList()
    private val cellDataList: MutableList<CellData> = ArrayList()

    @SuppressLint("MissingPermission")
    fun requestData(
        context: Context,
        result: io.flutter.plugin.common.MethodChannel.Result? = null
    ) = io {
        NetMonsterFactory.get(context).apply {
            val merged = getCells()
            val distinctSubscriptionIds = merged.distinctBy { it.subscriptionId }
            val networkTypes = mutableMapOf<Int, NetworkType>()
            distinctSubscriptionIds.forEach {
                networkTypes[it.subscriptionId] = getNetworkType(it.subscriptionId)
                Log.d(
                    "NetworkTypeDetected",
                    "subscription ${it.subscriptionId} with network type ${networkTypes[it.subscriptionId]}"
                )
            }
            merged.forEach { cell ->
                val cellData = CellData()
                cellData.timestamp = System.currentTimeMillis()
                Log.d("timestamptimestamp", "requestData: ${cellData.timestamp}")
                when (cell) {

                    is CellNr -> {
                        Log.d(TAG, "requestData: NR $cell and $cellData")

                        val cellType = CellType()
                        cellType.nr = getNr(cell, cellData)
                        cellType.type = "NR"
                        when (cell.connectionStatus) {
                            is PrimaryConnection -> {
                                cellType.networkType =
                                    networkTypes[cell.subscriptionId]?.technology.toString()
                                networkTypes[cell.subscriptionId]?.let {
                                    if (it is NetworkType.Nr.Nsa) {
                                        cellType.nrAvailable = it.nrNsaState.nrAvailable
                                        cellType.enDcAvailable = it.nrNsaState.enDcAvailable
                                        cellType.nrConnected =
                                            it.nrNsaState.connection is NrNsaState.Connection.Connected
                                        cellType.nrConnectionStatus = getNrConnectionStatus(it.nrNsaState.connection)
                                    }
                                }
                                primaryCellList.add(cellType)
                            }
                            else -> {
                                neighboringCellList.add(cellType)
                            }
                        }
                        cellDataList.add(cellData)

                    }
                    is CellLte -> {
                        Log.d(TAG, "requestData: LTE")

                        val cellType = CellType()


                        cellType.lte = getLte(cell, cellData)
                        cellType.type = "LTE"
                        when (cell.connectionStatus) {
                            is PrimaryConnection -> {
                                cellType.networkType =
                                    networkTypes[cell.subscriptionId]?.technology.toString()
                                networkTypes[cell.subscriptionId]?.let {
                                    if (it is NetworkType.Nr.Nsa) {
                                        cellType.nrAvailable = it.nrNsaState.nrAvailable
                                        cellType.enDcAvailable = it.nrNsaState.enDcAvailable
                                        cellType.nrConnected =
                                            it.nrNsaState.connection is NrNsaState.Connection.Connected
                                        cellType.nrConnectionStatus = getNrConnectionStatus(it.nrNsaState.connection)
                                    }
                                }
                                primaryCellList.add(cellType)
                            }
                            else -> {
                                neighboringCellList.add(cellType)
                            }
                        }
                        cellDataList.add(cellData)
                    }
                    is CellWcdma -> {
                        Log.d(TAG, "requestData: WCDMA")

                        val cellType = CellType()


                        cellType.wcdma = getWcdma(cell, cellData)
                        cellType.type = "WCDMA"
                        when (cell.connectionStatus) {
                            is PrimaryConnection -> {
                                cellType.networkType =
                                    networkTypes[cell.subscriptionId]?.technology.toString()
                                primaryCellList.add(cellType)
                            }
                            else -> {
                                neighboringCellList.add(cellType)
                            }
                        }
                        cellDataList.add(cellData)

                    }
                    is CellCdma -> {
                        Log.d(TAG, "requestData: CDMA")

                        val cellType = CellType()


                        cellType.cdma = getCdma(cell, cellData)
                        cellType.type = "WCDMA"
                        when (cell.connectionStatus) {
                            is PrimaryConnection -> {
                                cellType.networkType =
                                    networkTypes[cell.subscriptionId]?.technology.toString()
                                primaryCellList.add(cellType)
                            }
                            else -> {
                                neighboringCellList.add(cellType)
                            }
                        }

                        cellDataList.add(cellData)
                    }
                    is CellGsm -> {
                        Log.d(TAG, "requestData: GSM")


                        val cellType = CellType()


                        cellType.gsm = getGsm(cell, cellData)
                        cellType.type = "GSM"
                        when (cell.connectionStatus) {
                            is PrimaryConnection -> {
                                cellType.networkType =
                                    networkTypes[cell.subscriptionId]?.technology.toString()
                                primaryCellList.add(cellType)
                            }
                            else -> {
                                neighboringCellList.add(cellType)
                            }
                        }
                        cellDataList.add(cellData)
                    }
                    is CellTdscdma -> {
                        Log.d(TAG, "requestData: TDSCDMA")

                        val cellType = CellType()

                        cellType.tdscdma = getTdscdma(cell, cellData)
                        cellType.type = "TDSCDMA"
                        when (cell.connectionStatus) {
                            is PrimaryConnection -> {
                                cellType.networkType =
                                    networkTypes[cell.subscriptionId]?.technology.toString()
                                primaryCellList.add(cellType)
                            }
                            else -> {
                                neighboringCellList.add(cellType)
                            }
                        }
                        cellDataList.add(cellData)
                    }

                    else -> {
                        Log.d(TAG, "requestData: ")
                    }

                }
            }
            Log.d("NTM-RES", " \n${merged.joinToString(separator = "\n")}")
        }

        val cellsResponse = CellsResponse()
        cellsResponse.neighboringCellList = neighboringCellList
        cellsResponse.primaryCellList = primaryCellList
        cellsResponse.cellDataList = cellDataList

        cellDataList.forEach {
            Log.d("it.subscriptionId", "requestData: ${it.type}")
            Log.d("it.subscriptionId", "requestData: ${it.subscriptionId}")
        }


        Log.d(TAG, "requestData: " + Gson().toJson(cellsResponse))
        result?.success(Gson().toJson(cellsResponse))
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP_MR1)
    fun simsInfo(context: Context, result: io.flutter.plugin.common.MethodChannel.Result? = null) =
        io {

            val simInfoLists = ArrayList<SIMInfo>()
            try {
                val subscriptionManager =
                    context.getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE) as SubscriptionManager
                val activeSubscriptionInfoList = subscriptionManager.activeSubscriptionInfoList
                val defaultDataSubscriptionId =
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        SubscriptionManager.getDefaultDataSubscriptionId()
                    } else {
                        INVALID_SUBSCRIPTION_ID
                    }
                for (subscriptionInfo in activeSubscriptionInfoList) {
                    val carrierName = subscriptionInfo.carrierName
                    val displayName = subscriptionInfo.displayName
                    val countryIso = subscriptionInfo.countryIso
                    val roaming = subscriptionInfo.dataRoaming == SubscriptionManager.DATA_ROAMING_ENABLE
                    val mcc = subscriptionInfo.mcc
                    val mnc = subscriptionInfo.mnc
                    val subscriptionInfoNumber = subscriptionInfo.number
                    val subscriptionId = subscriptionInfo.subscriptionId
                    val isDefaultDataSubscription =
                        subscriptionId == defaultDataSubscriptionId // notice, that this work from android N
                    Log.d(TAG, "carrierName: ${carrierName}")
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        simInfoLists.add(
                            SIMInfo(
                                carrierName.toString(),
                                displayName.toString(),
                                mcc,
                                mnc,
                                subscriptionInfoNumber,
                                subscriptionId,
                                isDefaultDataSubscription,
                                countryIso,
                                roaming
                            )
                        )
                    } else {
                        simInfoLists.add(
                            SIMInfo(
                                carrierName.toString(),
                                displayName.toString(),
                                mcc,
                                mnc,
                                subscriptionInfoNumber,
                                subscriptionId,
                                countryIso,
                                roaming
                            )
                        )
                    }
                }

                val json = Gson().toJson(SIMInfoResponse(simInfoLists))
                Log.d(TAG, "simsInfo: ${json}")
                result?.success(json)
            } catch (e: Exception) {
                Log.e("NetMonster", "Error getting sims info: ${e.localizedMessage}")
            }
        }

    private fun getNrConnectionStatus(connection: NrNsaState.Connection): String {
        return when (connection) {
            is NrNsaState.Connection.Connected -> "connected"
            is NrNsaState.Connection.Disconnected -> "disconnected"
            is NrNsaState.Connection.Rejected -> "rejected"
            else -> "disconnected"
        }
    }
}


// region fake data
//
//        val wcdmaCellType = CellType()
//        wcdmaCellType.wcdma = getWcdmaFake()
//        wcdmaCellType.type = "WCDMA"
//        cellsResponse.neighboringCellList.add(wcdmaCellType)
//        cellsResponse.primaryCellList.add(wcdmaCellType)
//
//        val nrCellType = CellType()
//        nrCellType.nr = getNrFake()
//        nrCellType.type = "NR"
//        cellsResponse.neighboringCellList.add(nrCellType)
//        cellsResponse.primaryCellList.add(nrCellType)
//
//        val LTECellType = CellType()
//        LTECellType.lte = getLteFake()
//        LTECellType.type = "LTE"
//        cellsResponse.neighboringCellList.add(LTECellType)
//        cellsResponse.primaryCellList.add(LTECellType)
//
//
//        val gsmType = CellType()
//        gsmType.gsm = getGsmFake()
//        gsmType.type = "GSM"
//        cellsResponse.neighboringCellList.add(gsmType)
//        cellsResponse.primaryCellList.add(gsmType)
//
//        val tdscdmaCellType = CellType()
//        tdscdmaCellType.tdscdma = getTdscdmaFake()
//        tdscdmaCellType.type = "tdscdma"
//        cellsResponse.neighboringCellList.add(tdscdmaCellType)
//        cellsResponse.primaryCellList.add(tdscdmaCellType)
//
//
//        val cdmaCellType = CellType()
//        cdmaCellType.cdma = getCdmaFake()
//        cdmaCellType.type = "CDMA"
//        cellsResponse.neighboringCellList.add(cdmaCellType)
//        cellsResponse.primaryCellList.add(cdmaCellType)
//endregion
