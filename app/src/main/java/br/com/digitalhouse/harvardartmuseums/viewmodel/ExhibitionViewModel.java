package br.com.digitalhouse.harvardartmuseums.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.com.digitalhouse.harvardartmuseums.data.database.Database;
import br.com.digitalhouse.harvardartmuseums.data.database.dao.ExhibitionDAO;
import br.com.digitalhouse.harvardartmuseums.model.exhibition.Exhibition;
import br.com.digitalhouse.harvardartmuseums.model.exhibition.ExhibitionResult;
import br.com.digitalhouse.harvardartmuseums.repository.ExhibitionRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static br.com.digitalhouse.harvardartmuseums.util.AppUtil.isNetworkConnected;

public class ExhibitionViewModel extends AndroidViewModel {

    private MutableLiveData<List<Exhibition>> exhibitionLiveData = new MutableLiveData<>();
    private MutableLiveData<Throwable> errorLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> loadingLiveData = new MutableLiveData<>();

    private CompositeDisposable disposable = new CompositeDisposable();
    private ExhibitionRepository repository = new ExhibitionRepository();

    public ExhibitionViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Exhibition>> getExhibitionLiveData() {
        return exhibitionLiveData;
    }

    public LiveData<Boolean> getExhibitionLoadingLiveData() {
        return loadingLiveData;
    }

    public LiveData<Throwable> getExhibitionErrorLiveData() {
        return errorLiveData;
    }

    public void searchExhibition(int page, int size) {

        if (isNetworkConnected(getApplication())) {
            getApiExhibition(page, size);
        } else {
            getLocalExhibition();
        }
    }

    private void getLocalExhibition() {
        disposable.add(
                repository.getExhibitionLocal(getApplication().getApplicationContext())
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable1 -> loadingLiveData.setValue(false))
                        .doAfterTerminate(() -> loadingLiveData.setValue(false))
                        .subscribe(exhibitionList -> exhibitionLiveData.setValue(exhibitionList)
                                , throwable -> errorLiveData.setValue(throwable))
        );
    }

    private void getApiExhibition(int page, int size) {

        disposable.add(
                repository.getExhibitionApi(page, size)
                        .subscribeOn(Schedulers.newThread())
                        .map(exhibitionResult -> {
                            return saveItems(exhibitionResult);
                        })
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable1 -> loadingLiveData.setValue(true))
                        .doAfterTerminate(() -> loadingLiveData.setValue(false))
                        .subscribe(exhibitionResult -> exhibitionLiveData.setValue(exhibitionResult.getRecords())
                                , throwable -> errorLiveData.setValue(throwable))
        );

    }

    private ExhibitionResult saveItems(ExhibitionResult exhibitionResult) {
        ExhibitionDAO exhibitionDAO = Database.getDatabase(getApplication()
                .getApplicationContext())
                .exhibitionDAO();

        exhibitionDAO.insertAll(exhibitionResult.getRecords());
        return exhibitionResult;
    }

    // Limpa as chamadas que fizemos no RX
    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}