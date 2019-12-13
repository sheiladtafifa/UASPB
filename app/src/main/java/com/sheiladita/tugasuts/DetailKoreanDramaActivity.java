package com.sheiladita.tugasuts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

public class DetailKoreanDramaActivity extends AppCompatActivity {

    public static String EXTRA_KOREANDRAMA = "extra_koreandrama";
    TextView tvDrama, tvNetwork, tvEpisodes, tvReleaseDate, tvRuntime, tvGenre, tvSinopsis;
    ImageView ivImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_korean_drama);

        tvDrama = findViewById(R.id.tvDrama);
        tvNetwork = findViewById(R.id.tvNetwork);
        tvEpisodes = findViewById(R.id.tvEpisodes);
        tvReleaseDate = findViewById(R.id.tvReleaseDate);
        tvRuntime = findViewById(R.id.tvRuntime);
        tvGenre = findViewById(R.id.tvGenre);
        tvSinopsis = findViewById(R.id.tvSinopsis);
        ivImage = findViewById(R.id.ivImage);

        KoreanDramaItem koreanDramaItem =  getIntent().getParcelableExtra(EXTRA_KOREANDRAMA);

        String drama = koreanDramaItem.getDrama();
        String network = koreanDramaItem.getNetwork();
        String episodes = koreanDramaItem.getEpisodes();
        String releasedate = koreanDramaItem.getReleasedate();
        String runtime = koreanDramaItem.getRuntime();
        String genre = koreanDramaItem.getGenre();
        String sinopsis = koreanDramaItem.getSinopsis();

        tvDrama.setText(drama);
        tvNetwork.setText(network);
        tvEpisodes.setText(episodes);
        tvReleaseDate.setText(releasedate);
        tvRuntime.setText(runtime);
        tvGenre.setText(genre);
        tvSinopsis.setText(sinopsis);
        Picasso.with(this).load(koreanDramaItem.getImage()).into(ivImage);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
