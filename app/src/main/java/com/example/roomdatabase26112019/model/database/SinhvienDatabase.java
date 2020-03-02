package com.example.roomdatabase26112019.model.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Sinhvien.class}, version = 1, exportSchema = false)
public abstract class SinhvienDatabase extends RoomDatabase {

    private static SinhvienDatabase sinhvienDatabase = null;



    public abstract SinhvienDao sinhvienDao();

    public static synchronized SinhvienDatabase getInstance(Context context) {
        if (sinhvienDatabase == null) {
            sinhvienDatabase = Room.databaseBuilder(
                    context,
                    SinhvienDatabase.class,
                    "Quanlysinhvien")
                    .fallbackToDestructiveMigration()
                    .addCallback(callback)
                    .build();
        }
        return sinhvienDatabase;
    }

    private static RoomDatabase.Callback callback = new RoomDatabase.Callback()
    {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }
    };
    private static class PopulateDb extends AsyncTask<Void, Void, Void>
    {
        private SinhvienDao sinhvienDao;

        public PopulateDb(SinhvienDao sinhvienDao) {
            this.sinhvienDao = sinhvienDao;
        }

        @Override
        protected Void doInBackground(Void... voids)
        {
            sinhvienDao.insert(new Sinhvien("Đình Quang", "1998", "122/22 Hồ Tùng Mậu"));
            return null;
        }
    }
}
