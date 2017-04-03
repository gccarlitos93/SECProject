package es.ulpgc.eite.clean.mvp.sample.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import es.ulpgc.eite.clean.mvp.sample.dummy.Dummy;
import es.ulpgc.eite.clean.mvp.sample.dummy.DummyView;
import es.ulpgc.eite.clean.mvp.sample.filter.FilterView;
import es.ulpgc.eite.clean.mvp.sample.main.Main;


public class App extends Application implements Mediator, Navigator {

  private DummyState toDummyState, dummyToState;
  private MainState toMainState;
  private FilterState mainToFilterState;


  @Override
  public void onCreate() {
    super.onCreate();
    toDummyState = new DummyState();
    toDummyState.toolbarVisibility = false;
    toDummyState.textVisibility = false;

    toMainState = new MainState();

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
  public void startingFilterScreen(Filter.MainToFilter presenter) {
    if(mainToFilterState != null){
      presenter.setTextVisibility(mainToFilterState.textVisibility);
      presenter.setToolbarVisibility(mainToFilterState.toolbarVisibility);
      //presenter.setHelloButtonClicked(helloToByeState.buttonClicked);

    }

    presenter.onScreenStarted();
  }

  ///////////////////////////////////////////////////////////////////////////////////
  // Navigator /////////////////////////////////////////////////////////////////////

  public void goToFilterScreen(Main.MainToFilter presenter) {
    mainToFilterState = new FilterState();
    mainToFilterState.toolbarVisibility = presenter.isToolbarVisible();
    //helloToByeState.msg = presenter.getMessage();
    //mainToFilterState.buttonClicked = presenter.isButtonClicked();
    //mainToFilterState.textVisibility = presenter.isTextVisible();

    Context view = presenter.getManagedContext();
    if (view != null) {
      view.startActivity(new Intent(view, FilterView.class));
      //presenter.destroyView();
    }

  }


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

  @Override
  public void goToMainScreen(Filter.FilterToMain presenter) {

  }

  ///////////////////////////////////////////////////////////////////////////////////
  // State /////////////////////////////////////////////////////////////////////////

  private class DummyState {
    boolean toolbarVisibility;
    boolean textVisibility;
  }

  private class FilterState {
    boolean toolbarVisibility;
    boolean buttonClicked;
    boolean textVisibility;
    //public String msg;
  }

  private class MainState {
    boolean toolbarVisibility;
    //boolean textVisibility;
  }


}
