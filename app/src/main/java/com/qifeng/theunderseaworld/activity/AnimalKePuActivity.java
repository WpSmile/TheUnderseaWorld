package com.qifeng.theunderseaworld.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.TextView;

import com.qifeng.theunderseaworld.I;
import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.bean.AnimalDetailsBean;
import com.qifeng.theunderseaworld.utils.L;
import com.qifeng.theunderseaworld.utils.MFGT;
import com.qifeng.theunderseaworld.utils.OkUtils;
import com.qifeng.theunderseaworld.utils.StatusBarCompat;
import com.qifeng.theunderseaworld.view.FlowIndicator;
import com.qifeng.theunderseaworld.view.SlideAutoLoopView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimalKePuActivity extends AppCompatActivity {
    private final static String TAG = AnimalKePuActivity.class.getCanonicalName();
    AnimalKePuActivity mContext;

    FlowIndicator flowIndicator;

    int animalid;
    @BindView(R.id.kepu_slideAuto)
    SlideAutoLoopView slideAutoLoopView;
    @BindView(R.id.animal_text_intro)
    TextView animalTextIntro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //API19以下用于沉侵式菜单栏
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_animal_ke_pu);
        //API20以上
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            //沉侵
            StatusBarCompat.compat(this, getResources().getColor(R.color.bottom_blue));
        }
        ButterKnife.bind(this);

        mContext = this;
        animalid = getIntent().getIntExtra("id", 0);
        L.e(TAG, animalid + "");

        initView();
        initData();
    }

    private void initData() {
        downloadAnimalDetails();
    }

    private void downloadAnimalDetails() {
        OkUtils<AnimalDetailsBean> utils = new OkUtils<>(mContext);
        utils.url(I.SERVER_URL + "ScienceDetails" + I.INDEX)
                .addParam("science_id", animalid + "")
                .targetClass(AnimalDetailsBean.class)
                .post()
                .execute(new OkUtils.OnCompleteListener<AnimalDetailsBean>() {
                    @Override
                    public void onSuccess(AnimalDetailsBean result) {
                        if (result != null) {
                            showAnimalDetails(result);
                        }
                    }

                    @Override
                    public void onError(String error) {

                    }
                });
    }

    private void showAnimalDetails(AnimalDetailsBean details) {
        animalTextIntro.setText(details.getAnimalIntro());
        slideAutoLoopView.startPlayLoop(flowIndicator, getAlbumImgUrl(details), getAlbumImgCount(details));
    }

    private int getAlbumImgCount(AnimalDetailsBean details) {
        /*if (details.getProperties() != null && details.getProperties().length > 0) {
            return details.getProperties()[0].getAlbums().length;
        }*/
        return 0;
    }

    private String[] getAlbumImgUrl(AnimalDetailsBean details) {
        String[] url = new String[]{};
        /*if (details.getProperties() != null && details.getProperties().length > 0) {
            AlbumsBean[] albums = details.getProperties()[0].getAlbums();
            url = new String[albums.length];
            for (int i = 0; i < albums.length; i++) {
                url[i] = albums[i].getImgUrl();
            }
        }*/
        return url;

    }

    private void initView() {
        flowIndicator = (FlowIndicator) findViewById(R.id.kepu_flowIndicator);
    }

    @OnClick(R.id.kepu_img_back)
    public void onClick() {
        MFGT.finish(this);
    }
}
