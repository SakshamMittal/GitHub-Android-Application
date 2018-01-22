package com.example.android.githubapi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.githubapi.R;
import com.example.android.githubapi.model.GitHubRepo;

import java.util.List;

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.ReposViewHolder>{

    private List<GitHubRepo> repos;
    private int rowLayout;
    private Context context;

    public ReposAdapter(List<GitHubRepo> repos, int rowLayout, Context context){
        this.setRepos(repos);
        this.setRowLayout(rowLayout);
        this.setContext(context);
    }

    public List<GitHubRepo> getRepos(){
        return repos;
    }
    public void setRepos(List<GitHubRepo> repos){
        this.repos = repos;
    }
    public int getRowLayout(){
        return rowLayout;
    }
    public void setRowLayout(int rowLayout){
        this.rowLayout = rowLayout;
    }
    public Context getContext(){
        return context;
    }
    public void setContext(Context context){
        this.context = context;
    }

    @Override
    public ReposAdapter.ReposViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new ReposViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ReposViewHolder holder, final int position) {
        holder.repoName.setText(repos.get(position).getName());
        holder.repoDescription.setText(repos.get(position).getDescription());
        holder.repoLanguage.setText(repos.get(position).getLanguage());
    }

    @Override
    public int getItemCount() {
        return repos.size();
    }

    public static class ReposViewHolder extends RecyclerView.ViewHolder{
        LinearLayout reposLayout;
        TextView repoName;
        TextView repoDescription;
        TextView repoLanguage;

        public ReposViewHolder(View v){
            super(v);
            reposLayout = (LinearLayout) v.findViewById(R.id.repo_item_layout);
            repoName = (TextView) v.findViewById(R.id.repoName);
            repoDescription = (TextView) v.findViewById(R.id.repoDescription);
            repoLanguage = (TextView) v.findViewById(R.id.repoLanguage);
        }
    }
}
