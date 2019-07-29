package br.com.digitalhouse.harvardartmuseums.data.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.com.digitalhouse.harvardartmuseums.model.exhibition.Exhibition;
import io.reactivex.Flowable;

@Dao
public interface ExhibitionDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Exhibition exhibition);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Exhibition> exhibitionList);

    @Update
    void update(Exhibition exhibition);

    @Delete
    void delete(Exhibition exhibition);

    @Query("SELECT * FROM tab_exhibition")
    List<Exhibition> getAll();

    @Query("SELECT * FROM tab_exhibition")
    Flowable<List<Exhibition>> getAllRxJava();

}
