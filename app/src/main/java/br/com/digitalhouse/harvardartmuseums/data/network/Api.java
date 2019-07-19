package br.com.digitalhouse.harvardartmuseums.data.network;

import br.com.digitalhouse.harvardartmuseums.model.Record;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("gallery?")
    Single<Record> getRecords (@Query("apikey") String apikey);

}

