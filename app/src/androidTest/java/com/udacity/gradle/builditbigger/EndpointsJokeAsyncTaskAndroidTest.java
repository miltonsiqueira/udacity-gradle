package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import com.titomilton.jokelib.JokeUtils;

import java.util.concurrent.CountDownLatch;

public class EndpointsJokeAsyncTaskAndroidTest extends AndroidTestCase{

    public void testJokeIsValid() throws InterruptedException {
        final String[] joke = {""};
        final CountDownLatch signal = new CountDownLatch(1);

        new EndpointsJokeAsyncTask(){
            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                joke[0] = result;
                signal.countDown();
            }
        }.execute();

        signal.await();

        assertEquals(new JokeUtils().getJoke(), joke[0]);
    }

}