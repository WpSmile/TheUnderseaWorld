package com.qifeng.theunderseaworld.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qifeng.theunderseaworld.R;
import com.qifeng.theunderseaworld.activity.MainActivity;
import com.qifeng.theunderseaworld.utils.MFGT;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment extends Fragment {
    MainActivity mContext;

    public HomePageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        ButterKnife.bind(this, view);
        mContext = (MainActivity) getActivity();
        return view;
    }


    @OnClick({R.id.home_introduce_iamge, R.id.home_map_iamge, R.id.home_activity_iamge, R.id.home_text_more1, R.id.home_text_more2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_introduce_iamge:
                MFGT.gotoIntroduceActivity(mContext);
                break;
            case R.id.home_map_iamge:
                MFGT.gotoMapActivity(mContext);
                break;
            case R.id.home_activity_iamge:
                MFGT.gotoTodayActivity(mContext);
                break;
            case R.id.home_text_more1:
                MFGT.gotoAnimalKePuActivity(mContext);
                break;
            case R.id.home_text_more2:
                MFGT.gotoHotRecommondActivity(mContext);
                break;
        }
    }
}
