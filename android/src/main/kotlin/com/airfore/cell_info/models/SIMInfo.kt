package com.airfore.cell_info.models

import android.os.Build
import androidx.annotation.RequiresApi
import java.io.Serializable

class SIMInfo : Serializable {
    var carrierName: String? = null
    var displayName: String? = null
    var mcc: Int? = null
    var mnc: Int? = null
    var subscriptionInfoNumber: String? = null
    var subscriptionId: Int? = null
    var countryIso: String? = null
    private var networkCountryIso: String? = null
    var roaming: Boolean? = null

    /**
     * True if this sim is used as primary one for data communication in multisim environment, false otherwise
     * This is working properly from Android N, It will return false for older versions of android for each sim
     */
    @get:RequiresApi(api = Build.VERSION_CODES.N)
    @set:RequiresApi(api = Build.VERSION_CODES.N)
    var isDefaultDataSubscription: Boolean? = null

    constructor(
        carrierName: String?,
        displayName: String?,
        mcc: Int?,
        mnc: Int?,
        subscriptionInfoNumber: String?,
        subscriptionId: Int?,
        countryIso: String?,
        networkCountryIso: String?,
        roaming: Boolean?
    ) {
        this.carrierName = carrierName
        this.displayName = displayName
        this.mcc = mcc
        this.mnc = mnc
        this.subscriptionInfoNumber = subscriptionInfoNumber
        this.subscriptionId = subscriptionId
        this.countryIso = countryIso
        this.networkCountryIso = networkCountryIso
        this.roaming = roaming
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    constructor(
        carrierName: String?,
        displayName: String?,
        mcc: Int?,
        mnc: Int?,
        subscriptionInfoNumber: String?,
        subscriptionId: Int?,
        isDefaultDataSubscription: Boolean?,
        countryIso: String?,
        networkCountryIso: String?,
        roaming: Boolean?
    ) {
        this.carrierName = carrierName
        this.displayName = displayName
        this.mcc = mcc
        this.mnc = mnc
        this.subscriptionInfoNumber = subscriptionInfoNumber
        this.subscriptionId = subscriptionId
        this.isDefaultDataSubscription = isDefaultDataSubscription
        this.countryIso = countryIso
        this.networkCountryIso = networkCountryIso
        this.roaming = roaming
    }

    constructor()

    fun getNetworkCountryIso(): String? {
        return networkCountryIso
    }

    fun setNetworkCountryIso(networkCountryIso: String?) {
        this.networkCountryIso = countryIso
    }

    override fun toString(): String {
        var log = "SIMInfo{" +
                "carrierName='" + carrierName + '\'' +
                ", displayName='" + displayName + '\'' +
                ", mcc=" + mcc +
                ", mnc=" + mnc +
                ", subscriptionInfoNumber='" + subscriptionInfoNumber + '\'' +
                ", subscriptionId='" + subscriptionId + '\'' +
                ", countryIso='" + countryIso + '\'' +
                ", networkCountryIso='" + networkCountryIso + '\'' +
                ", roaming='" + roaming + '\''

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            log = log.toString() + ", isDefaultDataSubscription='" + isDefaultDataSubscription + '\''
        }
        log = log + '}'
        return log
    }
}
