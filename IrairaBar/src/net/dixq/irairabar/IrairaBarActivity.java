package net.dixq.irairabar;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;

public class IrairaBarActivity extends Activity 
{
	static int st = 1;
	GameSurfaceView _view;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);//��ʂ̃^�C���A�E�g�h�~ 
		
		_view = new GameSurfaceView(this);
		setContentView(_view);
		AcSensor.Inst().onCreate(this); // �Z���T�[������
	
		
		//��͗p
		 StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
		
		Thread trd = new Thread(new Runnable()
		   {
			public void run() 
	  	    {	        
	               for(int i=1; i>0; i++)
	               {	             	
	            	   
					//try
	         	  	  //{		
	            		//   XmlPullParserFactory factory;
	            		  // factory = XmlPullParserFactory.newInstance();
	            		   //factory.setNamespaceAware(true);
	            		   //XmlPullParser xpp = factory.newPullParser();
	            		 
	            		   // assets���̎擾
	            		   //AssetManager asset = getResources().getAssets();
	            		   // XML�t�@�C���̃X�g���[�������擾
	            		   //InputStream is = null;
	            		   //is = asset.open("hantei.xml");
	            		   //InputStreamReader isr = new InputStreamReader(is);
	            		   //xpp.setInput(isr);
	            		    
	            		   //int eventType = xpp.getEventType();
	            		   
	         	  	   //while (eventType != XmlPullParser.END_DOCUMENT) 
	         	  	   //{
	         	  	    //if (eventType == XmlPullParser.START_DOCUMENT) 
	         	  	    //{} 
	         	  	    //else if (eventType == XmlPullParser.START_TAG) 
	         	  	    //{} 
	         	  	    //else if (eventType == XmlPullParser.END_TAG) 
	         	  	    //{} 
	         	  	    //else if(eventType == XmlPullParser.TEXT) 
	         	  	    //{
	         	  	    	//String tu = new String();
	         	  	    	//tu = xpp.getText();
	         	  	    	//st= Integer.parseInt(tu);
	         	  	    	
	         	  	    //}	    
	         	  	     //eventType = xpp.next();
	         	  	    //}
	         	  	  //} 
	         	  	  
	         	  	    //catch(XmlPullParserException e) 
	         	  	    //{
	         	  	    //e.printStackTrace();
	         	  	    //} 
	         	  	  
	         	  	    //catch (IOException e) 
	         	  	    //{
	         	  	    //e.printStackTrace();
	         	  	    //}
	            	   
	            	   
	                
	                //�Z���T�[�̒l�@����1
	                float co1 = Player._cir._x ;
		            //�Z���T�[�̒l ����2
	                float co2 = Player._cir._y ;
		            
		            
		            
	                Log.d("log",String.valueOf(i));
		            Log.d("log",String.valueOf(co1));
		            Log.d("log",String.valueOf(co2));
		            Log.d("log",String.valueOf(st));
		            
		           try 
	               {
		            	Thread.sleep(5000);
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
	protected void onResume() { // �A�N�e�B�r�e�B�������n�߂鎞�Ă΂��
		super.onResume();
		AcSensor.Inst().onResume();// �J�n���ɃZ���T�[�𓮂����n�߂�
	}

	@Override
	protected void onPause() { // �A�N�e�B�r�e�B�̓������~�܂鎞�Ă΂��
		super.onPause();
		AcSensor.Inst().onPause();// ���f���ɃZ���T�[���~�߂�
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			_view = new GameSurfaceView(this);
			setContentView(_view); // �����̎��̂�GameSurfaceView����GameMgr
			return false;
		} else {
			return super.onKeyDown(keyCode, event);
		}
	}
}