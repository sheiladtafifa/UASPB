package com.sheiladita.tugasuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

public class MyCulinary extends AppCompatActivity {

    private static final String JSON_URL = "https://raw.githubusercontent.com/sheiladtafifa/Api/master/myculinary.json";

    ListView listView;
    private List<CulinaryItem> culinaryItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_culinary);

        listView =  findViewById(R.id.listView);
        culinaryItemList = new ArrayList<>();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                CulinaryItem culinaryItem = culinaryItemList.get(position);

                Intent i = new Intent(getApplicationContext(), DetailCulinaryActivity.class);
                i.putExtra(DetailCulinaryActivity.EXTRA_CULINARY, culinaryItem);
                startActivity(i);
            }

        });
        loadCulinary();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

        private void loadCulinary() {
            StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            try {
                                JSONObject obj = new JSONObject(response);
                                JSONArray culinaryArray = obj.getJSONArray("result");

                                for (int i = 0; i < culinaryArray.length(); i++) {

                                    JSONObject culinaryObject = culinaryArray.getJSONObject(i);


                                    CulinaryItem culinaryItem = new CulinaryItem(culinaryObject.getString("id"),
                                            culinaryObject.getString("name"),
                                            culinaryObject.getString("description"),
                                            culinaryObject.getString("image"));

                                    culinaryItemList.add(culinaryItem);
                                }

                                ListViewCulinaryAdapter adapter = new ListViewCulinaryAdapter(culinaryItemList, getApplicationContext());

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
