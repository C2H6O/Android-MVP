package net.doubov.mvp.fragments;

import android.os.Bundle;
import android.view.View;

import net.doubov.mvp.MvpBasePresenter;
import net.doubov.mvp.MvpView;

public abstract class MvpFragment<M, V extends MvpView<M>, P extends MvpBasePresenter<M,V>> extends BaseFragment implements MvpView<M> {

    protected P mPresenter;
    private boolean mPresenterViewAttached = false;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPresenter = getPresenter();

        if (mPresenter == null) {
            throw new IllegalStateException("Presenter must not be null!");
        }
    }

    protected void attachPresenterView() {
        mPresenter.attachView((V) this);
        mPresenterViewAttached = true;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.detachView();
        mPresenterViewAttached = false;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (!mPresenterViewAttached) {
            throw new IllegalStateException("Attach Presenter's View by calling attachPresenterView()");
        }
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
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    protected void onPresenterInjected() {

    }

}
