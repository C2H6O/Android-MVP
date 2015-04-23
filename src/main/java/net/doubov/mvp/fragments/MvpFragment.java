package net.doubov.mvp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import net.doubov.mvp.MvpPresenter;
import net.doubov.mvp.MvpView;

public abstract class MvpFragment<P extends MvpPresenter> extends BaseFragment implements MvpView {

    protected P mPresenter;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPresenter = getPresenter();

        if (mPresenter == null) {
            throw new IllegalStateException("Presenter must not be null!");
        }

        mPresenter.attachView(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.detachView();
    }

    protected abstract void injectDependencies(Context context);

    protected abstract P getPresenter();

}
