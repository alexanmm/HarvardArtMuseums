package br.com.digitalhouse.harvardartmuseums.data.network;

import androidx.annotation.NonNull;

import br.com.digitalhouse.harvardartmuseums.model.exhibition.ExhibitionResult;
import br.com.digitalhouse.harvardartmuseums.model.gallery.GalleryResult;
import br.com.digitalhouse.harvardartmuseums.model.object.ObjectResult;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("gallery/")
    Single<GalleryResult> getGallery(@Query("apikey") String apikey,
                                     @Query("floor") int floor,
                                     @Query("page") int page);

    @GET("object/")
    Single<ObjectResult> getObject(@Query("apikey") String apikey,
                                   @Query("gallery") int gallery);

    @GET("exhibition/")
    Single<ExhibitionResult> getExhibition(@Query("apikey") String apikey,
                                           @Query("status") String status,
                                           @Query("sort") String sort,
                                           @Query("page") int page,
                                           @Query("size") int size,
                                           @Query("sortorder") String sortorder,
                                           @Query("hasimage") String hasimage);
}
