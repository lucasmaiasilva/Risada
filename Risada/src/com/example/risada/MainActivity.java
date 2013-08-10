package com.example.risada;

import java.io.IOException;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import android.media.*;



public class MainActivity extends Activity implements OnTouchListener{

	SoundPool soundPool;
	int risadaId=-1;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);
        textView.setOnTouchListener(this);
        setContentView(textView);
        
        
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        soundPool = new SoundPool(20,AudioManager.STREAM_MUSIC,0);
        
        
        try{
        	AssetManager assetManager = getAssets();
        	AssetFileDescriptor descriptor = assetManager.openFd("risada.mp3");
        	risadaId = soundPool.load(descriptor, 1);
        	
        }catch (IOException e ){
        	textView.setText("Nao foi possivel carregar o som"+e.getMessage());
        }
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		
		if (event.getAction() == MotionEvent.ACTION_UP){
			if(risadaId != -1){
				soundPool.play(1, 1, 1, 0, 0,1);
			}
		}
		return true;
	}
    
}
