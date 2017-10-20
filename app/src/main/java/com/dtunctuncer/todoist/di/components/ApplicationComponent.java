package com.dtunctuncer.todoist.di.components;

import android.content.Context;

import com.dtunctuncer.todoist.api.TodoApi;
import com.dtunctuncer.todoist.db.DaoSession;
import com.dtunctuncer.todoist.di.modules.ApplicationModule;
import com.dtunctuncer.todoist.di.modules.DatabaseModule;
import com.dtunctuncer.todoist.di.modules.NetModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, NetModule.class, DatabaseModule.class})
public interface ApplicationComponent {

    Context context();

    TodoApi todoapi();

    DaoSession session();
}
