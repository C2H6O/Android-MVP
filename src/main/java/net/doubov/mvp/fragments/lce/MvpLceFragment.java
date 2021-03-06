package net.doubov.mvp.fragments.lce;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import net.doubov.mvp.MvpBasePresenter;
import net.doubov.mvp.common.MvpLceView;
import net.doubov.mvp.fragments.MvpBaseLcePresenter;
import net.doubov.mvp.fragments.MvpFragment;
import net.doubov.mvp.common.LceAnimator;

import net.doubov.mvp.R;

public abstract class MvpLceFragment<CV extends View, RM, VM, V extends MvpLceView<VM>, P extends MvpBaseLcePresenter<RM, VM, V>>
        extends MvpFragment<VM,V,P>
        implements MvpLceView<VM> {

    protected View mLoadingView;
    protected CV mContentView;
    protected TextView mErrorView;
    protected boolean mAnimateChanges = true;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mLoadingView = view.findViewById(R.id.loadingView);
        mContentView = (CV) view.findViewById(R.id.contentView);
        mErrorView = (TextView) view.findViewById(R.id.errorView);

        if (mLoadingView == null) {
            throw new NullPointerException(
                    "Loading view is null! Have you specified a loading view in your layout xml file?"
                            + " You have to give your loading View the id R.id.loadingView");
        }

        if (mContentView == null) {
            throw new NullPointerException(
                    "Content view is null! Have you specified a content view in your layout xml file?"
                            + " You have to give your content View the id R.id.contentView");
        }

        if (mErrorView == null) {
            throw new NullPointerException(
                    "Error view is null! Have you specified a content view in your layout xml file?"
                            + " You have to give your error View the id R.id.errorView");
        }

        mErrorView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                onErrorViewClicked();
            }
        });
        onLceViewsCreated();

    }

    protected void onLceViewsCreated() {
    }

    protected abstract void onErrorViewClicked();

    protected void setAnimateChanges(boolean animateChanges) {
        mAnimateChanges = animateChanges;
    }

    @Override
    public void showLoading() {
        LceAnimator.showLoading(mLoadingView, mContentView, mErrorView);
    }
    @Override
    public void showContent() {
        LceAnimator.showContent(mAnimateChanges, mLoadingView, mContentView, mErrorView);
    }

    @Override
    public void showError(String message) {
        mErrorView.setText(message);
        LceAnimator.showErrorView(mAnimateChanges, mLoadingView, mContentView, mErrorView);
    }

}
