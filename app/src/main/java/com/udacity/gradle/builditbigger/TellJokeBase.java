package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ProgressBar;

import com.titomilton.jokedisplay.JokeDisplay;

public abstract class TellJokeBase {
    private final Context context;
    private final ProgressBar progressBar;

    private String joke = "";
    public TellJokeBase(Context context, ProgressBar progressBar) {
        this.context = context;
        this.progressBar = progressBar;
    }

    public final void tellJoke(){
        progressBar.setVisibility(View.VISIBLE);
        new EndpointsJokeAsyncTask(){
            @Override
            protected void onPostExecute(String result) {
                joke = result;
                progressBar.setVisibility(View.GONE);
                if(prepareDisplayJoke()){
                    displayJoke();
                }
            }
        }.execute();



    }

    protected void displayJoke(){
        Intent intent = new Intent(context, JokeDisplay.class);
        intent.putExtra("joke", joke);
        context.startActivity(intent);

    }

    protected abstract boolean prepareDisplayJoke();
}
