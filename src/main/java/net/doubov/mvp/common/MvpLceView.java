package net.doubov.mvp.common;

import net.doubov.mvp.MvpView;

public interface MvpLceView<M> extends MvpView {

    void showLoading();

    void showContent();

    void showError(String message);

    void setData(M data);

    boolean hasData();

    void clearData();

    M getUiData();

}
