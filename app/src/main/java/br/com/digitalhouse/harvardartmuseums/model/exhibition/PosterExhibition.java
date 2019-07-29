
package br.com.digitalhouse.harvardartmuseums.model.exhibition;

import com.google.gson.annotations.Expose;

public class PosterExhibition {

    @Expose
    private String caption;

    @Expose
    private String imageurl;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

}
