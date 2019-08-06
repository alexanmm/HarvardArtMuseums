package br.com.digitalhouse.harvardartmuseums.data.network.translation;

import com.facebook.stetho.BuildConfig;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServiceTranslation {

    public static final String URL_BASE = "https://api.gotit.ai/";
    public static final String APIKEY_IDENTIFIER = "542-2bsvHwu2";
    public static final String APIKEY_SECRET = "lW8haU2sRVgT8B/VxifqAvi7MkuR+pFe";
    private static Retrofit retrofit;

    public static Retrofit getRetrofit(){

        if(retrofit == null){
            // configurações da conexão
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.readTimeout(30   , TimeUnit.SECONDS);
            httpClient.connectTimeout(30, TimeUnit.SECONDS);
            httpClient.writeTimeout(30  , TimeUnit.SECONDS);

            // Se for Debug habilitamos os logs
            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                httpClient.addInterceptor(httpLoggingInterceptor);
                httpClient.addNetworkInterceptor(new StethoInterceptor());
            }

            retrofit = new Retrofit.Builder()
                    .baseUrl(URL_BASE)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }

        return retrofit;
    }

    public static ApiTranslation getApiServiceTranslator(){
        return getRetrofit().create(ApiTranslation.class);
    }


}
