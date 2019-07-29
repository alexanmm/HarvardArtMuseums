package br.com.digitalhouse.harvardartmuseums.repository;

import android.content.Context;

import java.util.List;

import br.com.digitalhouse.harvardartmuseums.data.database.Database;
import br.com.digitalhouse.harvardartmuseums.data.database.dao.FavoritesDAO;
import br.com.digitalhouse.harvardartmuseums.model.favorites.Favorites;
import io.reactivex.Flowable;

public class FavoritesRepository {

    public Flowable<List<Favorites>> getFavoritesLocal(Context context){
        Database database = Database.getDatabase(context);
        FavoritesDAO favoritesDAO = database.favoritesDAO();
        return favoritesDAO.getAllRxJava();
    }

//    public void insertItems(Context context, List<Favorites> favoritesList){
//        Database database = Database.getDatabase(context);
//        FavoritesDAO favoritesDao = database.favoritesDAO();
//        favoritesDao.insertAll(favoritesList);
//    }

//    public Single<FavoritesResult> getGalleryApi(){
//        return ApiService.getApiService().getGallery(APIKEY);
//    }

}
