package com.example.consultants.week4daily4.di;

import com.example.consultants.week4daily4.model.remote.DSGRepository;
import com.example.consultants.week4daily4.model.remote.RemoteDataSource;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    RemoteDataSource providesRemoteDataSource() {
        return new RemoteDataSource();
    }

    @Provides
    DSGRepository providesRandomRepository(RemoteDataSource remoteDataSource) {
        return new DSGRepository(remoteDataSource);
    }
}
