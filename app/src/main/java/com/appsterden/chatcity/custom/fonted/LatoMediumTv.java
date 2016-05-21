package com.appsterden.chatcity.custom.fonted;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class LatoMediumTv extends TextView {
    public LatoMediumTv(Context context) {
        super(context);
    }

    public LatoMediumTv(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LatoMediumTv(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Lato-Medium.ttf");
        setTypeface(tf);
    }
}