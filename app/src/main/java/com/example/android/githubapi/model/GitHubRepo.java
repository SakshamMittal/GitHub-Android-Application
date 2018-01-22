package com.example.android.githubapi.model;

import com.google.gson.annotations.SerializedName;

public class GitHubRepo {

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("language")
    private String language;

    public GitHubRepo(String name, String language, String description){
        this.setLanguage(language);
        this.setName(name);
        this.setDescription(description);
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public void setLanguage(String language){
        this.language = language;
    }
    public String getLanguage(){
        return language;
    }

    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
    }
}
