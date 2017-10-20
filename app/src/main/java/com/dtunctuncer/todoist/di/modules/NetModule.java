package com.dtunctuncer.todoist.di.modules;

import android.os.Environment;

import com.dtunctuncer.todoist.BuildConfig;
import com.dtunctuncer.todoist.api.TodoApi;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetModule {

    @Provides
    @Singleton
    @Named("cached")
    OkHttpClient provideCachedOkHttp() {

        Cache cache = new Cache(Environment.getDownloadCacheDirectory(), 10 * 1024 * 1024);
        return new OkHttpClient.Builder()
                .readTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .cache(cache)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        String token = request.url().url().toString().contains("?") ? "&token=" + BuildConfig.API_KEY : "?token=" + BuildConfig.API_KEY;

                        Request modifiedRequest = request.newBuilder()
                                .url(request.url().url().toString() + token)
                                .build();

                        return chain.proceed(modifiedRequest);
                    }
                })
                .build();
    }


    @Provides
    @Singleton
    @Named("non-cached")
    OkHttpClient provideOkHttp() {
        return new OkHttpClient.Builder()
                .readTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        String token = request.url().url().toString().contains("?") ? "&token=" + BuildConfig.API_KEY : "?token=" + BuildConfig.API_KEY;

                        Request modifiedRequest = request.newBuilder()
                                .url(request.url().url().toString() + token)
                                .build();

                        return chain.proceed(modifiedRequest);
                    }
                })
                .build();
    }


    @Provides
    @Singleton
    Retrofit provideRetrofit(@Named("cached") OkHttpClient client) {
        return new Retrofit.Builder()
                .client(client)
                .baseUrl("https://beta.todoist.com/API/v8/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    TodoApi provideApi(Retrofit retrofit) {
        return retrofit.create(TodoApi.class);
    }

}