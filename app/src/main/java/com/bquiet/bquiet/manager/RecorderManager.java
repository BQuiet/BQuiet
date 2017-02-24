package com.bquiet.bquiet.manager;

import android.media.MediaRecorder;
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
}
