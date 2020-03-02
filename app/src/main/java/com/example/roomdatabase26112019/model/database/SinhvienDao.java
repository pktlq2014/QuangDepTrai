package com.example.roomdatabase26112019.model.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
import io.reactivex.Observable;

@Dao
public interface SinhvienDao {

    @Insert
    void insertSinhvien(Sinhvien sinhvien);
    // không dùng observable
    @Query("SELECT * FROM sinhvien")
    Observable<List<Sinhvien>> getAll();
    // dùng livedata
    @Query("SELECT * FROM sinhvien")
    LiveData<List<Sinhvien>> getAllSinhVien();

    // không dùng list
    @Insert
    List<Long> insertSinhvien(Sinhvien... sinhviens);

    // chỉ cần thêm đối tượng vào là insert không cần phải lưu vào list
    @Insert
    void insert(Sinhvien sinhvien);
}
