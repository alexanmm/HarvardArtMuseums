package br.com.digitalhouse.harvardartmuseums.data.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.com.digitalhouse.harvardartmuseums.model.favorites.Favorites;
import io.reactivex.Flowable;

@Dao
public interface FavoritesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Favorites favorites);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Favorites> favoritesList);

    @Update
    void update(Favorites favorites);

    @Delete
    void delete(Favorites favorites);

    @Query("DELETE FROM tab_favorites WHERE loginUser = :userId and objectId = :objectId")
    void deleteByUserObjectId(String userId, long objectId);

    @Query("SELECT * FROM tab_favorites")
    List<Favorites> getAll();

    @Query("SELECT * FROM tab_favorites")
    Flowable<List<Favorites>> getAllRxJava();

    @Query("SELECT * FROM tab_favorites WHERE loginUser = :userId and objectId = :objectId")
    Favorites getFavoritesByUserObjectId(String userId, long objectId);

}
