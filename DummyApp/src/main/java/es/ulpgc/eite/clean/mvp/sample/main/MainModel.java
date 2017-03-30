package es.ulpgc.eite.clean.mvp.sample.main;


import es.ulpgc.eite.clean.mvp.GenericModel;

public class MainModel extends GenericModel<Main.ModelToPresenter> implements Main.PresenterToModel {

    private String searchBtnLabel;

    @Override
    public void onCreate(Main.ModelToPresenter presenter){

        searchBtnLabel = "Buscar";
    }

    @Override
    public void onDestroy(boolean isChangingConfiguration){

    }


    @Override
    public String getSearchBtnLabel(){
        return searchBtnLabel;
    }

}
