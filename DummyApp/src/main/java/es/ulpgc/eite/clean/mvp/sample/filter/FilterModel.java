package es.ulpgc.eite.clean.mvp.sample.filter;

import es.ulpgc.eite.clean.mvp.GenericModel;

/**
 * Created by Carlitos93 on 03/04/2017.
 */
public class FilterModel extends GenericModel<Filter.ModelToPresenter>
        implements Filter.PresenterToModel {

    private String filterText, islandLabel, sportLabel;


    /**
     * Method that recovers a reference to the PRESENTER
     * You must ALWAYS call {@link super#onCreate(Object)} here
     *
     * @param presenter Presenter interface
     */
    @Override
    public void onCreate(Filter.ModelToPresenter presenter) {
        super.onCreate(presenter);

        filterText = "Ya solo te queda decirnos en que isla buscas los eventos y con que deporte está relacionado.";
        islandLabel = "Isla";
        sportLabel = "Deporte";


    }

    /**
     * Called by layer PRESENTER when VIEW pass for a reconstruction/destruction.
     * Usefull for kill/stop activities that could be running on the background Threads
     *
     * @param isChangingConfiguration Informs that a change is occurring on the configuration
     */
    @Override
    public void onDestroy(boolean isChangingConfiguration) {

    }

    ///////////////////////////////////////////////////////////////////////////////////
    // Presenter To Model ////////////////////////////////////////////////////////////


    @Override
    public String getFilterText(){
        return filterText;
    }
    @Override
    public String getIslandLabel(){
        return islandLabel;
    }
    @Override
    public String getSportLabel(){
        return sportLabel;
    }



    /////////////////////////////////////////////////////////



}
