package br.com.digitalhouse.harvardartmuseums.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.com.digitalhouse.harvardartmuseums.data.database.Database;
import br.com.digitalhouse.harvardartmuseums.data.database.dao.ObjectDAO;
import br.com.digitalhouse.harvardartmuseums.model.gallery.Gallery;
import br.com.digitalhouse.harvardartmuseums.model.object.Object;
import br.com.digitalhouse.harvardartmuseums.model.object.ObjectResult;
import br.com.digitalhouse.harvardartmuseums.repository.ObjectRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static br.com.digitalhouse.harvardartmuseums.util.AppUtil.isNetworkConnected;

public class ObjectViewModel extends AndroidViewModel {

    private MutableLiveData<List<Object>> objectLiveData = new MutableLiveData<>();
    private MutableLiveData<Throwable> errorLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> loadingLiveData = new MutableLiveData<>();

    private CompositeDisposable disposable = new CompositeDisposable();
    private ObjectRepository repository = new ObjectRepository();

    public ObjectViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Object>> getObjectLiveData() {
        return objectLiveData;
    }

    public LiveData<Boolean> getLoadingLiveData() {
        return loadingLiveData;
    }

    public LiveData<Throwable> getErrorLiveData() {
        return errorLiveData;
    }

    //public void searchObject(int galleryNumber){
    public void searchObject(List<Gallery> galleryList) {
        if (isNetworkConnected(getApplication())) {
            getApiObject(galleryList);
        } else {
            getLocalObject(galleryList);
        }
    }

    private void getLocalObject(List<Gallery> galleryList) {

        for (Gallery galleryLine : galleryList) {

            int galleryNumber = Integer.parseInt(galleryLine.getGallerynumber());

            disposable.add(
                    repository.getObjectLocal(getApplication().getApplicationContext(), galleryNumber)
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .doOnSubscribe(disposable1 -> loadingLiveData.setValue(false))
                            .doAfterTerminate(() -> loadingLiveData.setValue(false))
                            .subscribe(objectList -> objectLiveData.setValue(objectList)
                                    , throwable -> errorLiveData.setValue(throwable))
            );
        }
    }

    private void getApiObject(List<Gallery> galleryList) {

        for (Gallery galleryLine : galleryList) {

            int galleryNumber = Integer.parseInt(galleryLine.getGallerynumber());

            disposable.add(
                    repository.getObjectApi(galleryNumber)
                            .subscribeOn(Schedulers.newThread())
                            .map(objectResult -> saveItems(objectResult, galleryNumber))
                            .observeOn(AndroidSchedulers.mainThread())
                            .doOnSubscribe(disposable1 -> loadingLiveData.setValue(true))
                            .doAfterTerminate(() -> {
                                loadingLiveData.setValue(false);
                            })
                            .subscribe(objectResult -> objectLiveData.setValue(objectResult.getRecords())
                                    , throwable -> errorLiveData.setValue(throwable))
            );
        }
    }

    private ObjectResult saveItems(ObjectResult objectResult, int galleryNumber) {
        ObjectDAO objectDAO = Database.getDatabase(getApplication()
                .getApplicationContext())
                .objectDAO();

        //Atualiza o número da Galeria dos Objetos
        //Este campo não existe na URI Object, mas é chave para buscca por andares do Museu
        for (Object objectLine: objectResult.getRecords()){
            objectLine.setGalleryNumber(galleryNumber);
        }

        objectDAO.insertAll(objectResult.getRecords());
        return objectResult;
    }

    // Limpa as chamadas que fizemos no RX
    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}