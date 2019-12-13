package com.sheiladita.tugasuts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Goblin extends AppCompatActivity implements View.OnClickListener {

    private Button btnBackGoblin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goblin);

        btnBackGoblin = findViewById(R.id.btn_back_goblin);
        btnBackGoblin.setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_back_goblin:
                finish();
                break;
        }

    }
}
