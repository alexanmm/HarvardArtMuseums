package br.com.digitalhouse.harvardartmuseums.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Event implements Parcelable {

    private int thunbnail;
    private String date;
    private String name;
    private String time;
    private String streetAndNumber;
    private String cityAndState;
    private String description;

    public Event() {
    }

    public Event(int thunbnail, String date, String name, String time, String streetAndNumber, String cityAndState, String description) {
        this.thunbnail = thunbnail;
        this.date = date;
        this.name = name;
        this.time = time;
        this.streetAndNumber = streetAndNumber;
        this.cityAndState = cityAndState;
        this.description = description;
    }

    protected Event(Parcel in) {
        thunbnail = in.readInt();
        date = in.readString();
        name = in.readString();
        time = in.readString();
        streetAndNumber = in.readString();
        cityAndState = in.readString();
        description = in.readString();
    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

    public int getThunbnail() {
        return thunbnail;
    }

    public void setThunbnail(int thunbnail) {
        this.thunbnail = thunbnail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStreetAndNumber() {
        return streetAndNumber;
    }

    public void setStreetAndNumber(String streetAndNumber) {
        this.streetAndNumber = streetAndNumber;
    }

    public String getCityAndState() {
        return cityAndState;
    }

    public void setCityAndState(String cityAndState) {
        this.cityAndState = cityAndState;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(thunbnail);
        dest.writeString(date);
        dest.writeString(name);
        dest.writeString(time);
        dest.writeString(streetAndNumber);
        dest.writeString(cityAndState);
        dest.writeString(description);
    }
}
