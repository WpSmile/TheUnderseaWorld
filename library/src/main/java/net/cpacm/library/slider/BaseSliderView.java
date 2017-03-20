package net.cpacm.library.slider;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;



/**
 * When you want to make your own slider view, you must extends from this class.
 * BaseSliderView provides some useful methods.
 * if you want to show progressbar, you just need to set a progressbar id as @+id/loading_bar.
 */
public abstract class BaseSliderView {

    protected Context mContext;
    private Bundle mBundle;
    protected OnSliderClickListener mOnSliderClickListener;
    private View sliderView;
    private ViewGroup containerView;
    private String pageTitle;

    protected BaseSliderView(Context context) {
        mContext = context;
        sliderView = getSliderView();
    }

    /**
     * lets users add a bundle of additional information
     *
     * @param bundle
     * @return
     */
    public BaseSliderView bundle(Bundle bundle) {
        mBundle = bundle;
        return this;
    }

    public Context getContext() {
        return mContext;
    }

    /**
     * set a slider image click listener
     *
     * @param l
     * @return
     */
    public BaseSliderView setOnSliderClickListener(OnSliderClickListener l) {
        mOnSliderClickListener = l;
        return this;
    }

    /**
     * bind slider to pager in {@link BaseSliderView#getView}
     *
     * @param v the whole view
     */
    protected void bindSliderToPager(View v) {
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnSliderClickListener != null) {
                    mOnSliderClickListener.onSliderClick(BaseSliderView.this);
                }
            }
        });
    }

    /**
     * the extended class have to implement getView(), which is called by the adapter,
     * every extended class response to render their own view.
     *
     * @return
     */
    public abstract View getSliderView();

    public View getView() {
        if (sliderView == null) {
            sliderView = getSliderView();
        }
        return sliderView;
    }

    @Deprecated
    private View getWapperView() {
        if (sliderView == null) {
            sliderView = getSliderView();
        }
        if (containerView == null) {
            containerView = new FrameLayout(mContext);
            containerView.addView(sliderView);
        } else {
            containerView.removeAllViews();
            containerView = new FrameLayout(mContext);
            containerView.addView(sliderView);
        }
        return containerView;
    }

    /**
     * when you have some extra information, please put it in this bundle.
     *
     * @return
     */
    public Bundle getBundle() {
        return mBundle;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }
}
