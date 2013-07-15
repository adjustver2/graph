package net.dixq.irairabar;

import android.app.Activity;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;

public class IrairaBarActivity extends Activity
{	
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
		setContentView( new GameSurfaceView(this) );
		
		AcSensor.Inst().onCreate(this);		// センサー初期化
    
   
	   Thread trd = new Thread(new Runnable()
	   {
		public void run() 
  	    {	        
              
			Time time = new Time("Asia/Tokyo");
	            time.setToNow();
	            int date = time.second;          	    
	            float co1 = Player._vec._x ;
	            float co2 = Player._vec._y ;
	            
	            
	            
	            Log.d(null,String.valueOf(date));
	            Log.d(null,String.valueOf(co1));
	            Log.d(null,String.valueOf(co2));
	            
	            try 
              {
              Thread.sleep(3000);
              } 
              catch(InterruptedException e)
              {
        	
              }
	     }
	  
      });
	
	 trd.start();
     }

   
	@Override
	protected void onResume() 
	{	//アクティビティが動き始める時呼ばれる
		super.onResume();
		AcSensor.Inst().onResume();// 開始時にセンサーを動かし始める
	}

	@Override
	protected void onPause() 
	{	//アクティビティの動きが止まる時呼ばれる
		super.onPause();
		AcSensor.Inst().onPause();// 中断時にセンサーを止める
	}
 }