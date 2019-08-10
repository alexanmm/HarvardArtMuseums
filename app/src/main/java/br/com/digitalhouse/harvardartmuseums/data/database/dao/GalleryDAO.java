package br.com.digitalhouse.harvardartmuseums.data.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.com.digitalhouse.harvardartmuseums.model.gallery.Gallery;
import io.reactivex.Flowable;

@Dao
public interface GalleryDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Gallery gallery);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Gallery> galleryList);

    @Update
    void update(Gallery gallery);

    @Delete
    void delete(Gallery gallery);

    @Query("SELECT * FROM tab_gallery")
    List<Gallery> getAll();

    //@Query("SELECT COUNT(url) FROM tab_gallery")
    //int getCountLines();

    @Query("SELECT * FROM tab_gallery WHERE floor = :floor")
    Flowable<List<Gallery>> getAllRxJava(int floor);

    //@Query("SELECT * FROM tab_gallery WHERE url = :url")
    //Gallery getById(String url);

}
