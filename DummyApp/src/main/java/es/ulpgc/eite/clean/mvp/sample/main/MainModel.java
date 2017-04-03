package es.ulpgc.eite.clean.mvp.sample.main;


import es.ulpgc.eite.clean.mvp.GenericModel;

public class MainModel extends GenericModel<Main.ModelToPresenter> implements Main.PresenterToModel {

    private String searchBtnLabel, mainText, title;


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
        mainText = "Sport Events Canary. Encuentra los eventos de tus deportes favoritos con un par de " +
                   "clicks. Recibe toda la información que necesitas sobre ese partido al que quieres asistir o esa " +
                   "carrera que tanto te gusta participar. Accede a los enlaces para inscribirte o compar las entradas.";
        title = "SEC";
    }

    @Override
    public void onDestroy(boolean isChangingConfiguration){

    }


    @Override
    public String getSearchBtnLabel(){
        return searchBtnLabel;
    }
    @Override
    public String getMainText(){
        return mainText;
    }
    @Override
    public String getTitleText(){
        return title;
    }

}
