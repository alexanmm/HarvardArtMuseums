
package br.com.digitalhouse.harvardartmuseums.model.object;

import com.google.gson.annotations.Expose;

public class Color {

    @Expose
    private String color;

    @Expose
    private String css3;

    @Expose
    private String hue;

    @Expose
    private Double percent;

    @Expose
    private String spectrum;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCss3() {
        return css3;
    }

    public void setCss3(String css3) {
        this.css3 = css3;
    }

    public String getHue() {
        return hue;
    }

    public void setHue(String hue) {
        this.hue = hue;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    public String getSpectrum() {
        return spectrum;
    }

    public void setSpectrum(String spectrum) {
        this.spectrum = spectrum;
    }

}
