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
		
		AcSensor.Inst().onCreate(this);		// �Z���T�[������
    
   
	   Thread trd = new Thread(new Runnable()
	   {
		public void run() 
  	    {	        
               for(int i=1; i>0; i++)
               {	   
		        //�����̉�			    
                	
			    
                
                //�Z���T�[�̒l�@����1
                float co1 = Player._cir._x ;
	            //�Z���T�[�̒l ����2
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
		//�A�N�e�B�r�e�B�������n�߂鎞�Ă΂��
		super.onResume();
		AcSensor.Inst().onResume();// �J�n���ɃZ���T�[�𓮂����n�߂�
	}

	@Override
	protected void onPause() 
	{	
		//�A�N�e�B�r�e�B�̓������~�܂鎞�Ă΂��
		super.onPause();
		AcSensor.Inst().onPause();// ���f���ɃZ���T�[���~�߂�
	}
 

}