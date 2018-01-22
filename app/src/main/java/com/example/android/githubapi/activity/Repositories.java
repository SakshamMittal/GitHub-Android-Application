package com.example.android.githubapi.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.android.githubapi.R;
import com.example.android.githubapi.adapter.ReposAdapter;
import com.example.android.githubapi.model.GitHubRepo;
import com.example.android.githubapi.rest.APIClient;
import com.example.android.githubapi.rest.GitHubRepoEndPoint;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repositories extends AppCompatActivity {

    String receivedUserName;
    TextView userNameTV;
    RecyclerView mRecyclerView;
    List<GitHubRepo> myDataSource = new ArrayList<>();
    RecyclerView.Adapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repositories);

        Bundle extras = getIntent().getExtras();
        receivedUserName = extras.getString("username");

        userNameTV = (TextView) findViewById(R.id.userNameTV);
        userNameTV.setText("User: " + receivedUserName);

        mRecyclerView = (RecyclerView) findViewById(R.id.repos_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new ReposAdapter(myDataSource, R.layout.list_item_repo,
                getApplicationContext());

        mRecyclerView.setAdapter(myAdapter);

        loadRepositories();
    }

    public void loadRepositories(){
        GitHubRepoEndPoint apiService =
                APIClient.getClient().create(GitHubRepoEndPoint.class);

        Call<List<GitHubRepo>> call = apiService.getRepo(receivedUserName);
        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {

                myDataSource.clear();
                myDataSource.addAll(response.body());
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                // Log error here since request failed
                Log.e("Repos", t.toString());
            }

        });
    }

}
