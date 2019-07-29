
package br.com.digitalhouse.harvardartmuseums.model.gallery;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;

@Entity(tableName = "tab_gallery")
public class Gallery {

    @Expose
    private Long floor;

    @Expose
    private Long galleryid;

    @Expose
    private String gallerynumber;

    @Expose
    @PrimaryKey
    private Long id;

    @Expose
    private String labeltext;

    @Expose
    private String lastupdate;

    @Expose
    private String name;

    @Expose
    private Long objectcount;

    @Expose
    private String theme;

    @Expose
    private String url;

    public Gallery() {
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabeltext() {
        return labeltext;
    }

    public void setLabeltext(String labeltext) {
        this.labeltext = labeltext;
    }

    public String getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(String lastupdate) {
        this.lastupdate = lastupdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getObjectcount() {
        return objectcount;
    }

    public void setObjectcount(Long objectcount) {
        this.objectcount = objectcount;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
