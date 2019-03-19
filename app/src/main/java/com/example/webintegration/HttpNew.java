package com.example.webintegration;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bumptech.glide.util.LogTime;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class HttpNew extends AppCompatActivity {
    private final String URL = "https://storage.googleapis.com/network-security-conf-codelab.appspot.com/v2/posts.json";
    private static final String TAG = "HttpNew";
    String json = "";
    List<Users> list = new ArrayList<>();
    RecyclerView recyclerView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retractivity);
        recyclerView = findViewById(R.id.rv_retro);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        try {
            json = new MyAsync().execute(URL).get();

            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("posts");

            for(int i = 0; i<jsonArray.length(); i++){
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                Users users = new Users();
                users.setName(jsonObject1.getString("name"));
                users.setMessage(jsonObject1.getString("message"));
                users.setProfileImage(jsonObject1.getString("profileImage"));
                list.add(users);
                myAdapter = new MyAdapter(list,this);
                recyclerView.setAdapter(myAdapter);
                myAdapter.notifyDataSetChanged();

            }
            Log.i(TAG,  json);
        } catch (
                ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (
                JSONException e) {
            e.printStackTrace();
        }
    }

}
