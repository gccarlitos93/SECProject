package es.ulpgc.eite.clean.mvp.sample.main;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;

public class MainView
        extends GenericActivity<Main.PresenterToView, Main.ViewToPresenter, MainPresenter>
        implements Main.PresenterToView {

    private Button intoButton;
    private TextView title;
    private TextView startTxt;
    private ImageView image;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        title = (TextView)findViewById(R.id.mainTitle);
        image = (ImageView)findViewById(R.id.mainImage);
        startTxt = (TextView)findViewById(R.id.mainText);
        intoButton = (Button)findViewById(R.id.intoButton);
        intoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().onIntoBtnClicked();
            }
        });

    }

    /**
     * Method that initialized MVP objects
     * {@link super#onResume(Class, Object)} should always be called
     */
    @SuppressLint("MissingSuperCall")
    @Override
    protected void onResume() {
        super.onResume(MainPresenter.class, this);
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
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setIntoBtnLabel(String txt){
        intoButton.setText(txt);
    }

    @Override
    public void setStartTxt(String txt){
        startTxt.setText(txt);
    }

    @Override
    public void setTitleTxt(String txt){
        title.setText(txt);
    }
}
