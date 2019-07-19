package br.com.digitalhouse.harvardartmuseums.data;

import android.content.Context;

import java.util.List;

import javax.xml.transform.Result;

import br.com.digitalhouse.harvardartmuseums.data.database.DatabaseRoom;
import br.com.digitalhouse.harvardartmuseums.data.database.dao.ResultsDao;
import br.com.digitalhouse.harvardartmuseums.data.network.ApiService;
import br.com.digitalhouse.harvardartmuseums.model.Record;
import io.reactivex.Flowable;
import io.reactivex.Observable;

public class HarvardRepository {

    // Pega os dados da base de dados
    public Flowable<List<Record>> getLocalResults(Context context) {
        DatabaseRoom room = DatabaseRoom.getDatabase(context);
        ResultsDao resultsDao = room.resultsDAO();
        return resultsDao.getAll(1);
    }

    // Insere uma lista reults na base de dados
    public void insertItems(Context context, List<Result> items) {
        DatabaseRoom room = DatabaseRoom.getDatabase(context);
        ResultsDao resultsDao = room.resultsDAO();
        resultsDao.insert(items);
    }

    // Pega os items que virão da api do mercado livre
    public Observable<Record> searchFloor(int piso) {
        return ApiService.getApiService().getRecords("");
    }
}

}
