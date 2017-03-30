package es.ulpgc.eite.clean.mvp.sample.main;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;

public class MainView extends GenericActivity<Main.PresenterToView, Main.ViewToPresenter, MainPresenter>
        implements Main.PresenterToView {

    private Button search;
    private TextView mainText;
    private ImageView image;
    private Spinner sports;
    private Toolbar toolbar;

    @SuppressLint("MissingSuperCall")
    @Override

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = (ImageView)findViewById(R.id.mainImage);
        search = (Button)findViewById(R.id.searchButton);
        mainText = (TextView)findViewById(R.id.mainText);
        sports = (Spinner)findViewById(R.id.spinner);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }


    @Override
    public void finishScreen() {
        finish();
    }

    @Override
    public void hideToolbar() {
        toolbar.setVisibility(View.GONE);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setSearchBtnLabel(String txt){
        search.setText(txt);
    }
}
