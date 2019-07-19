package br.com.digitalhouse.harvardartmuseums.data.database.dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.com.digitalhouse.harvardartmuseums.model.Record;
import io.reactivex.Flowable;

@Dao
public interface ResultsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Record record);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Record> records);

    @Update
    void update(Record record);

    @Delete
    void uptate(Record record);

    @Query("Select * from record where floor = :piso")
    Flowable<List<Record>> getAll(int piso);

}
