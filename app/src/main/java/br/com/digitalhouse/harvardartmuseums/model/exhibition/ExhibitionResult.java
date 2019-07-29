
package br.com.digitalhouse.harvardartmuseums.model.exhibition;

import com.google.gson.annotations.Expose;

import java.util.List;

public class ExhibitionResult {

    @Expose
    private Info info;

    @Expose
    private List<Exhibition> records;

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<Exhibition> getRecords() {
        return records;
    }

    public void setRecords(List<Exhibition> records) {
        this.records = records;
    }

}
