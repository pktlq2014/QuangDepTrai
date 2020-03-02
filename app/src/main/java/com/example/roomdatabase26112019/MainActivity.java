package com.example.roomdatabase26112019;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.roomdatabase26112019.model.database.Sinhvien;
import com.example.roomdatabase26112019.viewmodel.Mainviewmodel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button mBtnUpdate;
    Mainviewmodel mainviewmodel;
    Toolbar toolbarMain;
    ArrayList<Sinhvien> mArraylistSinhvien;
    RecyclerView mRv1;
    SinhvienAdapter mSvAdapter;
    private Mainviewmodel mainViewmodel;
    public static final int VALUE = 1;
    public static final int UPDATE = 1;
    public static final int INSERT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRv1 = findViewById(R.id.rcvSv);
        mRv1.setLayoutManager(new LinearLayoutManager(this));
        mRv1.setHasFixedSize(true);
        mSvAdapter = new SinhvienAdapter();
        mRv1.setAdapter(mSvAdapter);

        mainViewmodel = ViewModelProviders.of(this).get(Mainviewmodel.class);
        mainViewmodel.getAllSinhVien().observe(this, new Observer<List<Sinhvien>>() {
            @Override
            public void onChanged(List<Sinhvien> sinhviens) {
                mSvAdapter.setSinhviens(sinhviens);
            }
        });
//        mArraylistSinhvien = Sinhvien.mock();
//        mSvAdapter = new SinhvienAdapter(mArraylistSinhvien);
//        mRv1.setAdapter(mSvAdapter);


    //    mainviewmodel = new ViewModelProvider(this).get(Mainviewmodel.class);
     //   getLifecycle().addObserver(mainviewmodel);
        toolbarMain = findViewById(R.id.toolbar_main);
        setActionBar(toolbarMain);
        getActionBar().setTitle("");
        getActionBar().setDisplayShowHomeEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        toolbarMain.setBackgroundColor(Color.BLUE);

        toolbarMain.inflateMenu(R.menu.menu_main);

        mBtnUpdate = findViewById(R.id.btn_update);

        //obserData();
        setListener();

    }
    private void setListener() {
//        mainviewmodel.getAllSinhvien(this);
//        mainviewmodel.insertSinhvien(this, new Sinhvien[]{new Sinhvien("Nguyễn Văn A", 1990, "Quận 1")});
        toolbarMain.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Nut back", Toast.LENGTH_SHORT).show();
            }
        });
        toolbarMain.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.item_insert){
                    Intent intent = new Intent(MainActivity.this,MainInsert.class);
                    startActivityForResult(intent, INSERT);
                    // chuyen sang man hinh insert
                }
                return false;
            }
        });

        mBtnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//              chuyen man hinh qua update
                Intent intent = new Intent(MainActivity.this,MainUpdate.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

//    private void obserData() {
//        mainviewmodel.getAllSinhvienSuccess().observe(this, new Observer<List<Sinhvien>>() {
//            @Override
//            public void onChanged(List<Sinhvien> sinhviens) {
//                Log.d("BBB",sinhviens.toString());
//            }
//        });
//        mainviewmodel.getIdAfterInsertSuccess().observe(this, new Observer<List<Long>>() {
//            @Override
//            public void onChanged(List<Long> longs) {
//                Log.d("BBB",longs.toString());
//            }
//        });
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == INSERT && resultCode == RESULT_OK && data != null) {
            String name = data.getStringExtra(MainInsert.NAME);
            String yearBirth = data.getStringExtra(MainInsert.YEAR);

            String diachi = data.getStringExtra(MainInsert.HOME);


            Sinhvien sinhvien1 = new Sinhvien(name, yearBirth, diachi);
            mainViewmodel.insert(sinhvien1);
       //     mainViewmodel.insertSinhvien(MainActivity.this, sinhvien1);
//        Toast.makeText(MainActivity.this, "Thêm Thành Công", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(MainActivity.this,"ko nhan data",Toast.LENGTH_SHORT).show();
        }
    }
}
