package com.poojab26.firebasedatabasecrud.Model;

/**
 * Created by poojab26 on 25-May-18.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Topic {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("branch")
    @Expose
    private String branch;
    @SerializedName("difficulty")
    @Expose
    private String difficulty;
    @SerializedName("revision_count")
    @Expose
    private int revisionCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getRevisionCount() {
        return revisionCount;
    }

    public void setRevisionCount(int revisionCount) {
        this.revisionCount = revisionCount;
    }

    public Topic(String name, String branch, String difficulty, int revisionCount){
        this.name = name;
        this.branch = branch;
        this.difficulty = difficulty;
        this.revisionCount = revisionCount;
    }

}