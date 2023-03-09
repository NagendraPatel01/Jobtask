package com.example.newtaskjib;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycle=findViewById(R.id.recycle);

        RetrofitClient.getRetrofit().create(MyInterFace.class).retrivedata().enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {

                Log.d("dhgkyuguiy", "onResponse: "+response);
                Log.d("urgheriughieg", "onResponse: "+response.body());
                Log.d("urgheriughieg", "onResponse: "+response.body());

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
                recycle.setLayoutManager(linearLayoutManager);

                DataAdapter adapter=new DataAdapter(MainActivity.this,response.body().getEntries());
                recycle.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {

                Log.d("iuhefuweghuyew", "onFailure: "+t.getMessage());

            }
        });
    }
}