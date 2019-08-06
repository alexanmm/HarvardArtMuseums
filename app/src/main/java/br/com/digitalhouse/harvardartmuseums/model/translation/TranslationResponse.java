package br.com.digitalhouse.harvardartmuseums.model.translation;

import com.google.gson.annotations.Expose;

public class TranslationResponse {

    @Expose
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
