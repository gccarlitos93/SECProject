package es.ulpgc.eite.clean.mvp.sample.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import es.ulpgc.eite.clean.mvp.sample.data.ModelItem;
import es.ulpgc.eite.clean.mvp.sample.detail.Detail;
import es.ulpgc.eite.clean.mvp.sample.detail.DetailView;
import es.ulpgc.eite.clean.mvp.sample.dummy.Dummy;
import es.ulpgc.eite.clean.mvp.sample.dummy.DummyView;
import es.ulpgc.eite.clean.mvp.sample.filter.Filter;
import es.ulpgc.eite.clean.mvp.sample.filter.FilterView;
import es.ulpgc.eite.clean.mvp.sample.main.Main;
import es.ulpgc.eite.clean.mvp.sample.master.Master;
import io.realm.Realm;


public class App extends Application implements Mediator, Navigator {

  private DummyState toDummyState, dummyToState;
  private MasterState toMasterState;
  private MainState toMainState;
  private FilterState mainToFilterState;

  private DetailState masterToDetailState;
  private ListState detailToMasterState;


  @Override
  public void onCreate() {
    super.onCreate();
    Realm.init(this);

    toMasterState = new MasterState();
    toMasterState.hideToolbar = false;

    toMainState = new MainState();

  }

  /////////////////////////////////////////////////////////////////////////////////////



  /**
   * Llamado al navegar desde el maestro al detalle para fijar el estado inicial del detalle
   * en funcion de los valores recogidos desde el maestro
   *
   * @param presenter implementando la interfaz necesaria para recoger el estado a pasar al detalle
   */
  @Override
  public void goToDetailScreen(Master.MasterToDetail presenter) {
    masterToDetailState = new DetailState();
    masterToDetailState.hideToolbar = !presenter.getToolbarVisibility();
    masterToDetailState.selectedItem = presenter.getSelectedItem();

    // Arrancamos la pantalla del detalle sin finalizar la del maestro
    Context view = presenter.getManagedContext();
    if (view != null) {
      view.startActivity(new Intent(view, DetailView.class));
    }

  }

  /**
   * LLamado por el detalle al finalizar para volver al maestro fijando su nuevo estado
   * si es que este ha cambiado
   *
   * @param presenter implementando la interfaz necesaria para recoger el estado a pasar al maestro
   */
  @Override
  public void backToMasterScreen(Detail.DetailToMaster presenter){
    detailToMasterState = new ListState();
    detailToMasterState.itemToDelete = presenter.getItemToDelete();

    // Al volver al maestro, el detalle debe finalizar
    presenter.destroyView();
  }

  /////////////////////////////////////////////////////////////////////////////////////

  ///////////////////////////////////////////////////////////////////////////////////
  // Mediator //////////////////////////////////////////////////////////////////////

  /**
   * Llamado cuando arranca la app para fijar el estado inicial del maestro
   *
   * @param presenter implementando la interfaz necesaria para fijar el estado inicial
   */
  @Override
  public void startingMasterScreen(Master.ToMaster presenter){
    if(toMasterState != null) {
      presenter.setToolbarVisibility(!toMasterState.hideToolbar);
      presenter.setDatabaseValidity(toMasterState.validDatabase);
    }

    // Una vez fijado el estado inicial, el maestro puede iniciarse normalmente
    presenter.onScreenStarted();
  }


  /**
   * Llamado por el maestro cada vez que se reinicie, ya sea por un giro de pantalla o
   * porque el detalle a finalizado
   *
   * @param presenter implementando la interfaz necesaria para actualizar el estado del maestro
   */
  @Override
  public void resumingMasterScreen(Master.DetailToMaster presenter) {

    if(detailToMasterState != null) {
      presenter.setItemToDelete(detailToMasterState.itemToDelete);
    }

    // Una vez fijado el estado inicial, el maestro puede continuar normalmente
    detailToMasterState = null;
    presenter.onScreenResumed();


  }

  /**
   * Llamado cuando arranca el detalle para fijar su estado inicial
   *
   * @param presenter implementando la interfaz necesaria para fijar su estado inicial
   *  en funcion de los valores pasado desde el maestro
   */
  @Override
  public void startingDetailScreen(Detail.MasterToDetail presenter){
    if(masterToDetailState != null) {
      presenter.setToolbarVisibility(!masterToDetailState.hideToolbar);
      presenter.setItem(masterToDetailState.selectedItem);
    }

    // Una vez fijado el estado inicial, el detalle puede iniciarse normalmente
    masterToDetailState = null;
    presenter.onScreenStarted();
  }


  /////////////////////////////////////////////////////////////////////////////////////

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
  /**
   * Estado inicial del maestro
   */
  private class MasterState {
    boolean hideToolbar;
    boolean validDatabase;
  }

  /**
   * Estado a actualizar en el maestro en función de la ejecución del detalle
   */
  private class ListState {
    ModelItem itemToDelete;
  }

  /**
   * Estado inicial del detalle pasado por el maestro
   */
  private class DetailState {
    boolean hideToolbar;
    ModelItem selectedItem;
  }


}
