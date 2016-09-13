package com.udacity.gradle.builditbigger;

import android.content.Context;

public class TellJoke extends TellJokeBase {
    public TellJoke(Context context) {
        super(context);
    }

    @Override
    protected boolean prepareDisplayJoke() {
        return true;
    }
}
