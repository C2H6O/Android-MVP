package net.doubov.mvp.fragments;

import net.doubov.mvp.MvpBasePresenter;
import net.doubov.mvp.common.MvpLceView;

public class MvpBaseLcePresenter<RM, M, V extends MvpLceView<M>> extends MvpBasePresenter<M,V> {

    protected RM mData;

    public RM getData() {
        return mData;
    }

    public void setData(RM data) {
        mData = data;
    }
}
