package net.dixq.irairabar;

import android.app.Activity;
import android.os.Bundle;
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
               for(int i=1; i>0; i++)
               {	   
		        //処理の回数			    
                	
			    
                
                //センサーの値　その1
                float co1 = Player._cir._x ;
	            //センサーの値 その2
                float co2 = Player._cir._y ;
	            
	            
	            
                Log.d("log",String.valueOf(i));
	            Log.d("log",String.valueOf(co1));
	            Log.d("log",String.valueOf(co2));
	            
	           try 
               {
	            	Thread.sleep(3000);
               } 
               catch(InterruptedException e)
               {
        	
               }
	     }
  	    }
      });
	
	      trd.start();
    
    }

   
	@Override
	protected void onResume() 
	{	
		//アクティビティが動き始める時呼ばれる
		super.onResume();
		AcSensor.Inst().onResume();// 開始時にセンサーを動かし始める
	}

	@Override
	protected void onPause() 
	{	
		//アクティビティの動きが止まる時呼ばれる
		super.onPause();
		AcSensor.Inst().onPause();// 中断時にセンサーを止める
	}
 

}