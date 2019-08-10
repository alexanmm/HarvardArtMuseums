package br.com.digitalhouse.harvardartmuseums.repository;

import android.content.Context;

import java.util.List;

import br.com.digitalhouse.harvardartmuseums.data.database.Database;
import br.com.digitalhouse.harvardartmuseums.data.database.dao.ExhibitionDAO;
import br.com.digitalhouse.harvardartmuseums.data.database.dao.GalleryDAO;
import br.com.digitalhouse.harvardartmuseums.data.network.ApiService;
import br.com.digitalhouse.harvardartmuseums.model.exhibition.Exhibition;
import br.com.digitalhouse.harvardartmuseums.model.exhibition.ExhibitionResult;
import br.com.digitalhouse.harvardartmuseums.model.gallery.Gallery;
import br.com.digitalhouse.harvardartmuseums.model.gallery.GalleryResult;
import io.reactivex.Flowable;
import io.reactivex.Single;

import static br.com.digitalhouse.harvardartmuseums.data.network.ApiService.APIKEY;

public class ExhibitionRepository {

    public Flowable<List<Exhibition>> getExhibitionLocal(Context context) {
        Database database = Database.getDatabase(context);
        ExhibitionDAO exhibitionDAO = database.exhibitionDAO();
        return exhibitionDAO.getAllRxJava();
    }

//    public void insertItems(Context context, List<Exhibition> exhibitionList){
//        Database database = Database.getDatabase(context);
//        ExhibitionDAO exhibitionDAO = database.exhibitionDAO();
//        exhibitionDAO.insertAll(exhibitionList);
//    }

    public Single<ExhibitionResult> getExhibitionApi(int page, int size) {
        return ApiService.getApiService().getExhibition(
                APIKEY,
                "upcoming",
                "chronological",
                page,
                size,
                "asc",
                "1" //Only records with image
        );
    }

}
