package com.sheiladita.tugasuts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

public class DetailCulinaryActivity extends AppCompatActivity {

    public static String EXTRA_CULINARY = "extra_culinary";
    TextView tvName, tvDescription;
    ImageView ivImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_culinary);

        tvName = findViewById(R.id.tvName);
        tvDescription = findViewById(R.id.tvDescription);
        ivImage = findViewById(R.id.ivImage);

        CulinaryItem culinaryItem =  getIntent().getParcelableExtra(EXTRA_CULINARY);

        String name = culinaryItem.getName();
        String description = culinaryItem.getDescription();

        tvName.setText(name);
        tvDescription.setText(description);
        Picasso.with(this).load(culinaryItem.getImage()).into(ivImage);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
