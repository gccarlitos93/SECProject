package es.ulpgc.eite.clean.mvp.sample.master;



import java.util.List;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.app.ModelItem;

public class MasterView  extends GenericActivity<Master.PresenterToView, Master.ViewToPresenter, MasterPresenter>
        implements Master.PresenterToView {

    @Override
    public void hideProgress() {

    }

    @Override
    public void hideToolbar() {

    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void setRecyclerAdapterContent(List<ModelItem> items) {

    }
}
