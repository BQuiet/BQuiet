package com.bquiet.bquiet.manager;

import android.media.MediaRecorder;
import android.os.AsyncTask;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;

import java.io.IOException;

public class RecorderManager {
    private MediaRecorder mRecorder;

    public boolean isListening() {
        return listening;
    }

    public void setListening(boolean listening) {
        this.listening = listening;
    }

    private boolean listening;

    public void start() {
        if (mRecorder == null) {
            mRecorder = new MediaRecorder();
            mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

            mRecorder.setOutputFile("/dev/null");

            try {
                mRecorder.prepare();
            } catch (IllegalStateException e) {
                Log.e("error", "IllegalStateException");
            } catch (IOException e) {
                Log.e("error", "IOException");
            }

            mRecorder.start();
        }
    }

    public void stop() {
        if (mRecorder != null) {
            mRecorder.stop();
            mRecorder.release();
            mRecorder = null;
        }
    }

    public double getAmplitude() {
        if (mRecorder != null)
            return (mRecorder.getMaxAmplitude());
        else
            return 0;
    }


    public class Ear extends AsyncTask<Void, Double, Void> {

        public void onPreExecute() {
            start();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            while(listening) {
                SystemClock.sleep(300);
                if(Looper.myLooper() == Looper.getMainLooper()){
                    System.exit(0);
                }
                Double amplitude = 20 * Math.log10(getAmplitude() / 32768.0);
                double newAmplitude = 90+ amplitude;
                publishProgress( amplitude, newAmplitude );
            }
            return null;
        }


        @Override
        protected void onProgressUpdate(Double... values) {

            Log.d("amplitude", "" + values[0] + " --- " + values[1]);

        }

        @Override
        protected void onPostExecute(Void result) {
            stop();
        }

    }
}
