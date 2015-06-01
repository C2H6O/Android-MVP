package net.doubov.mvp;

import java.lang.ref.WeakReference;

public abstract class MvpBasePresenter<M, V extends MvpView<M>>
        implements MvpPresenter<M,V>, MvpPresenterLifecycle {

    private WeakReference<V> mViewRef;

    @Override
    public void attachView(V view) {
        mViewRef = new WeakReference<>(view);
    }

    @Override
    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

    protected V getView() {
        return mViewRef.get();
    }

    protected boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    @Override
    public void onCreate() {
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onDestroy() {
    }

}
