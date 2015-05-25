package net.doubov.mvp.common;

import net.doubov.mvp.MvpView;

public interface MvpLceView<M> extends MvpView<M> {

    void showLoading();

    void showContent();

    void showError(String message);

    void setData(M data);

    boolean hasData();
    /**
     * Clear the data.
     */
    void clearData();

}
