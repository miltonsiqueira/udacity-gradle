package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.widget.ProgressBar;

public class TellJoke extends TellJokeBase {

    public TellJoke(Context context, ProgressBar progressBar) {
        super(context, progressBar);
    }

    @Override
    protected boolean prepareDisplayJoke() {
        return true;
    }
}
