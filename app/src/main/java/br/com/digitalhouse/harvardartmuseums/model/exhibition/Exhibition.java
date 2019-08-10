
package br.com.digitalhouse.harvardartmuseums.model.exhibition;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;

import java.util.List;

@Entity(tableName = "tab_exhibition")
public class Exhibition implements Parcelable {

    @Expose
    private String begindate;

    @Expose
    private String color;

    @Expose
    private String description;

    @Expose
    private String enddate;

    @Expose
    @PrimaryKey
    private Long exhibitionid;

    @Expose
    private Long id;

    @Expose
    private List<ImageExhibition> images;

    @Expose
    private String lastupdate;

    @Expose
    private List<PersonExhibition> people;

    @Expose
    private PosterExhibition poster;

    @Expose
    private String primaryimageurl;

    @Expose
    private String shortdescription;

    @Expose
    private Long temporalorder;

    @Expose
    private String textiledescription;

    @Expose
    private String title;

    @Expose
    private String url;

    @Expose
    private List<Venue> venues;

    public Exhibition() {
    }

    protected Exhibition(Parcel in) {
        begindate = in.readString();
        color = in.readString();
        description = in.readString();
        enddate = in.readString();
        if (in.readByte() == 0) {
            exhibitionid = null;
        } else {
            exhibitionid = in.readLong();
        }
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        lastupdate = in.readString();
        primaryimageurl = in.readString();
        shortdescription = in.readString();
        if (in.readByte() == 0) {
            temporalorder = null;
        } else {
            temporalorder = in.readLong();
        }
        textiledescription = in.readString();
        title = in.readString();
        url = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(begindate);
        dest.writeString(color);
        dest.writeString(description);
        dest.writeString(enddate);
        if (exhibitionid == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(exhibitionid);
        }
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(id);
        }
        dest.writeString(lastupdate);
        dest.writeString(primaryimageurl);
        dest.writeString(shortdescription);
        if (temporalorder == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(temporalorder);
        }
        dest.writeString(textiledescription);
        dest.writeString(title);
        dest.writeString(url);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Exhibition> CREATOR = new Creator<Exhibition>() {
        @Override
        public Exhibition createFromParcel(Parcel in) {
            return new Exhibition(in);
        }

        @Override
        public Exhibition[] newArray(int size) {
            return new Exhibition[size];
        }
    };

    public String getBegindate() {
        return begindate;
    }

    public void setBegindate(String begindate) {
        this.begindate = begindate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public Long getExhibitionid() {
        return exhibitionid;
    }

    public void setExhibitionid(Long exhibitionid) {
        this.exhibitionid = exhibitionid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ImageExhibition> getImages() {
        return images;
    }

    public void setImages(List<ImageExhibition> images) {
        this.images = images;
    }

    public String getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(String lastupdate) {
        this.lastupdate = lastupdate;
    }

    public List<PersonExhibition> getPeople() {
        return people;
    }

    public void setPeople(List<PersonExhibition> people) {
        this.people = people;
    }

    public PosterExhibition getPoster() {
        return poster;
    }

    public void setPoster(PosterExhibition poster) {
        this.poster = poster;
    }

    public String getPrimaryimageurl() {
        return primaryimageurl;
    }

    public void setPrimaryimageurl(String primaryimageurl) {
        this.primaryimageurl = primaryimageurl;
    }

    public String getShortdescription() {
        return shortdescription;
    }

    public void setShortdescription(String shortdescription) {
        this.shortdescription = shortdescription;
    }

    public Long getTemporalorder() {
        return temporalorder;
    }

    public void setTemporalorder(Long temporalorder) {
        this.temporalorder = temporalorder;
    }

    public String getTextiledescription() {
        return textiledescription;
    }

    public void setTextiledescription(String textiledescription) {
        this.textiledescription = textiledescription;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Venue> getVenues() {
        return venues;
    }

    public void setVenues(List<Venue> venues) {
        this.venues = venues;
    }
}
