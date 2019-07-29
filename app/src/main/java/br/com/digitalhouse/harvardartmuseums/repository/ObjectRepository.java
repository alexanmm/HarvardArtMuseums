package br.com.digitalhouse.harvardartmuseums.repository;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.harvardartmuseums.data.database.Database;
import br.com.digitalhouse.harvardartmuseums.data.database.dao.ObjectDAO;
import br.com.digitalhouse.harvardartmuseums.data.network.ApiService;
import br.com.digitalhouse.harvardartmuseums.model.gallery.Gallery;
import br.com.digitalhouse.harvardartmuseums.model.gallery.GalleryResult;
import br.com.digitalhouse.harvardartmuseums.model.object.Object;
import br.com.digitalhouse.harvardartmuseums.model.object.ObjectResult;
import io.reactivex.Flowable;
import io.reactivex.Single;

import static br.com.digitalhouse.harvardartmuseums.data.network.ApiService.APIKEY;

public class ObjectRepository {

    public Flowable<List<Object>> getObjectLocal(Context context, int galleryNumber){
        Database database = Database.getDatabase(context);
        ObjectDAO objectDAO = database.objectDAO();
        return objectDAO.getAllRxJava(galleryNumber);
    }

//    public void insertItems(Context context, List<Filme> filmes){
//        Database database = Database.getDatabase(context);
//        FilmesDAO filmeDao = database.filmesDAO();
//        filmeDao.insertAll(filmes);
//    }

    public Single<ObjectResult> getObjectApi(int galleryNumber){

        return ApiService.getApiService().getObject(APIKEY, galleryNumber);
    }

}
