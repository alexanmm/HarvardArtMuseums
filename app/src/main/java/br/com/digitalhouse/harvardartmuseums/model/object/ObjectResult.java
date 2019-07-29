
package br.com.digitalhouse.harvardartmuseums.model.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ObjectResult {

    @Expose
    private Info info;

    @Expose
    @SerializedName("records")
    private List<Object> records;

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<Object> getRecords() {
        return records;
    }

    public void setRecords(List<Object> records) {
        this.records = records;
    }

}
