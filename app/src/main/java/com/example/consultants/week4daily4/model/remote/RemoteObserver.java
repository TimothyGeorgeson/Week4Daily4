package com.example.consultants.week4daily4.model.remote;

import com.example.consultants.week4daily4.model.DSGResponse.DSGResponse;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class RemoteObserver implements Observer<DSGResponse> {

    DSGCallback callback;

    public RemoteObserver(DSGCallback callback) {
        this.callback = callback;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(DSGResponse dsgResponse) {

        callback.onSuccess(dsgResponse.getVenues());
    }

    @Override
    public void onError(Throwable e) {

        callback.onFailure(e.getMessage());
    }

    @Override
    public void onComplete() {

    }
}
