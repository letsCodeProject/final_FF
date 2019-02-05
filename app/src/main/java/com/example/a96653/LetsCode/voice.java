package com.example.a96653.LetsCode;

import android.media.MediaPlayer;

public class voice {
    public MediaPlayer myVoice;

    public voice(MediaPlayer myVoice){
        this.myVoice=myVoice;
    }

    public void play(){
        myVoice.start();

    }

    public void pause(){

        myVoice.release();
    }

    public void stop(){

        myVoice.stop();
    }


}
