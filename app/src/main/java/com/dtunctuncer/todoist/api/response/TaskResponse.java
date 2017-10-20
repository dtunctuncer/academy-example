package com.dtunctuncer.todoist.api.response;

import com.google.gson.annotations.SerializedName;

public class TaskResponse {

    @SerializedName("comment_count")
    private int commentCount;

    @SerializedName("project_id")
    private long projectId;

    @SerializedName("indent")
    private int indent;

    @SerializedName("id")
    private long id;

    @SerializedName("completed")
    private boolean completed;

    @SerializedName("priority")
    private int priority;

    @SerializedName("content")
    private String content;

    @SerializedName("url")
    private String url;

    @SerializedName("order")
    private int order;

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public int getIndent() {
        return indent;
    }

    public void setIndent(int indent) {
        this.indent = indent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return
                "TaskResponse{" +
                        "comment_count = '" + commentCount + '\'' +
                        ",project_id = '" + projectId + '\'' +
                        ",indent = '" + indent + '\'' +
                        ",id = '" + id + '\'' +
                        ",completed = '" + completed + '\'' +
                        ",priority = '" + priority + '\'' +
                        ",content = '" + content + '\'' +
                        ",url = '" + url + '\'' +
                        ",order = '" + order + '\'' +
                        "}";
    }
}