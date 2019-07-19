package br.com.digitalhouse.harvardartmuseums.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.com.digitalhouse.harvardartmuseums.data.HarvardRepository;
import br.com.digitalhouse.harvardartmuseums.model.Record;
import io.reactivex.disposables.CompositeDisposable;


import br.com.digitalhouse.harvardartmuseums.data.database.DatabaseRoom;
import br.com.digitalhouse.harvardartmuseums.data.database.dao.ResultsDao;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static br.com.digitalhouse.harvardartmuseums.utils.AppUtil.isNetworkConnected;

public class HarvardViewModel extends AndroidViewModel {

    // Variáveis que serão utilizadas para buscar os andares na API

    private MutableLiveData<List<Record>> recordLiveData = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();
    private HarvardRepository repository = new HarvardRepository();

    public HarvardViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Record>> getRecordLiveData

    {
        return recordLiveData;
    }

    // Verificar conexão
    public void searchFloor(long floor) {
        if (isNetworkConnected(getApplication())) {
            getFromNetwork(floor);
        } else {
            getFromLocal();
        }
    }

    private void getFromLocal() {

        disposable.add(
                repository.getLocalResults(getApplication().getApplicationContext())
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(subscription -> {
                        })
                        .doAfterTerminate(() -> {
                        })
                        .subscribe(records -> {
                            recordLiveData.setValue(records);
                        }, throwable -> {
                        })

        );
    }

    private void getFromNetwork(long floor) {

        disposable.add(
                repository.searchFloor(floor)
                        .subscribeOn(Schedulers.newThread())
                        .map(this::saveFloor)
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(subscription -> {

                        })
                        .doAfterTerminate(() -> {
                        })
                        .subscribe(Record -> {
                            recordLiveData.setValue(Record.getFloor());
                        }, throwable -> {

                        })
        );
    }

    private Record saveFloor(Record record) {
        ResultsDao dao = DatabaseRoom.getDatabase(getApplication().getApplicationContext())
                .resultsDAO();

        dao.insert(record.getFloor());

        return record;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }

}
