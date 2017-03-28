package es.ulpgc.eite.clean.mvp.sample.main;


import es.ulpgc.eite.clean.mvp.GenericPresenter;

public class MainPresenter extends GenericPresenter<Main.PresenterToView, Main.PresenterToModel, Main.ModelToPresenter, MainModel>
        implements Main.ViewToPresenter, Main.ModelToPresenter,  Main.ToMain {

    @Override
    public void onCreate(Main.PresenterToView presenterToView) {

    }

    @Override
    public void onResume(Main.PresenterToView presenterToView) {

    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public void onScreenStarted() {

    }

    @Override
    public void setToolbarVisibility(boolean visible) {

    }
}
