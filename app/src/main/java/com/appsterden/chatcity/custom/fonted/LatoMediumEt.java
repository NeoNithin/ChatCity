package com.appsterden.chatcity.custom.fonted;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

public class LatoMediumEt extends EditText {
    public LatoMediumEt(Context context) {
        super(context);
        init();
    }

    public LatoMediumEt(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LatoMediumEt(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Lato-Medium.ttf");
        setTypeface(tf);
    }
}