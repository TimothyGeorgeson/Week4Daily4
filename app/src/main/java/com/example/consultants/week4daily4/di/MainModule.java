package com.example.consultants.week4daily4.di;

import com.example.consultants.week4daily4.model.remote.DSGRepository;
import com.example.consultants.week4daily4.ui.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module(includes = DataModule.class)
public class MainModule {

    @Provides
    MainPresenter providesMainPresenter(DSGRepository dsgRepository) {
        return new MainPresenter(dsgRepository);
    }
}
