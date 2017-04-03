package es.ulpgc.eite.clean.mvp.sample.filter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;

/**
 * Created by Carlitos93 on 03/04/2017.
 */
public class FilterView extends GenericActivity<Filter.PresenterToView, Filter.ViewToPresenter, FilterPresenter>
        implements Filter.PresenterToView {

    private Toolbar toolbar;
    private TextView filterIsland, filterSport, filterText;
    private Spinner islandChoice, sportChoice;
    private FloatingActionButton search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        filterText = (TextView)findViewById(R.id.filterText);

        filterIsland = (TextView)findViewById(R.id.islandLabel);
        islandChoice = (Spinner)findViewById(R.id.islandSpinner);

        filterSport = (TextView)findViewById(R.id.sportLabel);
        sportChoice = (Spinner)findViewById(R.id.sportSpinner);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    /**
     * Method that initialized MVP objects
     * {@link super#onResume(Class, Object)} should always be called
     */
    @SuppressLint("MissingSuperCall")
    @Override
    protected void onResume() {
        super.onResume(FilterPresenter.class, this);
    }


    ///////////////////////////////////////////////////////////////////////////////////
    // Presenter To View /////////////////////////////////////////////////////////////

    @Override
    public void finishScreen() {
        finish();
    }

    @Override
    public void hideToolbar() {
        toolbar.setVisibility(View.GONE);
    }

    @Override
    public void setFilterText(String txt){
        filterText.setText(txt);
    }
    @Override
    public void setIslandLabel(String txt){
        filterIsland.setText(txt);
    }
    @Override
    public void setSportLabel(String txt){
        filterSport.setText(txt);
    }
}
