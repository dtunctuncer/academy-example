package com.dtunctuncer.todoist.di.modules;

import android.content.Context;

import com.dtunctuncer.todoist.db.DaoMaster;
import com.dtunctuncer.todoist.db.DaoSession;

import org.greenrobot.greendao.database.Database;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {

    @Provides
    @Singleton
    DaoSession provideDaoSession(Context context) {
        DaoMaster.OpenHelper helper = new DaoMaster.DevOpenHelper(context, "todo-db");
        Database database = helper.getWritableDb();
        return new DaoMaster(database).newSession();
    }
}