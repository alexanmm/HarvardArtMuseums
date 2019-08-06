package br.com.digitalhouse.harvardartmuseums.repository;

import android.widget.TextView;

import org.json.JSONObject;

import java.util.Base64;

import br.com.digitalhouse.harvardartmuseums.data.network.translation.ApiServiceTranslation;
import br.com.digitalhouse.harvardartmuseums.model.translation.TranslationResponse;
import io.reactivex.Single;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import static br.com.digitalhouse.harvardartmuseums.data.network.translation.ApiServiceTranslation.APIKEY_IDENTIFIER;
import static br.com.digitalhouse.harvardartmuseums.data.network.translation.ApiServiceTranslation.APIKEY_SECRET;

public class TranslationRepository {

    public Single<TranslationResponse> getTranslationApi(TextView textView, String textInput) {

        //Languages
        //EnUs - English (United States / International)
        //EsEs - Spanish
        //PtBr - Brazilian Portuguese
        //ZhCh - Chinese (Simplified)
        //DeAl - German
        //FrFr - French
        //RuRu - Russian
        //ArAr - Arabic

        String authString = APIKEY_IDENTIFIER + ":" + APIKEY_SECRET;
        String authStringEnc = new String(Base64.getEncoder().encodeToString(authString.getBytes()));

        JSONObject data = new JSONObject();

        try {

            data.put("T", textInput);
            data.put("SL", "EnUs");
            data.put("TL", "PtBr");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Single<TranslationResponse> retorno =
                ApiServiceTranslation.getApiServiceTranslator().getTranslation(
                        "application/json",
                        "Basic " + authStringEnc,
                        toBody(data)
                );

        return retorno;
    }

    public RequestBody toBody(Object value) {
        return RequestBody.create(MediaType.parse("application/json"), value.toString());
    }
}
