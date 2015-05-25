package net.doubov.mvp;

public interface MvpPresenter<M, V extends MvpView<M>> {

    void attachView(V view);

    void detachView();

}
