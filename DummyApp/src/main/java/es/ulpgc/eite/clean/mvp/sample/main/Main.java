package es.ulpgc.eite.clean.mvp.sample.main;

import android.content.Context;

import es.ulpgc.eite.clean.mvp.ContextView;
import es.ulpgc.eite.clean.mvp.Model;
import es.ulpgc.eite.clean.mvp.Presenter;

public interface Main {

    ///////////////////////////////////////////////////////////////////////////////////
    // State /////////////////////////////////////////////////////////////////////////

    interface MainToFilter {

        boolean isToolbarVisible();
        Context getManagedContext();

        //boolean isTextVisible();
        boolean isButtonClicked();
        //String getMessage();

    }

    interface ToMain {
        void onScreenStarted();
        void setToolbarVisibility(boolean visible);
        void setTextVisibility(boolean visible);
    }


    ///////////////////////////////////////////////////////////////////////////////////
    // Screen ////////////////////////////////////////////////////////////////////////

    /**
     * Methods offered to VIEW to communicate with PRESENTER
     */
    interface ViewToPresenter extends Presenter<PresenterToView> {

        void onIntoBtnClicked();
        //void onStartingView();
    }

    /**
     * Required VIEW methods available to PRESENTER
     */
    interface PresenterToView extends ContextView {
        void finishScreen();
        void hideToolbar();
        void showProgress();
        void hideProgress();
        void setIntoBtnLabel(String txt);
        void setStartTxt(String txt);
        void setTitleTxt(String txt);
    }

    /**
     * Methods offered to MODEL to communicate with PRESENTER
     */
    interface PresenterToModel extends Model<ModelToPresenter> {

        String getIntoBtnLabel();
        String getMainText();
        String getTitleText();
    }

    /**
     * Required PRESENTER methods available to MODEL
     */
    interface ModelToPresenter {

    }
}
