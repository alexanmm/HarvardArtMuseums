
package br.com.digitalhouse.harvardartmuseums.model.gallery;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GalleryResult {

    @Expose
    private Info info;

    @Expose
    @SerializedName("records")
    private List<Gallery> records;

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<Gallery> getRecords() {
        return records;
    }

    public void setRecords(List<Gallery> records) {
        this.records = records;
    }

}
