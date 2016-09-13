package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class TellJoke extends TellJokeBase {
    private final InterstitialAd mInterstitialAd;

    public TellJoke(Context context, ProgressBar progressBar) {
        super(context, progressBar);

        mInterstitialAd = new InterstitialAd(context);
        mInterstitialAd.setAdUnitId(context.getString(R.string.interstitial_ad_unit_id));

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                displayJoke();
            }
        });

        requestNewInterstitial();
    }

    @Override
    protected boolean prepareDisplayJoke() {
        if(mInterstitialAd.isLoaded()){
            mInterstitialAd.show();
            return false;
        }
        return true;
    }

    private void requestNewInterstitial(){

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        mInterstitialAd.loadAd(adRequest);
    }
}
