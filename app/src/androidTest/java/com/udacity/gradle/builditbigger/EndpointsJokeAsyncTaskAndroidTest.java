package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import com.titomilton.jokelib.JokeUtils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class EndpointsJokeAsyncTaskAndroidTest extends AndroidTestCase{

    public void testJokeIsValid() throws InterruptedException {
        assertEquals(new JokeUtils().getJoke(), getJoke());
    }

    public void testJokeIsNotEmpty() throws InterruptedException {
        assertNotSame("", getJoke());
    }

    private String getJoke() throws InterruptedException {
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

        signal.await(10, TimeUnit.SECONDS);
        return joke[0];
    }
}
