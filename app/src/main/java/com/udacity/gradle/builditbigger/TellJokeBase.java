package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;

import com.titomilton.jokedisplay.JokeDisplay;

public abstract class TellJokeBase {
    private final Context context;
    private String joke = "";
    public TellJokeBase(Context context) {
        this.context = context;
    }

    public final void tellJoke(){
        new EndpointsJokeAsyncTask(){
            @Override
            protected void onPostExecute(String result) {
                joke = result;
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
