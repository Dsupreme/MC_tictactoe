package com.example.basicgrid;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class SoundService extends Service {
	
	private static final String TAG = null;
    MediaPlayer player;
    public IBinder onBind(Intent arg0) {

        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();


        player = MediaPlayer.create(this, R.raw.sound1);
        player.setLooping(true); // Set looping
        player.setVolume(100,100);

    }
    public int onStartCommand(Intent intent, int flags, int startId) {


        player.start();

        return 1;
    }

    public void onStart(Intent intent, int startId) {
        // TODO



    }
    public IBinder onUnBind(Intent arg0) {
        // TODO Auto-generated method stub

        return null;
    }

    public void onStop() {

    }
    public void onPause() {

    }
    @Override
    public void onDestroy() {

        player.stop();
        player.release();
    }

    @Override
    public void onLowMemory() {

    }
}

/*
	
	@Override
	   public IBinder onBind(Intent arg0) {
	      return null;
	   }

	   @Override
	   public int onStartCommand(Intent intent, int flags, int startId) {
	      // Let it continue running until it is stopped.
	      Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
	      return START_STICKY;
	   }
	   @Override
	   public void onDestroy() {
	      super.onDestroy();
	      Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
	   }
}	*/
	
	
	
	
	
	/* private final String TAG = "SoundService";
	private static final int NOTIFICATION_ID = 1;
	private int mStartID;
	MediaPlayer player;
	public IBinder onBind(Intent arg0) {
	    return null;
	}

	@Override
	public void onCreate() {
	    TODO Auto-generated method stub
	    super.onCreate();
	       player = MediaPlayer.create(this, R.raw.sound1);
		        player.setLooping(true); // Set looping
		        player.setVolume(100,100);
		        player.start();
		}
	
		public void onStartCommand(Intent intent, int startId) {
		    int s = 0;
			// TODO Auto-generated method stub
			super.onStartCommand(intent, s, startId);
		}
		public void onDestroy() {
		    // TODO Auto-generated method stub
		    super.onDestroy();
		}

		protected void onNewIntent() {
		    player.pause();
		}} */