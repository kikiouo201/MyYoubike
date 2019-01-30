package com.example.yanghuiwen.myyoubike.model;
import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class StationResponse {
    @SerializedName("retCode")
    private int retCode;

    @SerializedName("retVal")
    private Map<String, Station> retVal;


    public int getRetCode() {
        Log.i("test","getRetCode");
        return retCode;
    }

    public void setRetCode(int retCode) {
        Log.i("test","setRetCode");
        this.retCode = retCode;
    }

    public Map<String, Station> getRetVal() {
        return retVal;
    }

    public void setRetVal(Map<String, Station> retVal) {
        Log.i("test","setretVal="+retVal);
        this.retVal = retVal;
    }

    public class Station {
        @SerializedName("sna")
        private String sna;

        @SerializedName("tot")
        private String tot;

        @SerializedName("sbi")
        private String sbi;

        @SerializedName("lat")
        private String lat;

        @SerializedName("lng")
        private String lng;

        @SerializedName("bemp")
        private String bemp;

        @SerializedName("act")
        private String act;

        @SerializedName("sno")
        private String sno;

        @SerializedName("sarea")
        private String sarea;

        @SerializedName("mday")
        private String mday;

        @SerializedName("ar")
        private String ar;

        @SerializedName("sareaen")
        private String sareaen;

        @SerializedName("snaen")
        private String snaen;

        @SerializedName("aren")
        private String aren;


        public String getSna() {
            return sna;
        }

        public void setSna(String sna) {
            this.sna = sna;
        }

        public String getTot() {
            return tot;
        }

        public void setTot(String tot) {
            this.tot = tot;
        }

        public String getSbi() {
            return sbi;
        }

        public void setSbi(String sbi) {
            this.sbi = sbi;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        public String getBemp() {
            return bemp;
        }

        public void setBemp(String bemp) {
            this.bemp = bemp;
        }

        public String getAct() {
            return act;
        }

        public void setAct(String act) {
            this.act = act;
        }

        public String getSno() {
            return sno;
        }

        public void setSno(String sno) {
            this.sno = sno;
        }

        public String getSarea() {
            return sarea;
        }

        public void setSarea(String sarea) {
            this.sarea = sarea;
        }

        public String getMday() {
            return mday;
        }

        public void setMday(String mday) {
            this.mday = mday;
        }

        public String getAr() {
            return ar;
        }

        public void setAr(String ar) {
            this.ar = ar;
        }

        public String getSareaen() {
            return sareaen;
        }

        public void setSareaen(String sareaen) {
            this.sareaen = sareaen;
        }

        public String getSnaen() {
            return snaen;
        }

        public void setSnaen(String snaen) {
            this.snaen = snaen;
        }

        public String getAren() {
            return aren;
        }

        public void setAren(String aren) {
            this.aren = aren;
        }

    }
}