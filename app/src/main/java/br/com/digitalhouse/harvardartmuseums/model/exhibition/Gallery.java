
package br.com.digitalhouse.harvardartmuseums.model.exhibition;

import com.google.gson.annotations.Expose;

public class Gallery {

    @Expose
    private Long floor;

    @Expose
    private Long galleryid;

    @Expose
    private String gallerynumber;

    @Expose
    private String name;

    public Long getFloor() {
        return floor;
    }

    public void setFloor(Long floor) {
        this.floor = floor;
    }

    public Long getGalleryid() {
        return galleryid;
    }

    public void setGalleryid(Long galleryid) {
        this.galleryid = galleryid;
    }

    public String getGallerynumber() {
        return gallerynumber;
    }

    public void setGallerynumber(String gallerynumber) {
        this.gallerynumber = gallerynumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
