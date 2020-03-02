package com.example.roomdatabase26112019.viewmodel;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import com.example.roomdatabase26112019.model.database.Sinhvien;
import com.example.roomdatabase26112019.repository.RoomRepository;

import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Mainviewmodel extends AndroidViewModel
{
    private RoomRepository roomRepository;
    private LiveData<List<Sinhvien>> allSinhVien;
    public Mainviewmodel(@NonNull Application application)
    {
        super(application);
        roomRepository = new RoomRepository(application);
        allSinhVien = roomRepository.getAllSinhVien();
    }
    public void insert(Sinhvien sinhvien)
    {
        roomRepository.insert(sinhvien);
    }
    public LiveData<List<Sinhvien>> getAllSinhVien()
    {
        return allSinhVien;
    }
// extends ViewModel implements LifecycleObserver
//    private CompositeDisposable compositeDisposable = new CompositeDisposable();
//    private MutableLiveData<List<Sinhvien>> mutableLiveDataAraySinhvien = new MutableLiveData<>();
//    private MutableLiveData<List<Long>> mutableLiveDataArrayId= new MutableLiveData<>();
//
//    public void getAllSinhvien(Context context) {
//        RoomRepository
//                .getInstance(context)
//                .getAllSinhvien()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<List<Sinhvien>>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        compositeDisposable.add(d);
//                    }
//
//                    @Override
//                    public void onNext(List<Sinhvien> sinhviens) {
//                        mutableLiveDataAraySinhvien.setValue(sinhviens);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//    }
//    public LiveData<List<Sinhvien>> getAllSinhvienSuccess(){
//        return mutableLiveDataAraySinhvien;
//    }
//
//
//    public void insertSinhvien(final Context context, final Sinhvien... sinhviens) {
//        Observable<List<Long>> observable = Observable.fromCallable(new Callable<List<Long>>() {
//            @Override
//            public List<Long> call() throws Exception {
//                return RoomRepository.getInstance(context).insertSinhvien(sinhviens);
//            }
//        });
//        observable.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<List<Long>>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        compositeDisposable.add(d);
//                    }
//
//                    @Override
//                    public void onNext(List<Long> longs) {
//                        mutableLiveDataArrayId.postValue(longs);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//    }
//    public LiveData<List<Long>> getIdAfterInsertSuccess(){
//        return mutableLiveDataArrayId;
//    }
//
//    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
//    public void clearConnectObserver(){
//        compositeDisposable.clear();
//        Log.d("BBB","onStop");
//    }
}
