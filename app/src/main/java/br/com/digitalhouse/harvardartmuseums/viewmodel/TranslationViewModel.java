package br.com.digitalhouse.harvardartmuseums.viewmodel;

import android.app.Application;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.json.JSONException;

import br.com.digitalhouse.harvardartmuseums.model.translation.TranslationResponse;
import br.com.digitalhouse.harvardartmuseums.repository.TranslationRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static br.com.digitalhouse.harvardartmuseums.util.AppUtil.isNetworkConnected;

public class TranslationViewModel extends AndroidViewModel {

    private MutableLiveData<TranslationResponse> translationLiveData = new MutableLiveData<>();
    private MutableLiveData<Throwable> errorLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> loadingLiveData = new MutableLiveData<>();

    private CompositeDisposable disposable = new CompositeDisposable();
    private TranslationRepository repository = new TranslationRepository();

    public TranslationViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<TranslationResponse> getTranslationLiveData() {
        return translationLiveData;
    }

    public LiveData<Boolean> getTranslationLoadingLiveData() {
        return loadingLiveData;
    }

    public LiveData<Throwable> getTranslationErrorLiveData() {
        return errorLiveData;
    }

    public void getTranslation(TextView textView, String textInput, String idiomaDestino) {

        if (isNetworkConnected(getApplication())) {
            getApiTranslation(textView, textInput, idiomaDestino);
        }
    }

    private void getApiTranslation(TextView textView, String textInput, String idiomaDestino) {

        disposable.add(
                repository.getTranslationApi(textView, textInput, idiomaDestino)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable1 -> loadingLiveData.setValue(true))
                        .doAfterTerminate(() -> loadingLiveData.setValue(false))
                        .subscribe(translationResponse -> {

                                    textView.setText(translationResponse.getResult());

                                    translationLiveData.setValue(translationResponse);
                                }
                                , throwable -> errorLiveData.setValue(throwable))
        );

    }

    // Limpa as chamadas que fizemos no RX
    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}