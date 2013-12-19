package com.example.helloworld;

import java.io.IOException;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;
import android.view.Window;

public class MediaPlayerTest extends Activity {

	MediaPlayer mediaPlayer;
	
	/**
	 * hide the title bar
	 * load text view
	 * set it as content view
	 * set the volume control stream to the AudioManager stream music
	 * Instanciate the media player
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		TextView textView = new TextView(this);
		setContentView(textView);
		
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		mediaPlayer = new MediaPlayer();
		try{
			AssetManager assetManager = getAssets();
			AssetFileDescriptor descriptor = assetManager.openFd("ogg/invisible_theme_song.ogg");
			
			mediaPlayer.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
			mediaPlayer.prepare();
			mediaPlayer.setLooping(true);
		} catch (IOException e) {
			textView.setText("Couldn't load music file, " + e. getMessage());
			mediaPlayer = null;
		}
		
	}
	
	protected void onResume() {
		super.onResume();
		if (mediaPlayer != null) {
			mediaPlayer.start();
		}
	}
	
	protected void onPause() {
		super.onPause();
		if (mediaPlayer != null) {
			mediaPlayer.pause();
			if (isFinishing()) {
				mediaPlayer.stop();
				mediaPlayer.release();
			}
		}
	}
}
