package es.ulpgc.eite.clean.mvp.sample.master;

import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.sample.app.ModelItem;

public class MasterModel extends GenericModel<Master.ModelToPresenter> implements Master.PresenterToModel {
    @Override
    public void deleteItem(ModelItem item) {

    }

    @Override
    public void loadItems() {

    }

    @Override
    public void reloadItems() {

    }

    @Override
    public String getErrorMessage() {
        return null;
    }
}