package com.example.roomdatabase26112019.repository;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.roomdatabase26112019.model.database.Sinhvien;
import com.example.roomdatabase26112019.model.database.SinhvienDao;
import com.example.roomdatabase26112019.model.database.SinhvienDatabase;

import java.util.List;

import io.reactivex.Observable;


public class RoomRepository {
    private SinhvienDao sinhvienDao;
    private LiveData<List<Sinhvien>> allSinhVien;
 //   private static RoomRepository roomRepository = null;



//    private RoomRepository(Context context){
//        SinhvienDatabase sinhvienDatabase = SinhvienDatabase.getInstance(context);
//        sinhvienDao = sinhvienDatabase.sinhvienDao();
//    }
 // thay bằng
    public RoomRepository(Application application)
    {
        SinhvienDatabase sinhvienDatabase = SinhvienDatabase.getInstance(application);
        sinhvienDao = sinhvienDatabase.sinhvienDao();
        allSinhVien = sinhvienDao.getAllSinhVien();
    }

//    public static RoomRepository getInstance(Context context){
//        if (roomRepository == null){
//            roomRepository = new RoomRepository(context);
//        }
//        return roomRepository;
//    }
    public void insert(Sinhvien sinhvien)
    {
        new InsertSinhVienAsynchTask(sinhvienDao).execute(sinhvien);
    }



    // không dùng observable
    public Observable<List<Sinhvien>> getAllSinhvien(){
        return sinhvienDao.getAll();
    }
    // dùng thằng này
    public LiveData<List<Sinhvien>> getAllSinhVien()
    {
        return allSinhVien;
    }
    // không dùng thằng naỳ
    public List<Long> insertSinhvien(Sinhvien... sinhviens){
        return sinhvienDao.insertSinhvien(sinhviens);
    }
    // dùng thằng này
    private static class InsertSinhVienAsynchTask extends AsyncTask<Sinhvien, Void, Void>
    {
        private SinhvienDao sinhvienDao;

        public InsertSinhVienAsynchTask(SinhvienDao sinhvienDao) {
            this.sinhvienDao = sinhvienDao;
        }

        @Override
        protected Void doInBackground(Sinhvien... sinhviens)
        {
            sinhvienDao.insert(sinhviens[0]);
            return null;
        }
    }
}
