package com.sheiladita.tugasuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

     Button btnMyProfile;
     Button btnCulinary;
     Button btnKoreanDrama;
     Button btnCheeseTea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMyProfile = findViewById(R.id.btn_myprofile);
        btnMyProfile.setOnClickListener(this);

        btnCulinary = findViewById(R.id.btn_culinary);
        btnCulinary.setOnClickListener(this);

        btnKoreanDrama = findViewById(R.id.btn_koreandrama);
        btnKoreanDrama.setOnClickListener(this);

        btnCheeseTea = findViewById(R.id.btn_cheesetea);
        btnCheeseTea.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_myprofile:
                Intent moveProfile = new Intent(MainActivity.this,MyProfile.class);
                startActivity(moveProfile);
                break;

            case R.id.btn_culinary:
                Intent moveCulinary = new Intent(MainActivity.this,MyCulinary.class);
                startActivity(moveCulinary);
                break;

            case R.id.btn_koreandrama:
                Intent moveKoreanDrama = new Intent(MainActivity.this,KoreanDrama.class);
                startActivity(moveKoreanDrama);
                break;

            case R.id.btn_cheesetea:
                Intent moveCheeseTea = new Intent(MainActivity.this,CheeseTea.class);
                startActivity(moveCheeseTea);
                break;

        }

    }
}
