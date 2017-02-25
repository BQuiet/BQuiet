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
    public interface EarListener{
        void newValueFromEar(double spl);
    }

    public class Ear extends AsyncTask<Void, Double, Void> {
        private double spl;
        private EarListener listener;


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
<<<<<<< HEAD
                double newAmplitude = 90+ amplitude;
=======
                double newAmplitude = 100 + amplitude;
>>>>>>> feature/add_speed_do_metter
                publishProgress( amplitude, newAmplitude );
            }
            return null;
        }


        @Override
        protected void onProgressUpdate(Double... values) {

<<<<<<< HEAD
            Log.d("amplitude", "" + values[0] + " --- " + values[1]);

=======
            Log.d("amplitude", "" + values[1]); // + "-" + newAmplitude);
            if (listener!=null){
                listener.newValueFromEar(values[1]);
            }
>>>>>>> feature/add_speed_do_metter
        }

        @Override
        protected void onPostExecute(Void result) {
            stop();
        }

        public double getSpl() {
            return spl;
        }

        public void setSpl(double spl) {
            this.spl = spl;
        }

        public void setOnEarListener(EarListener earListener){
            this.listener=earListener;
        }
    }


}
