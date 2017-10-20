package com.dtunctuncer.todoist.task;

import com.dtunctuncer.todoist.api.TodoApi;
import com.dtunctuncer.todoist.api.request.TaskCreateRequest;
import com.dtunctuncer.todoist.api.response.TaskResponse;
import com.dtunctuncer.todoist.db.DaoSession;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaskPresenter {

    private TodoApi api;
    private DaoSession session;
    private TaskView view;

    @Inject
    public TaskPresenter(TodoApi api, DaoSession session, TaskView view) {
        this.api = api;
        this.session = session;
        this.view = view;
    }

    public void getTasks(long projectId) {
        api.getTasksByProjectId(projectId).enqueue(new Callback<List<TaskResponse>>() {
            @Override
            public void onResponse(Call<List<TaskResponse>> call, Response<List<TaskResponse>> response) {
                if (response.isSuccessful()) {
                    view.fillRecycler(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<TaskResponse>> call, Throwable t) {

            }
        });
    }

    public void createTask(long projectId, String taskName) {
        TaskCreateRequest request = new TaskCreateRequest(taskName, projectId);

        api.createTask(request).enqueue(new Callback<TaskResponse>() {
            @Override
            public void onResponse(Call<TaskResponse> call, Response<TaskResponse> response) {
                if (response.isSuccessful()) {
                    view.taskCreateSuccess(response.body());
                } else {
                    view.taskCreateError("");
                }
            }

            @Override
            public void onFailure(Call<TaskResponse> call, Throwable t) {
                view.taskCreateError(t.getLocalizedMessage());
            }
        });
    }
}
