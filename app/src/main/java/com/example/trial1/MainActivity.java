package com.example.trial1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView post_data = findViewById(R.id.post);

        //making the post that going to be posted
        //for post only
        // 1) making post by using the data class
        data data = new data(5,"hi this is nada","this is my firts post");

        //2) making a post by using hashmap (for data which has nothing to do with each other)
        HashMap<Object,Object> map=new HashMap<>();
        //lazm bnfs l tarteb l fe l jasonplace holder site
        map.put("title","hellooooooooooo");
        map.put("body","I can do it");
        map.put("userId",6);

        // it is time to upload our post
        // used in both get and post
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // both get and post
        Api_Interface api_interface= retrofit.create(Api_Interface.class);

        Call<data> call =api_interface.storepost(map);

        call.enqueue((new Callback<com.example.trial1.data>() {
            @Override
            public void onResponse(Call<com.example.trial1.data> call, Response<com.example.trial1.data> response) {
                //if it worked then show me what is posted on my app
                post_data.setText(response.body().getTitle());
            }

            @Override
            public void onFailure(Call<com.example.trial1.data> call, Throwable t) {
                // if it failed then show me error message
                post_data.setText(t.getMessage());


            }
        }));




        //----------------------- get method ---------------------//
        // Call<data> call = api_interface.getpost();

       /* call.enqueue(new Callback<data>() {
            @Override
            public void onResponse(Call<data> call, Response<data> response) {

                post_data.setText(response.body().getBody());
            }

            @Override
            public void onFailure(Call<data> call, Throwable t) {

                post_data.setText(t.getMessage());

            }
        });*/
    }
}