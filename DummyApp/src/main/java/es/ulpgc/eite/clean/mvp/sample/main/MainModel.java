package es.ulpgc.eite.clean.mvp.sample.main;


import es.ulpgc.eite.clean.mvp.GenericModel;

public class MainModel extends GenericModel<Main.ModelToPresenter> implements Main.PresenterToModel {

    private String searchBtnLabel;

    /**
     * Method that recovers a reference to the PRESENTER
     * You must ALWAYS call {@link super#onCreate(Object)} here
     *
     * @param presenter Presenter interface
     */
    @Override
    public void onCreate(Main.ModelToPresenter presenter){
        super.onCreate(presenter);

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
