package br.com.digitalhouse.harvardartmuseums.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.com.digitalhouse.harvardartmuseums.data.database.Database;
import br.com.digitalhouse.harvardartmuseums.data.database.dao.GalleryDAO;
import br.com.digitalhouse.harvardartmuseums.model.gallery.Gallery;
import br.com.digitalhouse.harvardartmuseums.model.gallery.GalleryResult;
import br.com.digitalhouse.harvardartmuseums.model.object.Object;
import br.com.digitalhouse.harvardartmuseums.repository.GalleryRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static android.text.TextUtils.concat;
import static br.com.digitalhouse.harvardartmuseums.util.AppUtil.isNetworkConnected;

public class GalleryViewModel extends AndroidViewModel {
    private MutableLiveData<List<Gallery>> galleryLiveData = new MutableLiveData<>();
    private MutableLiveData<Throwable> errorLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> loadingLiveData = new MutableLiveData<>();

    private CompositeDisposable disposable = new CompositeDisposable();
    private GalleryRepository repository = new GalleryRepository();

    public GalleryViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Gallery>> getGalleryLiveData() {
        return galleryLiveData;
    }

    public LiveData<Boolean> getGalleryLoadingLiveData() {
        return loadingLiveData;
    }

    public LiveData<Throwable> getGalleryErrorLiveData() {
        return errorLiveData;
    }

    public void searchGallery(int floor, int pagina) {

        if (isNetworkConnected(getApplication())) {
            getApiGallery(floor, pagina);
        } else {
            getLocalGallery(floor);
        }
    }

    private void getLocalGallery(int floor) {
        disposable.add(
                repository.getGalleryLocal(getApplication().getApplicationContext(), floor)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable1 -> loadingLiveData.setValue(false))
                        .doAfterTerminate(() -> loadingLiveData.setValue(false))
                        .subscribe(galleryList -> galleryLiveData.setValue(galleryList)
                                , throwable -> errorLiveData.setValue(throwable))
        );
    }

    private void getApiGallery(int floor, int pagina) {

        disposable.add(
                repository.getGalleryApi(floor, pagina)
                        .subscribeOn(Schedulers.newThread())
                        .map(galleryResult -> {
                            return saveItems(galleryResult);
                        })
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable1 -> loadingLiveData.setValue(true))
                        .doAfterTerminate(() -> loadingLiveData.setValue(false))
                        .subscribe(galleryResult -> galleryLiveData.setValue(galleryResult.getRecords())
                                , throwable -> errorLiveData.setValue(throwable))
        );

    }

    private GalleryResult saveItems(GalleryResult galleryResult) {
        GalleryDAO galleryDAO = Database.getDatabase(getApplication()
                .getApplicationContext())
                .galleryDAO();

        galleryDAO.insertAll(galleryResult.getRecords());
        return galleryResult;
    }

    // Limpa as chamadas que fizemos no RX
    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}