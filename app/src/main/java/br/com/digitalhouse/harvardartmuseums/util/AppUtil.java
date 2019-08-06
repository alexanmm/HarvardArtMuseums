package br.com.digitalhouse.harvardartmuseums.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.speech.tts.TextToSpeech;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.snackbar.Snackbar;

import org.json.JSONException;

import java.io.IOException;
import java.util.Locale;

import br.com.digitalhouse.harvardartmuseums.viewmodel.TranslationViewModel;

// Imports the Google Cloud client library

public class AppUtil {

    //Text to Speech
    private static TextToSpeech textToSpeech;

    // Verifica se temos conexão com internet
    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo;

        if (connectivityManager != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
            return networkInfo != null && networkInfo.isConnected() &&
                    (networkInfo.getType() == ConnectivityManager.TYPE_WIFI
                            || networkInfo.getType() == ConnectivityManager.TYPE_MOBILE);
        }
        return false;
    }

    public static String convString(java.lang.Object stringIn) {

        String stringOut = "-";

        if (stringIn != null) {
            stringOut = stringIn.toString();
        }

        return stringOut;
    }

    public static void speakOut(String textoCampo, String textoLeitura, Context context) {

        //Prepara dados para leitura do texto por voz
        if (textToSpeech == null) {
            textToSpeech = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {

                    if (status != TextToSpeech.ERROR) {
                        textToSpeech.setLanguage(Locale.getDefault()); //Idioma Local
                    }
                }
            });
        }

        //Aguarda finalizar a leitura do texto anterior
        while (textToSpeech.isSpeaking()) {
        }

        if (textoLeitura != null) {
            //Leitura da cotação atual
            textToSpeech.speak(textoCampo, TextToSpeech.QUEUE_FLUSH, null);

            //Aguarda finalizar a leitura do texto anterior
            while (textToSpeech.isSpeaking()) {
            }

            textToSpeech.speak(textoLeitura, TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    public static void translateOut(TextView textView, String textOld, FragmentActivity fragmentActivity) {

        final TranslationViewModel translationViewModel;

        translationViewModel = ViewModelProviders.of(fragmentActivity).get(TranslationViewModel.class);

        translationViewModel.getTranslation(textView, textOld);

        //Observable Error
        translationViewModel.getTranslationErrorLiveData().observe(fragmentActivity, throwable -> {
            Snackbar.make(textView, throwable.getMessage(), Snackbar.LENGTH_SHORT).show();
        });

    }
}
