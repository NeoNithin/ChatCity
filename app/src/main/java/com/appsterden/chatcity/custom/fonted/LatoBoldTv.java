package com.appsterden.chatcity.custom.fonted;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class LatoBoldTv extends TextView {
    public LatoBoldTv(Context context) {
        super(context);
    }

    public LatoBoldTv(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LatoBoldTv(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Lato-Bold.ttf");
        setTypeface(tf);
    }
}