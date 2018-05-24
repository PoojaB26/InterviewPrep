package com.poojab26.firebasedatabasecrud.Model;

/**
 * Created by poojab26 on 25-May-18.
 */
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Topics {

    @SerializedName("topics")
    @Expose
    private List<Topic> topics = null;

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

}