package com.example.roomdatabase26112019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainInsert extends AppCompatActivity {
    Toolbar toolbarMainInsert;
    Button mBtnInsert;
    EditText mEdtTen,mEdtNamsinh,mEdtDiachi;

    public static final String NAME = "NAME";
    public static final String YEAR = "YEAR";
    public static final String HOME = "HOME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_insert);

        init();
        backclick();
        insertclick();
    }


    private void insertclick() {
        mBtnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mEdtTen.getText().toString();
                String diachi = mEdtDiachi.getText().toString();
                String value1 = mEdtNamsinh.getText().toString();
                if(name.equals("") || diachi.equals("") || value1.equals(""))
                {
                    Toast.makeText(MainInsert.this, "Chưa nhập thông tin", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent();
                    intent.putExtra(NAME, name);
                    intent.putExtra(YEAR, value1);
                    intent.putExtra(HOME, diachi);
                    setResult(RESULT_OK, intent);
                    finish();
                }

//                startActivity(intent);
            }
        });
    }

    private void backclick() {
        toolbarMainInsert.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainInsert.this,"Nut Back",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainInsert.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init(){
        mBtnInsert = findViewById(R.id.btn_insert);
        mEdtTen = findViewById(R.id.edt_name);
        mEdtDiachi = findViewById(R.id.edt_address);
        mEdtNamsinh = findViewById(R.id.edt_year);


        toolbarMainInsert = findViewById(R.id.toolbar_insert);
        setActionBar(toolbarMainInsert);
        getActionBar().setTitle("Insert");
        getActionBar().setDisplayShowHomeEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        toolbarMainInsert.setBackgroundColor(Color.BLUE);
    }
}
