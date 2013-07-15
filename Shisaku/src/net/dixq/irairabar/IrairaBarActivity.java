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
		
		AcSensor.Inst().onCreate(this);		// �Z���T�[������
    
   
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
	{	//�A�N�e�B�r�e�B�������n�߂鎞�Ă΂��
		super.onResume();
		AcSensor.Inst().onResume();// �J�n���ɃZ���T�[�𓮂����n�߂�
	}

	@Override
	protected void onPause() 
	{	//�A�N�e�B�r�e�B�̓������~�܂鎞�Ă΂��
		super.onPause();
		AcSensor.Inst().onPause();// ���f���ɃZ���T�[���~�߂�
	}
 }