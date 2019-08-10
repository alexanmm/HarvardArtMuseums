
package br.com.digitalhouse.harvardartmuseums.model.object;

import com.google.gson.annotations.Expose;

public class Image {

    @Expose
    private String baseimageurl;

    @Expose
    private String copyright;

    @Expose
    private Long displayorder;

    @Expose
    private String format;

    @Expose
    private Long height;

    @Expose
    private Long idsid;

    @Expose
    private String iiifbaseuri;

    @Expose
    private Long imageid;

    @Expose
    private String publiccaption;

    @Expose
    private String renditionnumber;

    @Expose
    private Long width;

    public String getBaseimageurl() {
        return baseimageurl;
    }

    public void setBaseimageurl(String baseimageurl) {
        this.baseimageurl = baseimageurl;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Long getDisplayorder() {
        return displayorder;
    }

    public void setDisplayorder(Long displayorder) {
        this.displayorder = displayorder;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public Long getIdsid() {
        return idsid;
    }

    public void setIdsid(Long idsid) {
        this.idsid = idsid;
    }

    public String getIiifbaseuri() {
        return iiifbaseuri;
    }

    public void setIiifbaseuri(String iiifbaseuri) {
        this.iiifbaseuri = iiifbaseuri;
    }

    public Long getImageid() {
        return imageid;
    }

    public void setImageid(Long imageid) {
        this.imageid = imageid;
    }

    public String getPubliccaption() {
        return publiccaption;
    }

    public void setPubliccaption(String publiccaption) {
        this.publiccaption = publiccaption;
    }

    public String getRenditionnumber() {
        return renditionnumber;
    }

    public void setRenditionnumber(String renditionnumber) {
        this.renditionnumber = renditionnumber;
    }

    public Long getWidth() {
        return width;
    }

    public void setWidth(Long width) {
        this.width = width;
    }

}
