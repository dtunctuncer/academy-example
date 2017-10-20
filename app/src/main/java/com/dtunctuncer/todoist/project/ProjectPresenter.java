
package com.dtunctuncer.todoist.project;

import com.dtunctuncer.todoist.api.TodoApi;
import com.dtunctuncer.todoist.api.response.ProjectResponse;
import com.dtunctuncer.todoist.db.DaoSession;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectPresenter {
    private ProjectView view;
    private TodoApi api;
    private DaoSession daoSession;

    @Inject
    public ProjectPresenter(ProjectView view, TodoApi api, DaoSession daoSession) {
        this.view = view;
        this.api = api;
        this.daoSession = daoSession;
    }

    public void getData() {
        api.getProjects().enqueue(new Callback<List<ProjectResponse>>() {
            @Override
            public void onResponse(Call<List<ProjectResponse>> call, Response<List<ProjectResponse>> response) {

                if (response.isSuccessful()) {
                    view.fillRecycler(response.body());
                }

            }

            @Override
            public void onFailure(Call<List<ProjectResponse>> call, Throwable t) {

            }
        });

    }
}
