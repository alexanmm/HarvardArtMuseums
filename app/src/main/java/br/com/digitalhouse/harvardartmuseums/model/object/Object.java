
package br.com.digitalhouse.harvardartmuseums.model.object;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;

import java.util.List;

@Entity(tableName = "tab_object")
public class Object implements Parcelable{

    @Expose
    private String accessionmethod;

    @Expose
    private Long accessionyear;

    @Expose
    private Long accesslevel;

    @Expose
    private String century;

    @Expose
    private String classification;

    @Expose
    private Long classificationid;

    @Expose
    private Long colorcount;

    @Expose
    private List<Color> colors;

    @Expose
    private String commentary;

    @Expose
    private String contact;

    @Expose
    private Long contextualtextcount;

    @Expose
    private String copyright;

    @Expose
    private String creditline;

    @Expose
    private String culture;

    @Expose
    private Long datebegin;

    @Expose
    private String dated;

    @Expose
    private Long dateend;

    @Expose
    private String dateoffirstpageview;

    @Expose
    private String dateoflastpageview;

    @Expose
    private String department;

    @Expose
    private String description;

    @Expose
    private String dimensions;

    @Expose
    private String division;

    @Expose
    private String edition;

    @Expose
    private Long exhibitioncount;

    @Expose
    private Long groupcount;

    @Expose
    private Long id;

    @Expose
    private Long imagecount;

    @Expose
    private Long imagepermissionlevel;

    @Expose
    private List<Image> images;

    @Expose
    private String labeltext;

    @Expose
    private String lastupdate;

    @Expose
    private Long markscount;

    @Expose
    private Long mediacount;

    @Expose
    private String medium;

    @Expose
    private Long objectid;

    @Expose
    @PrimaryKey
    @NonNull
    private String objectnumber;

    @Expose
    private int galleryNumber;

    @Expose
    private List<Person> people;

    @Expose
    private Long peoplecount;

    @Expose
    private String period;

    @Expose
    private String periodid;

    @Expose
    private String primaryimageurl;

    @Expose
    private String provenance;

    @Expose
    private Long publicationcount;

    @Expose
    private Long rank;

    @Expose
    private Long relatedcount;

    @Expose
    private List<SeeAlso> seeAlso;

    @Expose
    private String signed;

    @Expose
    private String standardreferencenumber;

    @Expose
    private String state;

    @Expose
    private String style;

    @Expose
    private String technique;

    @Expose
    private String techniqueid;

    @Expose
    private String title;

    @Expose
    private Long titlescount;

    @Expose
    private Long totalpageviews;

    @Expose
    private Long totaluniquepageviews;

    @Expose
    private String url;

    @Expose
    private Long verificationlevel;

    @Expose
    private String verificationleveldescription;

    @Expose
    private List<Worktype> worktypes;

    @Expose
    private boolean favorite;

    @Expose
    private int countStarsFavorites;

    @Expose
    private String loginUser;

    public Object() {
    }

