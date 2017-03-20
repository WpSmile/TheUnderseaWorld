package com.qifeng.theunderseaworld.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.utils.MFGT;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimalKePuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_ke_pu);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.kepu_img_back)
    public void onClick() {
        MFGT.finish(this);
    }
}
