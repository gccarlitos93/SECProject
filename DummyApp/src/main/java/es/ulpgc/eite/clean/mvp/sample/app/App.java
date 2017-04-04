package es.ulpgc.eite.clean.mvp.sample.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import es.ulpgc.eite.clean.mvp.sample.dummy.Dummy;
import es.ulpgc.eite.clean.mvp.sample.dummy.DummyView;
import es.ulpgc.eite.clean.mvp.sample.main.Main;
import es.ulpgc.eite.clean.mvp.sample.master.Master;


public class App extends Application implements Mediator, Navigator {

  private DummyState toDummyState, dummyToState;
  private MainState toMainState;
  private MasterState toMasterState;


  @Override
  public void onCreate() {
    super.onCreate();
    toDummyState = new DummyState();
    toDummyState.toolbarVisibility = false;
    toDummyState.textVisibility = false;

    toMainState = new MainState();
    toMasterState = new MasterState();
    toMasterState.hideToolbar = false;
  }

  ///////////////////////////////////////////////////////////////////////////////////
  // Mediator //////////////////////////////////////////////////////////////////////

  @Override
  public void startingDummyScreen(Dummy.ToDummy presenter){
    if(toDummyState != null) {
      presenter.setToolbarVisibility(toDummyState.toolbarVisibility);
      presenter.setTextVisibility(toDummyState.textVisibility);
    }
    presenter.onScreenStarted();
  }

  @Override
  public void startingMainScreen(Main.ToMain presenter){
    if(toMainState != null) {
      presenter.setToolbarVisibility(toMainState.toolbarVisibility);
      //presenter.setTextVisibility(toMainState.textVisibility);
    }
    //toMainState = null;
    presenter.onScreenStarted();
  }

  @Override
  public void startingMasterScreen(Master.ToMaster presenter) {
      if(toMasterState != null) {
        presenter.setToolbarVisibility(!toMasterState.hideToolbar);
      }
      // Una vez fijado el estado inicial, el maestro puede iniciarse normalmente
      presenter.onScreenStarted();
  }

  @Override
  public void resumingMasterScreen(Master.DetailToMaster presenter) {

  }

  ///////////////////////////////////////////////////////////////////////////////////
  // Navigator /////////////////////////////////////////////////////////////////////


  @Override
  public void goToNextScreen(Dummy.DummyTo presenter) {
    dummyToState = new DummyState();
    dummyToState.toolbarVisibility = presenter.isToolbarVisible();
    dummyToState.textVisibility = presenter.isTextVisible();

    Context view = presenter.getManagedContext();
    if (view != null) {
      view.startActivity(new Intent(view, DummyView.class));
      presenter.destroyView();
    }

  }

  ///////////////////////////////////////////////////////////////////////////////////
  // State /////////////////////////////////////////////////////////////////////////

  private class DummyState {
    boolean toolbarVisibility;
    boolean textVisibility;
  }

  private class MainState {
    boolean toolbarVisibility;
    //boolean textVisibility;
  }

  private class MasterState {
    boolean hideToolbar;
  }
}