    protected Object(Parcel in) {
        accessionmethod = in.readString();
        if (in.readByte() == 0) {
            accessionyear = null;
        } else {
            accessionyear = in.readLong();
        }
        if (in.readByte() == 0) {
            accesslevel = null;
        } else {
            accesslevel = in.readLong();
        }
        century = in.readString();
        classification = in.readString();
        if (in.readByte() == 0) {
            classificationid = null;
        } else {
            classificationid = in.readLong();
        }
        if (in.readByte() == 0) {
            colorcount = null;
        } else {
            colorcount = in.readLong();
        }
        commentary = in.readString();
        contact = in.readString();
        if (in.readByte() == 0) {
            contextualtextcount = null;
        } else {
            contextualtextcount = in.readLong();
        }
        copyright = in.readString();
        creditline = in.readString();
        culture = in.readString();
        if (in.readByte() == 0) {
            datebegin = null;
        } else {
            datebegin = in.readLong();
        }
        dated = in.readString();
        if (in.readByte() == 0) {
            dateend = null;
        } else {
            dateend = in.readLong();
        }
        dateoffirstpageview = in.readString();
        dateoflastpageview = in.readString();
        department = in.readString();
        description = in.readString();
        dimensions = in.readString();
        division = in.readString();
        edition = in.readString();
        if (in.readByte() == 0) {
            exhibitioncount = null;
        } else {
            exhibitioncount = in.readLong();
        }
        if (in.readByte() == 0) {
            groupcount = null;
        } else {
            groupcount = in.readLong();
        }
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        if (in.readByte() == 0) {
            imagecount = null;
        } else {
            imagecount = in.readLong();
        }
        if (in.readByte() == 0) {
            imagepermissionlevel = null;
        } else {
            imagepermissionlevel = in.readLong();
        }
        labeltext = in.readString();
        lastupdate = in.readString();
        if (in.readByte() == 0) {
            markscount = null;
        } else {
            markscount = in.readLong();
        }
        if (in.readByte() == 0) {
            mediacount = null;
        } else {
            mediacount = in.readLong();
        }
        medium = in.readString();
        if (in.readByte() == 0) {
            objectid = null;
        } else {
            objectid = in.readLong();
        }
        objectnumber = in.readString();
        galleryNumber = in.readInt();
        if (in.readByte() == 0) {
            peoplecount = null;
        } else {
            peoplecount = in.readLong();
        }
        period = in.readString();
        periodid = in.readString();
        primaryimageurl = in.readString();
        provenance = in.readString();
        if (in.readByte() == 0) {
            publicationcount = null;
        } else {
            publicationcount = in.readLong();
        }
        if (in.readByte() == 0) {
            rank = null;
        } else {
            rank = in.readLong();
        }
        if (in.readByte() == 0) {
            relatedcount = null;
        } else {
            relatedcount = in.readLong();
        }
        signed = in.readString();
        standardreferencenumber = in.readString();
        state = in.readString();
        style = in.readString();
        technique = in.readString();
        techniqueid = in.readString();
        title = in.readString();
        if (in.readByte() == 0) {
            titlescount = null;
        } else {
            titlescount = in.readLong();
        }
        if (in.readByte() == 0) {
            totalpageviews = null;
        } else {
            totalpageviews = in.readLong();
        }
        if (in.readByte() == 0) {
            totaluniquepageviews = null;
        } else {
            totaluniquepageviews = in.readLong();
        }
        url = in.readString();
        if (in.readByte() == 0) {
            verificationlevel = null;
        } else {
            verificationlevel = in.readLong();
        }
        verificationleveldescription = in.readString();
        favorite = in.readByte() != 0;
        countStarsFavorites = in.readInt();
        loginUser = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(accessionmethod);
        if (accessionyear == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(accessionyear);
        }
        if (accesslevel == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(accesslevel);
        }
        dest.writeString(century);
        dest.writeString(classification);
        if (classificationid == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(classificationid);
        }
        if (colorcount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(colorcount);
        }
        dest.writeString(commentary);
        dest.writeString(contact);
        if (contextualtextcount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(contextualtextcount);
        }
        dest.writeString(copyright);
        dest.writeString(creditline);
        dest.writeString(culture);
        if (datebegin == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(datebegin);
        }
        dest.writeString(dated);
        if (dateend == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(dateend);
        }
        dest.writeString(dateoffirstpageview);
        dest.writeString(dateoflastpageview);
        dest.writeString(department);
        dest.writeString(description);
        dest.writeString(dimensions);
        dest.writeString(division);
        dest.writeString(edition);
        if (exhibitioncount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(exhibitioncount);
        }
        if (groupcount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(groupcount);
        }
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(id);
        }
        if (imagecount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(imagecount);
        }
        if (imagepermissionlevel == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(imagepermissionlevel);
        }
        dest.writeString(labeltext);
        dest.writeString(lastupdate);
        if (markscount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(markscount);
        }
        if (mediacount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(mediacount);
        }
        dest.writeString(medium);
        if (objectid == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(objectid);
        }
        dest.writeString(objectnumber);
        dest.writeInt(galleryNumber);
        if (peoplecount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(peoplecount);
        }
        dest.writeString(period);
        dest.writeString(periodid);
        dest.writeString(primaryimageurl);
        dest.writeString(provenance);
        if (publicationcount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(publicationcount);
        }
        if (rank == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(rank);
        }
        if (relatedcount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(relatedcount);
        }
        dest.writeString(signed);
        dest.writeString(standardreferencenumber);
        dest.writeString(state);
        dest.writeString(style);
        dest.writeString(technique);
        dest.writeString(techniqueid);
        dest.writeString(title);
        if (titlescount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(titlescount);
        }
        if (totalpageviews == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(totalpageviews);
        }
        if (totaluniquepageviews == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(totaluniquepageviews);
        }
        dest.writeString(url);
        if (verificationlevel == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(verificationlevel);
        }
        dest.writeString(verificationleveldescription);
        dest.writeByte((byte) (favorite ? 1 : 0));
        dest.writeInt(countStarsFavorites);
        dest.writeString(loginUser);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Object> CREATOR = new Creator<Object>() {
        @Override
        public Object createFromParcel(Parcel in) {
            return new Object(in);
        }

        @Override
        public Object[] newArray(int size) {
            return new Object[size];
        }
    };

