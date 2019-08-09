
package br.com.digitalhouse.harvardartmuseums.model.translation;

import com.google.gson.annotations.SerializedName;

public class PostBodyTranslation {

    @SerializedName("SL")
    private String sL;

    @SerializedName("T")
    private String t;

    @SerializedName("TL")
    private String tL;

    public PostBodyTranslation() {
    }

    public PostBodyTranslation(String sL, String t, String tL) {
        this.sL = sL;
        this.t = t;
        this.tL = tL;
    }

    public String getSL() {
        return sL;
    }

    public void setSL(String sL) {
        this.sL = sL;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public String getTL() {
        return tL;
    }

    public void setTL(String tL) {
        this.tL = tL;
    }

}
