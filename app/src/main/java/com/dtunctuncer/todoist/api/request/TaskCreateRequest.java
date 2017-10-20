package com.dtunctuncer.todoist.api.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TaskCreateRequest {

    @Expose
    @SerializedName("project_id")
    private long project_id;
    @Expose
    @SerializedName("content")
    private String content;


    public TaskCreateRequest(String taskName, long project_id) {
        this.content = taskName;
        this.project_id = project_id;
    }

    public long getProject_id() {
        return project_id;
    }

    public void setProject_id(long project_id) {
        this.project_id = project_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}