    public String getAccessionmethod() {
        return accessionmethod;
    }

    public void setAccessionmethod(String accessionmethod) {
        this.accessionmethod = accessionmethod;
    }

    public Long getAccessionyear() {
        return accessionyear;
    }

    public void setAccessionyear(Long accessionyear) {
        this.accessionyear = accessionyear;
    }

    public Long getAccesslevel() {
        return accesslevel;
    }

    public void setAccesslevel(Long accesslevel) {
        this.accesslevel = accesslevel;
    }

    public String getCentury() {
        return century;
    }

    public void setCentury(String century) {
        this.century = century;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public Long getClassificationid() {
        return classificationid;
    }

    public void setClassificationid(Long classificationid) {
        this.classificationid = classificationid;
    }

    public Long getColorcount() {
        return colorcount;
    }

    public void setColorcount(Long colorcount) {
        this.colorcount = colorcount;
    }

    public List<Color> getColors() {
        return colors;
    }

    public void setColors(List<Color> colors) {
        this.colors = colors;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Long getContextualtextcount() {
        return contextualtextcount;
    }

    public void setContextualtextcount(Long contextualtextcount) {
        this.contextualtextcount = contextualtextcount;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getCreditline() {
        return creditline;
    }

    public void setCreditline(String creditline) {
        this.creditline = creditline;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public Long getDatebegin() {
        return datebegin;
    }

    public void setDatebegin(Long datebegin) {
        this.datebegin = datebegin;
    }

    public String getDated() {
        return dated;
    }

    public void setDated(String dated) {
        this.dated = dated;
    }

    public Long getDateend() {
        return dateend;
    }

    public void setDateend(Long dateend) {
        this.dateend = dateend;
    }

    public String getDateoffirstpageview() {
        return dateoffirstpageview;
    }

    public void setDateoffirstpageview(String dateoffirstpageview) {
        this.dateoffirstpageview = dateoffirstpageview;
    }

    public String getDateoflastpageview() {
        return dateoflastpageview;
    }

    public void setDateoflastpageview(String dateoflastpageview) {
        this.dateoflastpageview = dateoflastpageview;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Long getExhibitioncount() {
        return exhibitioncount;
    }

    public void setExhibitioncount(Long exhibitioncount) {
        this.exhibitioncount = exhibitioncount;
    }

    public Long getGroupcount() {
        return groupcount;
    }

    public void setGroupcount(Long groupcount) {
        this.groupcount = groupcount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getImagecount() {
        return imagecount;
    }

    public void setImagecount(Long imagecount) {
        this.imagecount = imagecount;
    }

    public Long getImagepermissionlevel() {
        return imagepermissionlevel;
    }

    public void setImagepermissionlevel(Long imagepermissionlevel) {
        this.imagepermissionlevel = imagepermissionlevel;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
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

    public Long getMarkscount() {
        return markscount;
    }

    public void setMarkscount(Long markscount) {
        this.markscount = markscount;
    }

    public Long getMediacount() {
        return mediacount;
    }

    public void setMediacount(Long mediacount) {
        this.mediacount = mediacount;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public Long getObjectid() {
        return objectid;
    }

    public void setObjectid(Long objectid) {
        this.objectid = objectid;
    }

    @NonNull
    public String getObjectnumber() {
        return objectnumber;
    }

    public void setObjectnumber(@NonNull String objectnumber) {
        this.objectnumber = objectnumber;
    }

    public int getGalleryNumber() {
        return galleryNumber;
    }

    public void setGalleryNumber(int galleryNumber) {
        this.galleryNumber = galleryNumber;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public Long getPeoplecount() {
        return peoplecount;
    }

    public void setPeoplecount(Long peoplecount) {
        this.peoplecount = peoplecount;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getPeriodid() {
        return periodid;
    }

    public void setPeriodid(String periodid) {
        this.periodid = periodid;
    }

    public String getPrimaryimageurl() {
        return primaryimageurl;
    }

    public void setPrimaryimageurl(String primaryimageurl) {
        this.primaryimageurl = primaryimageurl;
    }

    public String getProvenance() {
        return provenance;
    }

    public void setProvenance(String provenance) {
        this.provenance = provenance;
    }

    public Long getPublicationcount() {
        return publicationcount;
    }

    public void setPublicationcount(Long publicationcount) {
        this.publicationcount = publicationcount;
    }

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    public Long getRelatedcount() {
        return relatedcount;
    }

    public void setRelatedcount(Long relatedcount) {
        this.relatedcount = relatedcount;
    }

    public List<SeeAlso> getSeeAlso() {
        return seeAlso;
    }

    public void setSeeAlso(List<SeeAlso> seeAlso) {
        this.seeAlso = seeAlso;
    }

    public String getSigned() {
        return signed;
    }

    public void setSigned(String signed) {
        this.signed = signed;
    }

    public String getStandardreferencenumber() {
        return standardreferencenumber;
    }

    public void setStandardreferencenumber(String standardreferencenumber) {
        this.standardreferencenumber = standardreferencenumber;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getTechnique() {
        return technique;
    }

    public void setTechnique(String technique) {
        this.technique = technique;
    }

    public String getTechniqueid() {
        return techniqueid;
    }

    public void setTechniqueid(String techniqueid) {
        this.techniqueid = techniqueid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTitlescount() {
        return titlescount;
    }

    public void setTitlescount(Long titlescount) {
        this.titlescount = titlescount;
    }

    public Long getTotalpageviews() {
        return totalpageviews;
    }

    public void setTotalpageviews(Long totalpageviews) {
        this.totalpageviews = totalpageviews;
    }

    public Long getTotaluniquepageviews() {
        return totaluniquepageviews;
    }

    public void setTotaluniquepageviews(Long totaluniquepageviews) {
        this.totaluniquepageviews = totaluniquepageviews;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getVerificationlevel() {
        return verificationlevel;
    }

    public void setVerificationlevel(Long verificationlevel) {
        this.verificationlevel = verificationlevel;
    }

    public String getVerificationleveldescription() {
        return verificationleveldescription;
    }

    public void setVerificationleveldescription(String verificationleveldescription) {
        this.verificationleveldescription = verificationleveldescription;
    }

    public List<Worktype> getWorktypes() {
        return worktypes;
    }

    public void setWorktypes(List<Worktype> worktypes) {
        this.worktypes = worktypes;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public int getCountStarsFavorites() {
        return countStarsFavorites;
    }

    public void setCountStarsFavorites(int countStarsFavorites) {
        this.countStarsFavorites = countStarsFavorites;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }
}
