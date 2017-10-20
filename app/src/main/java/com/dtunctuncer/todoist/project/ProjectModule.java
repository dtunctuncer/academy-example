package com.dtunctuncer.todoist.project;

import com.dtunctuncer.todoist.di.components.ApplicationComponent;
import com.dtunctuncer.todoist.di.scopes.AcitivityScope;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

@Module
public class ProjectModule {

    private ProjectView view;

    public ProjectModule(ProjectView view) {
        this.view = view;
    }

    @Provides
    @AcitivityScope
    public ProjectView getView() {
        return view;
    }
}