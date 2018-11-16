package com.example.consultants.week4daily4.di;

import com.example.consultants.week4daily4.ui.main.MainActivity;

import dagger.Component;

@Component(modules = MainModule.class)
public interface MainComponent {

    void inject(MainActivity mainActivity);
}
