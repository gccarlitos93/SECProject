package es.ulpgc.eite.clean.mvp.sample.main;


import android.util.Log;

import es.ulpgc.eite.clean.mvp.GenericPresenter;
import es.ulpgc.eite.clean.mvp.sample.app.Mediator;

//Extender e implementar
public class MainPresenter extends GenericPresenter<Main.PresenterToView, Main.PresenterToModel, Main.ModelToPresenter, MainModel>
        implements Main.ViewToPresenter, Main.ModelToPresenter,  Main.ToMain {

    @Override
    public void onCreate(Main.PresenterToView view) {

        super.onCreate(MainModel.class, this);
        setView(view);
        Log.d(TAG, "calling onCreate()");

        Mediator app = (Mediator) getView().getApplication();
        app.startingMainScreen(this);
    }

    @Override
    public void onResume(Main.PresenterToView view) {

        setView(view);
        Log.d(TAG, "calling onResume()");



    }

    @Override
    public void onBackPressed() {

        Log.d(TAG, "calling onBackPressed()");

    }

    @Override
    public void onDestroy(boolean isChangingConfiguration){
        super.onDestroy(isChangingConfiguration);
        Log.d(TAG, "calling onDestroy()");
    }

    @Override
    public void onScreenStarted() {

        Log.d(TAG, "calling onScreenStarted()");

        if(isViewRunning()){
            getView().setSearchBtnLabel(getModel().getSearchBtnLabel());


        }
    }

    @Override
    public void setToolbarVisibility(boolean visible) {

    }
}
