package net.doubov.mvp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import butterknife.ButterKnife;
import icepick.Icepick;

public abstract class BaseFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        FragmentArgs.inject(this);
        Icepick.restoreInstanceState(this, savedInstanceState);

        injectDependencies();
        onDependenciesInjected();

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.inject(this, view);
        onButterKnifeViewsInjected();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        ButterKnife.reset(this);
    }

    protected void injectDependencies() {

    }

    protected void onDependenciesInjected() {

    }

    protected void onButterKnifeViewsInjected() {

    }

}
