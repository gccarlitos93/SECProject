package es.ulpgc.eite.clean.mvp.sample.filter;

import android.content.Context;
import android.util.Log;

import es.ulpgc.eite.clean.mvp.ContextView;
import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.GenericPresenter;
import es.ulpgc.eite.clean.mvp.sample.app.Mediator;
import es.ulpgc.eite.clean.mvp.sample.app.Navigator;

/**
 * Created by Carlitos93 on 03/04/2017.
 */
public class FilterPresenter extends GenericPresenter<Filter.PresenterToView, Filter.PresenterToModel, Filter.ModelToPresenter, FilterModel>
        implements Filter.ViewToPresenter, Filter.ModelToPresenter, Filter.MainToFilter, Filter.FilterToMain {


    private boolean toolbarVisible;
    private boolean buttonClicked;
    private boolean helloBtnClicked;
    private boolean textVisible;
    //private boolean helloTextVisible;
    //private String helloMsg;

    /**
     * Operation called during VIEW creation in {@link GenericActivity#onResume(Class, Object)}
     * Responsible to initialize MODEL.
     * Always call {@link GenericPresenter#onCreate(Class, Object)} to initialize the object
     * Always call  {@link GenericPresenter#setView(ContextView)} to save a PresenterToView reference
     *
     * @param view The current VIEW instance
     */

    @Override
    public void onCreate(Filter.PresenterToView view) {
        super.onCreate(FilterModel.class, this);
        setView(view);
        Log.d(TAG, "calling onCreate()");

        Log.d(TAG, "calling startingByeScreen()");
        Mediator app = (Mediator) getView().getApplication();
        app.startingFilterScreen(this);

    }

     /**
     * Operation called by VIEW after its reconstruction.
     * Always call {@link GenericPresenter#setView(ContextView)}
     * to save the new instance of PresenterToView
     *
     * @param view The current VIEW instance
     */
    @Override
    public void onResume(Filter.PresenterToView view) {
        setView(view);
        Log.d(TAG, "calling onResume()");

        if(configurationChangeOccurred()) { // giro pantalla
            onScreenStarted();
            /*if(isButtonClicked()){
                getModel().startByeGetMessageTask();
            }*/
        } else { // segundo a primer plano

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
    public void onDestroy(boolean isChangingConfiguration) {
        super.onDestroy(isChangingConfiguration);
        Log.d(TAG, "calling onDestroy()");
    }


    ///////////////////////////////////////////////////////////////////////////////////
    // View To Presenter /////////////////////////////////////////////////////////////



    /*@Override
    public void onGoToHelloBtnClicked() {
        Navigator app = (Navigator) getView().getApplication();
        app.goToHelloScreen(this);
    }*/


    ///////////////////////////////////////////////////////////////////////////////////
    // Model To Presenter ////////////////////////////////////////////////////////////


    /*@Override
    public void onByeGetMessageTaskFinished(String text) {
        if(isViewRunning()) {
            getView().setByeMsg(text);
        }

        setTextVisibility(true);
        checkTextVisibility();
        checkProgressVisibility();
    }*/


    ///////////////////////////////////////////////////////////////////////////////////
    // Hello To Bye //////////////////////////////////////////////////////////////////

    @Override
    public void onScreenStarted() {
        Log.d(TAG, "calling onScreenStarted()");

        if(isViewRunning()) {
            /*getView().setGoToHelloBtnLabel(getModel().getGoToHelloBtnLabel());
            getView().setSayByeBtnLabel(getModel().getSayByeBtnLabel());*/
        }

        //textVisible = helloTextVisible;

        checkToolbarVisibility();
        //checkProgressVisibility();
        checkTextVisibility();
    }

    @Override
    public void setToolbarVisibility(boolean visible) {
        toolbarVisible = visible;
    }

    @Override
    public void setTextVisibility(boolean visible) {
        textVisible = visible;
    }


    ///////////////////////////////////////////////////////////////////////////////////
    // Bye To Hello //////////////////////////////////////////////////////////////////

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
  */

    ///////////////////////////////////////////////////////////////////////////////////


    private boolean isTextVisible() {
        return textVisible;
    }

    private boolean isButtonClicked() {
        return buttonClicked;
    }

    @Override
    public void setButtonClicked(boolean clicked) {
        this.buttonClicked = clicked;
    }



   /* @Override
    public void setHelloTextVisibility(boolean visibility) {
        helloTextVisible = visibility;
    }

    @Override
    public void setHelloButtonClicked(boolean clicked) {
        helloBtnClicked = clicked;
    }*/

   /* @Override
    public void setHelloMessage(String msg) {
        helloMsg = msg;
    }

    private void checkProgressVisibility(){
        Log.d(TAG, "calling checkProgressVisibility()");
        if(isViewRunning()) {
      *//*
      if(helloBtnClicked && !helloTextVisible) {
        getView().showProgress();
      } else {
        getView().hideProgress();
      }
      *//*


            if (isButtonClicked() && !isTextVisible()) {
                getView().showProgress();
            } else {
                getView().hideProgress();
            }
        }

    }*/

    private void checkToolbarVisibility(){
        Log.d(TAG, "calling checkToolbarVisibility()");
        if(isViewRunning()) {
            if (!toolbarVisible) {
                getView().hideToolbar();
            }
        }

    }

    private void checkTextVisibility(){
        Log.d(TAG, "calling checkTextVisibility()");
        if(isViewRunning()) {
      /*
      if(helloTextVisible && textVisible) {

      }

      if(helloTextVisible && helloBtnClicked) {
        getView().setByeMsg(helloMsg);
        getView().showByeMsg();
      } else {
        getView().hideByeMsg();
      }
      */

           /* if(!textVisible) {
                getView().hideByeMsg();
            } else {
                getView().showByeMsg();
            }*/
        }
    }
}
