package com.dtunctuncer.todoist.api;

import com.dtunctuncer.todoist.api.request.TaskCreateRequest;
import com.dtunctuncer.todoist.api.response.ProjectResponse;
import com.dtunctuncer.todoist.api.response.TaskResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface TodoApi {

    @GET("projects")
    Call<List<ProjectResponse>> getProjects();

    @GET("tasks")
    Call<List<TaskResponse>> getTasksByProjectId(@Query("project_id") long projectId);

    @Headers(value = "Content-Type: application/json")
    @POST("tasks")
    Call<TaskResponse> createTask(@Body TaskCreateRequest taskCrateRequest);
}
