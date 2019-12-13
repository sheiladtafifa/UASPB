package com.sheiladita.tugasuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class KoreanDrama extends AppCompatActivity{

    private static final String JSON_URL = "https://raw.githubusercontent.com/sheiladtafifa/Api/master/mykoreandrama.json";

    ListView listView;
    private List<KoreanDramaItem> koreanDramaItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_korean_drama);

        listView =  findViewById(R.id.listView);
        koreanDramaItemList = new ArrayList<>();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                KoreanDramaItem koreanDramaItem = koreanDramaItemList.get(position);

                Intent i = new Intent(getApplicationContext(), DetailKoreanDramaActivity.class);
                i.putExtra(DetailKoreanDramaActivity.EXTRA_KOREANDRAMA, koreanDramaItem);
                startActivity(i);
            }

        });
        loadKoreanDrama();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void loadKoreanDrama() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject obj = new JSONObject(response);
                            JSONArray koreandramaAray = obj.getJSONArray("result");

                            for (int i = 0; i < koreandramaAray.length(); i++) {

                                JSONObject koreandramaObject = koreandramaAray.getJSONObject(i);


                                KoreanDramaItem koreanDramaItem = new KoreanDramaItem(koreandramaObject.getString("id"),
                                        koreandramaObject.getString("drama"),
                                        koreandramaObject.getString("network"),
                                        koreandramaObject.getString("episodes"),
                                        koreandramaObject.getString("releasedate"),
                                        koreandramaObject.getString("runtime"),
                                        koreandramaObject.getString("genre"),
                                        koreandramaObject.getString("sinopsis"),
                                        koreandramaObject.getString("image"));

                                koreanDramaItemList.add(koreanDramaItem);
                            }

                            ListViewKoreanAdapter adapter = new ListViewKoreanAdapter(koreanDramaItemList, getApplicationContext());

                            listView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

}
