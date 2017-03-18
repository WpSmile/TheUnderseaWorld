package com.qifeng.theunderseaworld.activity;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by liu on 2017/3/18.
 */
public class SpaceItemDecoretion extends RecyclerView.ItemDecoration {
    private int space;

    public SpaceItemDecoretion(int space) {
        this.space = space;
    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.left = space;
        outRect.right = space;
        outRect.bottom = space;

        if (parent.getChildPosition(view) == 0)
            outRect.top = space;
    }
}
