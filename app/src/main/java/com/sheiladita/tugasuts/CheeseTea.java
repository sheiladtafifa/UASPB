package com.sheiladita.tugasuts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CheeseTea extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheese_tea);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new BanBanFragment()).commit();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener  =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()){
                        case R.id.nav_banban:
                            selectedFragment = new BanBanFragment();
                            break;
                        case R.id.nav_gulugulu:
                            selectedFragment = new GuluGuluFragment();
                            break;
                        case R.id.nav_kokumi:
                            selectedFragment = new KokumiFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

}
