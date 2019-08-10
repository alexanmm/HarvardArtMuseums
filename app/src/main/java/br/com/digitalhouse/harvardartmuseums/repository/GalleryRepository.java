package br.com.digitalhouse.harvardartmuseums.repository;

import android.content.Context;

import java.util.List;

import br.com.digitalhouse.harvardartmuseums.data.database.Database;
import br.com.digitalhouse.harvardartmuseums.data.database.dao.GalleryDAO;
import br.com.digitalhouse.harvardartmuseums.data.network.ApiService;
import br.com.digitalhouse.harvardartmuseums.model.gallery.Gallery;
import br.com.digitalhouse.harvardartmuseums.model.gallery.GalleryResult;
import io.reactivex.Flowable;
import io.reactivex.Single;

import static br.com.digitalhouse.harvardartmuseums.data.network.ApiService.APIKEY;

public class GalleryRepository {

    public Flowable<List<Gallery>> getGalleryLocal(Context context, int floor){
        Database database = Database.getDatabase(context);
        GalleryDAO galleryDAO = database.galleryDAO();
        return galleryDAO.getAllRxJava(floor);
    }

//    public void insertItems(Context context, List<Filme> filmes){
//        Database database = Database.getDatabase(context);
//        FilmesDAO filmeDao = database.filmesDAO();
//        filmeDao.insertAll(filmes);
//    }

    public Single<GalleryResult> getGalleryApi(int floor, int pagina){
        return ApiService.getApiService().getGallery(APIKEY, floor, pagina);
    }

}
