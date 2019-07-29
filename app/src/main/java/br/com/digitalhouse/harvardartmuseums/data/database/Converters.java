package br.com.digitalhouse.harvardartmuseums.data.database;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import br.com.digitalhouse.harvardartmuseums.model.exhibition.ImageExhibition;
import br.com.digitalhouse.harvardartmuseums.model.exhibition.PersonExhibition;
import br.com.digitalhouse.harvardartmuseums.model.exhibition.PosterExhibition;
import br.com.digitalhouse.harvardartmuseums.model.exhibition.Venue;
import br.com.digitalhouse.harvardartmuseums.model.object.Color;
import br.com.digitalhouse.harvardartmuseums.model.object.Image;
import br.com.digitalhouse.harvardartmuseums.model.object.Person;
import br.com.digitalhouse.harvardartmuseums.model.object.SeeAlso;
import br.com.digitalhouse.harvardartmuseums.model.object.Worktype;
import br.com.digitalhouse.harvardartmuseums.model.object.Object;

public class Converters {
    @TypeConverter
    public Date toDate(Long timestamp) {
        if (timestamp == null) {
            return null;
        } else {
            return new Date(timestamp);
        }
    }

    @TypeConverter
    public Long toTimestamp(Date date) {
        return date.getTime();
    }

    /// Type converter para uma lista de String
    @TypeConverter
    public List<String> fromString(String value) {
        Type listType = (Type) new TypeToken<List<String>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromList(List<String> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    /// Type converter para uma lista Color
    @TypeConverter
    public List<Color> fromColor(String value) {
        Type listType = (Type) new TypeToken<List<Color>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromColor(List<Color> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    /// Type converter para uma lista Image
    @TypeConverter
    public List<Image> fromImage(String value) {
        Type listType = (Type) new TypeToken<List<Image>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromImage(List<Image> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    /// Type converter para uma lista Person
    @TypeConverter
    public List<Person> fromPerson(String value) {
        Type listType = (Type) new TypeToken<List<Person>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromPerson(List<Person> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    /// Type converter para uma lista SeeAlso
    @TypeConverter
    public List<SeeAlso> fromSeeAlso(String value) {
        Type listType = (Type) new TypeToken<List<SeeAlso>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromSeeAlso(List<SeeAlso> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    /// Type converter para uma lista Worktype
    @TypeConverter
    public List<Worktype> fromWorktype(String value) {
        Type listType = (Type) new TypeToken<List<Worktype>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromWorktype(List<Worktype> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    /// Type converter para uma lista Venue
    @TypeConverter
    public List<Venue> fromVenue(String value) {
        Type listType = (Type) new TypeToken<List<Venue>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromVenue(List<Venue> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    /// Type converter para uma lista ImageExhibition
    @TypeConverter
    public List<ImageExhibition> fromImageExhibition(String value) {
        Type listType = (Type) new TypeToken<List<ImageExhibition>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromImageExhibition(List<ImageExhibition> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    /// Type converter para uma lista PersonExhibition
    @TypeConverter
    public List<PersonExhibition> fromPersonExhibition(String value) {
        Type listType = (Type) new TypeToken<List<PersonExhibition>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromPersonExhibition(List<PersonExhibition> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    // Type converter PosterExhibition
    @TypeConverter
    public PosterExhibition fromPosterExhibition(String value) {
        Type listType = (Type) new TypeToken<PosterExhibition>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromPosterExhibition(PosterExhibition list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    // Type converter Object
    @TypeConverter
    public Object fromObject(String value) {
        Type listType = (Type) new TypeToken<Object>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromObject(Object list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }


}
