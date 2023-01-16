package com.airfore.cell_info.models;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.Serializable;

public class SIMInfo implements Serializable {

    private String carrierName;
    private String displayName;
    private int mcc;
    private int mnc;
    private String subscriptionInfoNumber;
    private int subscriptionId;
    private String countryIso;
    private boolean roaming = false;

    /**
     * True if this sim is used as primary one for data communication in multisim environment, false otherwise
     * This is working properly from Android N, It will return false for older versions of android for each sim
     */
    private boolean isDefaultDataSubscription = false;

    public SIMInfo(String carrierName, String displayName, int mcc, int mnc, String subscriptionInfoNumber, int subscriptionId, String countryIso, boolean roaming) {
        this.carrierName = carrierName;
        this.displayName = displayName;
        this.mcc = mcc;
        this.mnc = mnc;
        this.subscriptionInfoNumber = subscriptionInfoNumber;
        this.subscriptionId = subscriptionId;
        this.countryIso = countryIso;
        this.roaming = roaming;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public SIMInfo(String carrierName, String displayName, int mcc, int mnc, String subscriptionInfoNumber, int subscriptionId, boolean isDefaultDataSubscription, String countryIso, boolean roaming) {
        this.carrierName = carrierName;
        this.displayName = displayName;
        this.mcc = mcc;
        this.mnc = mnc;
        this.subscriptionInfoNumber = subscriptionInfoNumber;
        this.subscriptionId = subscriptionId;
        this.isDefaultDataSubscription = isDefaultDataSubscription;
        this.countryIso = countryIso;
        this.roaming = roaming;
    }

    public SIMInfo() {
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getMcc() {
        return mcc;
    }

    public void setMcc(int mcc) {
        this.mcc = mcc;
    }

    public int getMnc() {
        return mnc;
    }

    public void setMnc(int mnc) {
        this.mnc = mnc;
    }

    public String getSubscriptionInfoNumber() {
        return subscriptionInfoNumber;
    }

    public void setSubscriptionInfoNumber(String subscriptionInfoNumber) {
        this.subscriptionInfoNumber = subscriptionInfoNumber;
    }

    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public boolean isDefaultDataSubscription() {
        return isDefaultDataSubscription;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void setDefaultDataSubscription(boolean isDefaultDataSubscription) {
        this.isDefaultDataSubscription = isDefaultDataSubscription;
    }

    public String getCountryIso() {
        return countryIso;
    }

    public void setCountryIso(String countryIso) {
        this.countryIso = countryIso;
    }

    public boolean getRoaming() {
        return roaming;
    }

    public void setRoaming(boolean roaming) {
        this.roaming = roaming;
    }

    @Override
    public String toString() {
        String log = "SIMInfo{" +
                "carrierName='" + carrierName + '\'' +
                ", displayName='" + displayName + '\'' +
                ", mcc=" + mcc +
                ", mnc=" + mnc +
                ", subscriptionInfoNumber='" + subscriptionInfoNumber + '\'' +
                ", subscriptionId='" + subscriptionId + '\'' +
                ", countryIso='" + countryIso + '\'' +
                ", roaming='" + roaming + '\'' ;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            log = log + ", isDefaultDataSubscription='" + isDefaultDataSubscription + '\'';
        }
        log = log + '}';
        return log;
    }
}
