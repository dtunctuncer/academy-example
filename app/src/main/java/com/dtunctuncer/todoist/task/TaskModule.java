package com.dtunctuncer.todoist.task;

import com.dtunctuncer.todoist.di.scopes.AcitivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class TaskModule {

    private TaskView taskView;

    public TaskModule(TaskView taskView) {
        this.taskView = taskView;
    }

    @AcitivityScope
    @Provides
    TaskView getTaskView() {
        return taskView;
    }
}
