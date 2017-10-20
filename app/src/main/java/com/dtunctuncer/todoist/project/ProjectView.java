package com.dtunctuncer.todoist.project;

import com.dtunctuncer.todoist.api.response.ProjectResponse;

import java.util.List;

public interface ProjectView {
    void fillRecycler(List<ProjectResponse> body);
}
