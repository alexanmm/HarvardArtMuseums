package br.com.digitalhouse.harvardartmuseums.data.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private static final String BASE_URL = "https://api.harvardartmuseums.org/";
    public static final String PRIVATE_KEY = "7d7d94e0-a428-11e9-9ce6-3ddedf14246e";

    private static Retrofit retrofit;

    private static Retrofit getRetrofit() {

        if (retrofit == null) {

            //configurações de conexão
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.readTimeout(30, TimeUnit.SECONDS);
            httpClient.connectTimeout(30, TimeUnit.SECONDS);
            httpClient.writeTimeout(30, TimeUnit.SECONDS);

            // Inicializamos o retrofit
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }

        return retrofit;
    }

    // retorno da instância da API criada com o retrofit
    public static Api getApiService() {
        return getRetrofit().create(Api.class);
    }

}
