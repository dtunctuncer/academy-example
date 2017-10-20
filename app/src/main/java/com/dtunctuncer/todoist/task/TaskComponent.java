package com.dtunctuncer.todoist.task;

import com.dtunctuncer.todoist.di.components.ApplicationComponent;
import com.dtunctuncer.todoist.di.scopes.AcitivityScope;

import dagger.Component;

@AcitivityScope
@Component(modules = {TaskModule.class}, dependencies = {ApplicationComponent.class})
public interface TaskComponent {

    void inject(TaskActivity taskActivity);
}
