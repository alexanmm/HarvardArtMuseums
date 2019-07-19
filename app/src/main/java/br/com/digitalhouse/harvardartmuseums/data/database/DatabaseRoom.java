package br.com.digitalhouse.harvardartmuseums.data.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.TypeConverters;

import br.com.digitalhouse.harvardartmuseums.data.database.dao.ResultsDao;
import br.com.digitalhouse.harvardartmuseums.model.Record;

@Database(entities = {Record.class}, version = 1, exportSchema = false)
@TypeConverters(Converters.class)
public abstract class DatabaseRoom {

    public abstract ResultsDao resultsDAO();

    private static volatile DatabaseRoom INSTANCE;

    public static DatabaseRoom getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DatabaseRoom.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DatabaseRoom.class, "my_db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
