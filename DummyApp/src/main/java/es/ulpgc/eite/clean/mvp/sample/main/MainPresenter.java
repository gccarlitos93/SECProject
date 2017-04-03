package es.ulpgc.eite.clean.mvp.sample.main;


import android.content.Context;
import android.util.Log;

import es.ulpgc.eite.clean.mvp.ContextView;
import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.GenericPresenter;
import es.ulpgc.eite.clean.mvp.sample.app.Mediator;
import es.ulpgc.eite.clean.mvp.sample.app.Navigator;

//Extender e implementar
public class MainPresenter extends GenericPresenter<Main.PresenterToView, Main.PresenterToModel, Main.ModelToPresenter, MainModel>
        implements Main.ViewToPresenter, Main.ModelToPresenter,  Main.ToMain, Main.MainToFilter {

    private boolean toolbarVisible;
    private boolean buttonClicked;

    /**
     * Operation called during VIEW creation in {@link GenericActivity#onResume(Class, Object)}
     * Responsible to initialize MODEL.
     * Always call {@link GenericPresenter#onCreate(Class, Object)} to initialize the object
     * Always call  {@link GenericPresenter#setView(ContextView)} to save a PresenterToView reference
     *
     * @param view The current VIEW instance
     */
    @Override
    public void onCreate(Main.PresenterToView view) {

        super.onCreate(MainModel.class, this);
        setView(view);
        Log.d(TAG, "calling onCreate()");

        Log.d(TAG, "calling startingMainScreen()");
        Mediator app = (Mediator) getView().getApplication();
        app.startingMainScreen(this);
    }

    /**
     * Operation called by VIEW after its reconstruction.
     * Always call {@link GenericPresenter#setView(ContextView)}
     * to save the new instance of PresenterToView
     *
     * @param view The current VIEW instance
     */
    @Override
    public void onResume(Main.PresenterToView view) {

        setView(view);
        Log.d(TAG, "calling onResume()");
        if(configurationChangeOccurred()) { // giro pantalla
            onScreenStarted();
        }else{
            //segundo plano
        }
    }

    /**
     * Helper method to inform Presenter that a onBackPressed event occurred
     * Called by {@link GenericActivity}
     */
    @Override
    public void onBackPressed() {

        Log.d(TAG, "calling onBackPressed()");
    }

    /**
     * Hook method called when the VIEW is being destroyed or
     * having its configuration changed.
     * Responsible to maintain MVP synchronized with Activity lifecycle.
     * Called by onDestroy methods of the VIEW layer, like: {@link GenericActivity#onDestroy()}
     *
     * @param isChangingConfiguration true: configuration changing & false: being destroyed
     */
    @Override
    public void onDestroy(boolean isChangingConfiguration){
        super.onDestroy(isChangingConfiguration);
        Log.d(TAG, "calling onDestroy()");
    }

    ///////////////////////////////////////////////////////////////////////////////////
    // View To Presenter /////////////////////////////////////////////////////////////

    @Override
    public void onSearchBtnClicked() {
        Navigator app = (Navigator) getView().getApplication();
        app.goToFilterScreen(this);
    }

    ///////////////////////////////////////////////////////////////////////////////////
    // Model To Presenter ////////////////////////////////////////////////////////////


    ///////////////////////////////////////////////////////////////////////////////////
    // ToFilter //////////////////////////////////////////////////////////////////////

    @Override
    public void onScreenStarted() {

        Log.d(TAG, "calling onScreenStarted()");

        if(isViewRunning()){
            getView().setSearchBtnLabel(getModel().getSearchBtnLabel());
            getView().setStartTxt(getModel().getMainText());
            getView().setTitleTxt(getModel().getTitleText());


        }
        checkToolbarVisibility();
    }

    @Override
    public void setToolbarVisibility(boolean visible) {
        toolbarVisible = visible;
    }

    @Override
    public void setTextVisibility(boolean visible) {

    }

    ///////////////////////////////////////////////////////////////////////////////////
    // Bye To Bye //////////////////////////////////////////////////////////////////

    @Override
    public boolean isToolbarVisible() {
        return toolbarVisible;
    }

    @Override
    public Context getManagedContext(){
        return getActivityContext();
    }

  /*


  @Override
  public void destroyView(){
    if(isViewRunning()) {
      getView().finishScreen();
    }
  }

  @Override
  public boolean isTextVisible() {
    return textVisible;
  }
  */

    ///////////////////////////////////////////////////////////////////////////////////


    /*@Override
    public boolean isTextVisible() {
        return textVisible;
    }*/

    @Override
    public boolean isButtonClicked() {
        return buttonClicked;
    }

   /* @Override
    public String getMessage() {
        return msg; // can be null
    }*/

    private void setButtonClicked(boolean clicked) {
        this.buttonClicked = clicked;
    }

  /*
  private void checkHelloMsg(){
    getView().showByeMsg();
    getView().setByeMsg(getModel().getHelloMsg());
  }
  */
    private void checkToolbarVisibility(){
        Log.d(TAG, "calling checkToolbarVisibility()");
        if(isViewRunning()) {
            if (!toolbarVisible) {
                getView().hideToolbar();
            }
        }

    }

    /*private void checkTextVisibility(){
        Log.d(TAG, "calling checkTextVisibility()");
        if(isViewRunning()) {
            if(!textVisible) {
                getView().hideHelloMsg();
            } else {
                getView().showHelloMsg();
            }
        }
    }*/
}
