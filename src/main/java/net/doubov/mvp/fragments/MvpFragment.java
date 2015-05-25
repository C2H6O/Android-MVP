package net.doubov.mvp.fragments;

import android.os.Bundle;
import android.view.View;

import net.doubov.mvp.MvpBasePresenter;
import net.doubov.mvp.MvpView;

public abstract class MvpFragment<P extends MvpBasePresenter> extends BaseFragment implements MvpView {

    protected P mPresenter;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPresenter = getPresenter();

        if (mPresenter == null) {
            throw new IllegalStateException("Presenter must not be null!");
        }

        attachPresenterView();
    }

    /**
     * Subclasses should override this method if some of the Presenter's view dependencies are not
     * solely satisfied by this class.
     */
    protected void attachPresenterView() {
        mPresenter.attachView(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.detachView();
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    protected abstract void injectDependencies();

    protected abstract P getPresenter();

    @Override
    protected void onDependenciesInjected() {
        mPresenter = getPresenter();
        onPresenterInjected();
        mPresenter.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    protected void onPresenterInjected() {

    }

}
