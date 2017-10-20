package com.dtunctuncer.todoist.di.modules;

import android.content.Context;

import com.dtunctuncer.todoist.TodoApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private TodoApp app;

    public ApplicationModule(TodoApp app) {
        this.app = app;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return app.getApplicationContext();
    }

}