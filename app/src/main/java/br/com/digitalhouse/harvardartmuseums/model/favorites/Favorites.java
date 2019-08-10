package br.com.digitalhouse.harvardartmuseums.model.favorites;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;

import br.com.digitalhouse.harvardartmuseums.model.object.Object;

@Entity(tableName = "tab_favorites")
public class Favorites implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private long tableId;

    @Expose
    private String loginUser;

    @Expose
    private long objectId;

    @Expose
    private Object objectGallery;

    public Favorites() {
    }

    public Favorites(Object objectGallery) {
        this.objectGallery = objectGallery;

        //Busca o usuario e o numero do objeto para as chaves
        this.loginUser = objectGallery.getLoginUser();
        this.objectId = objectGallery.getObjectid();
    }

    protected Favorites(Parcel in) {
        tableId = in.readLong();
        loginUser = in.readString();
        objectId = in.readLong();
        objectGallery = in.readParcelable(Object.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(tableId);
        dest.writeString(loginUser);
        dest.writeLong(objectId);
        dest.writeParcelable(objectGallery, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Favorites> CREATOR = new Creator<Favorites>() {
        @Override
        public Favorites createFromParcel(Parcel in) {
            return new Favorites(in);
        }

        @Override
        public Favorites[] newArray(int size) {
            return new Favorites[size];
        }
    };

    public long getTableId() {
        return tableId;
    }

    public void setTableId(long tableId) {
        this.tableId = tableId;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public long getObjectId() {
        return objectId;
    }

    public void setObjectId(long objectId) {
        this.objectId = objectId;
    }

    public Object getObjectGallery() {
        return objectGallery;
    }

    public void setObjectGallery(Object objectGallery) {
        this.objectGallery = objectGallery;
    }

}
