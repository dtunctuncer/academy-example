package com.dtunctuncer.todoist;

import android.app.Application;

import com.dtunctuncer.todoist.di.components.ApplicationComponent;
import com.dtunctuncer.todoist.di.components.DaggerApplicationComponent;
import com.dtunctuncer.todoist.di.modules.ApplicationModule;
import com.dtunctuncer.todoist.di.modules.DatabaseModule;
import com.dtunctuncer.todoist.di.modules.NetModule;

public class TodoApp extends Application {

    public ApplicationComponent getComponent() {
        return component;
    }

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();


        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .netModule(new NetModule())
                .databaseModule(new DatabaseModule())
                .build();

    }
}
