package com.dtunctuncer.todoist.project;

import com.dtunctuncer.todoist.di.components.ApplicationComponent;
import com.dtunctuncer.todoist.di.scopes.AcitivityScope;

import dagger.Component;

@AcitivityScope
@Component(modules = {ProjectModule.class}, dependencies = {ApplicationComponent.class})
public interface ProjectComponent {
    void inject(ProjectActivity projectActivity);
}
