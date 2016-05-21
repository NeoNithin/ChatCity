package com.appsterden.chatcity.custom.fonted;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class LatoRegularTv extends TextView {
    public LatoRegularTv(Context context) {
        super(context);
    }

    public LatoRegularTv(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LatoRegularTv(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Lato-Regular.ttf");
        setTypeface(tf);
    }
}
