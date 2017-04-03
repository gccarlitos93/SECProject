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
    private TextView filterIsland, filterSport;
    private Spinner islandChoice, sportChoice;
    private FloatingActionButton search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        //byeMsgView = (TextView) findViewById(R.id.byeMsg);
        //progressView = (ProgressBar) findViewById(R.id.progressBar);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //btnSayByeView = (Button) findViewById(R.id.btnSayBye);
        //btnSayByeView.setOnClickListener(new View.OnClickListener() {
           /* @Override
            public void onClick(View view) {
                getPresenter().onSayByeBtnClicked();
            }
        });*/

        /*btnGoToHelloView = (Button) findViewById(R.id.btnGoToHello);
        btnGoToHelloView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().onGoToHelloBtnClicked();
            }
        });*/

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


    /*@Override
    public void hideByeMsg() {
        byeMsgView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showByeMsg() {
        byeMsgView.setVisibility(View.VISIBLE);
    }

    public void setByeMsg(String txt) {
        byeMsgView.setText(txt);
    }

    @Override
    public void setSayByeBtnLabel(String txt) {
        btnSayByeView.setText(txt);
    }

    @Override
    public void setGoToHelloBtnLabel(String txt) {
        btnGoToHelloView.setText(txt);
    }

    @Override
    public void showProgress() {
        progressView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressView.setVisibility(View.INVISIBLE);
    }
}*/
}
