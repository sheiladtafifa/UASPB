package com.sheiladita.tugasuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyProfile extends AppCompatActivity implements View.OnClickListener {

    private Button btnBackProfile;
    public String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        btnBackProfile = findViewById(R.id.btn_back_profile);
        btnBackProfile.setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void gmail(View view){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:sheiladitaafifaa@gmail.com"));
        intent.putExtra(Intent.EXTRA_SUBJECT,"dear sheila");
        intent.putExtra(Intent.EXTRA_TEXT,text);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }

    public void telephone(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel: 081274123172"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back_profile:
                finish();
                break;
        }
    }
}
