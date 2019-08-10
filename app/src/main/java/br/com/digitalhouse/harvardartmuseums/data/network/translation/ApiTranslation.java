package br.com.digitalhouse.harvardartmuseums.data.network.translation;

import br.com.digitalhouse.harvardartmuseums.model.translation.TranslationResponse;
import io.reactivex.Single;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiTranslation {

    @POST("Translation/v1.1/Translate/")
    Single<TranslationResponse> getTranslation(@Header("Content-Type") String contentType,
                                               @Header("Authorization") String authorization,
                                               @Body RequestBody body);
}
