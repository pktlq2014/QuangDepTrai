package com.example.roomdatabase26112019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainUpdate extends AppCompatActivity {
    Toolbar toolbarUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_update);

        toolbarUpdate = findViewById(R.id.toolbar_update);
        setActionBar(toolbarUpdate);
        getActionBar().setTitle("Update");
        getActionBar().setDisplayShowHomeEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        toolbarUpdate.setBackgroundColor(Color.DKGRAY);
        toolbarUpdate.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainUpdate.this, "Back ne", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainUpdate.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
