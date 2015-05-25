package net.doubov.mvp.fragments;

import net.doubov.mvp.MvpBasePresenter;
import net.doubov.mvp.common.MvpLceView;

public class MvpBaseLcePresenter<M, V extends MvpLceView<M>> extends MvpBasePresenter<M,V> {

    protected M mData;

    public M getData() {
        return mData;
    }

    public void setData(M data) {
        mData = data;
    }
}
