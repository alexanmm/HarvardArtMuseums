package br.com.digitalhouse.harvardartmuseums.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.com.digitalhouse.harvardartmuseums.data.database.Database;
import br.com.digitalhouse.harvardartmuseums.data.database.dao.FavoritesDAO;
import br.com.digitalhouse.harvardartmuseums.model.favorites.Favorites;
import br.com.digitalhouse.harvardartmuseums.repository.FavoritesRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static br.com.digitalhouse.harvardartmuseums.util.AppUtil.isNetworkConnected;

public class FavoritesViewModel extends AndroidViewModel {

    private MutableLiveData<List<Favorites>> favoritesLiveData = new MutableLiveData<>();
    private MutableLiveData<Throwable> errorLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> loadingLiveData = new MutableLiveData<>();

    private CompositeDisposable disposable = new CompositeDisposable();
    private FavoritesRepository repository = new FavoritesRepository();

    public FavoritesViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Favorites>> getFavoritesLiveData() {
        return favoritesLiveData;
    }

    public LiveData<Boolean> getFavoritesLoadingLiveData() {
        return loadingLiveData;
    }

    public LiveData<Throwable> getFavoritesErrorLiveData() {
        return errorLiveData;
    }

    public void searchFavorites() {

        if (isNetworkConnected(getApplication())) {
//            getApiFavorites();
            getLocalFavorites();
        } else {
            getLocalFavorites();
        }
    }

    private void getLocalFavorites() {
        disposable.add(
                repository.getFavoritesLocal(getApplication().getApplicationContext())
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable1 -> loadingLiveData.setValue(false))
                        .doAfterTerminate(() -> loadingLiveData.setValue(false))
                        .subscribe(favoritesList -> favoritesLiveData.setValue(favoritesList)
                                , throwable -> errorLiveData.setValue(throwable))
        );
    }

    private List<Favorites> saveItems(List<Favorites> favoritesList) {
        FavoritesDAO favoritesDAO = Database.getDatabase(getApplication()
                .getApplicationContext())
                .favoritesDAO();

        favoritesDAO.insertAll(favoritesList);
        return favoritesList;
    }

    // Limpa as chamadas que fizemos no RX
    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}