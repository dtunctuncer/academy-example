package com.dtunctuncer.todoist.api;

import com.dtunctuncer.todoist.api.response.ProjectResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TodoApi {

    @GET("projects")
    Call<List<ProjectResponse>> getProjects();
}
