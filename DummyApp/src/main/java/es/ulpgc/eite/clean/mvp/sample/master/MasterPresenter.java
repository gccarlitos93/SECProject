package es.ulpgc.eite.clean.mvp.sample.master;



import android.content.Context;

import java.util.List;

import es.ulpgc.eite.clean.mvp.GenericPresenter;
import es.ulpgc.eite.clean.mvp.sample.app.ModelItem;

public class MasterPresenter extends GenericPresenter<Master.PresenterToView, Master.PresenterToModel, Master.ModelToPresenter, MasterModel>
        implements Master.ViewToPresenter, Master.ModelToPresenter,
        Master.MasterToDetail, Master.DetailToMaster  {


    @Override
    public void onScreenResumed() {

    }

    @Override
    public void setItemToDelete(ModelItem item) {

    }

    @Override
    public Context getManagedContext() {
        return null;
    }

    @Override
    public ModelItem getSelectedItem() {
        return null;
    }

    @Override
    public boolean getToolbarVisibility() {
        return false;
    }

    @Override
    public void onErrorDeletingItem(ModelItem item) {

    }

    @Override
    public void onLoadItemsTaskFinished(List<ModelItem> items) {

    }

    @Override
    public void onLoadItemsTaskStarted() {

    }

    @Override
    public void onItemClicked(ModelItem item) {

    }

    @Override
    public void onRestoreActionClicked() {

    }

    @Override
    public void onResumingContent() {

    }

    @Override
    public void onCreate(Master.PresenterToView presenterToView) {

    }

    @Override
    public void onResume(Master.PresenterToView presenterToView) {

    }

    @Override
    public void onBackPressed() {

    }
}
