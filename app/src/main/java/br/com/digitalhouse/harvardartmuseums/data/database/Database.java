package br.com.digitalhouse.harvardartmuseums.data.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import br.com.digitalhouse.harvardartmuseums.data.database.dao.ExhibitionDAO;
import br.com.digitalhouse.harvardartmuseums.data.database.dao.FavoritesDAO;
import br.com.digitalhouse.harvardartmuseums.data.database.dao.GalleryDAO;
import br.com.digitalhouse.harvardartmuseums.data.database.dao.ObjectDAO;
import br.com.digitalhouse.harvardartmuseums.model.exhibition.Exhibition;
import br.com.digitalhouse.harvardartmuseums.model.favorites.Favorites;
import br.com.digitalhouse.harvardartmuseums.model.gallery.Gallery;
import br.com.digitalhouse.harvardartmuseums.model.object.Object;

@androidx.room.Database(entities = {Gallery.class, Object.class, Exhibition.class, Favorites.class}, version = 11, exportSchema = false)

@TypeConverters(Converters.class)
public abstract class Database extends RoomDatabase {
    private static volatile Database INSTANCE;

    public abstract GalleryDAO galleryDAO();
    public abstract ObjectDAO objectDAO();
    public abstract ExhibitionDAO exhibitionDAO();
    public abstract FavoritesDAO favoritesDAO();

    public static Database getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, Database.class, "my_db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}