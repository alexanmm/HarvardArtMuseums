package br.com.digitalhouse.harvardartmuseums.data.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.com.digitalhouse.harvardartmuseums.model.object.Object;
import io.reactivex.Flowable;

@Dao
public interface ObjectDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Object object);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Object> objectList);

    @Update
    void update(Object object);

    @Delete
    void delete(Object object);

    @Query("SELECT * FROM tab_object")
    List<Object> getAll();

//    @Query("SELECT COUNT(url) FROM tab_object")
//    int getCountLines();

    @Query("SELECT * FROM tab_object WHERE galleryNumber = :galleryNumber")
    Flowable<List<Object>> getAllRxJava(int galleryNumber);

//    @Query("SELECT * FROM tab_object WHERE url = :url")
//    Object getById(String url);

}
