package example.thr;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.text.format.Time;
import android.view.*;
import android.widget.*;

public class Thr extends Activity
{
      SampleView sv;
      int a,b,d;
	  int date;
      float co1,co2;
      int dareka = 1;
      
      public void onCreate(Bundle savedIntanceState)
      {
    	  super.onCreate(savedIntanceState);
    	  LinearLayout ll = new LinearLayout(this);
    	  setContentView(ll); 
    	  sv = new SampleView(this);
          ll.addView(sv);
      
          Thread trd = new Thread(new Runnable()
          { 
        	public void run() 
        	{
        		
        		while(true)
	            {
        		try
        	  	  {		
        	  	   XmlPullParserFactory factory;
        	  	   factory = XmlPullParserFactory.newInstance();
        	  	   factory.setNamespaceAware(true);
        	  	   XmlPullParser xpp = factory.newPullParser();
        	  	   URL url = new URL("http://192.168.11.2:8080/otsu/yotsu?zahyou="+co1+"&jikoku="+date+"&dareka="+dareka);
        	  	   URLConnection connection = url.openConnection();
        	  	   xpp.setInput(connection.getInputStream(),"UTF-8");
        	  	   
        	  	   int eventType = xpp.getEventType();
        	  	   
        	  	   while (eventType != XmlPullParser.END_DOCUMENT) 
        	  	   {
        	  	    if (eventType == XmlPullParser.START_DOCUMENT) 
        	  	    {} 
        	  	    else if (eventType == XmlPullParser.START_TAG) 
        	  	    {} 
        	  	    else if (eventType == XmlPullParser.END_TAG) 
        	  	    {} 
        	  	    else if(eventType == XmlPullParser.TEXT) 
        	  	    {
        	  	     String st = new String();
        	  	     st = xpp.getText();
        	  	     String strAry[] = st.split(",");
        	  	     a = Integer.parseInt(strAry[0]);
        	  	     b = Integer.parseInt(strAry[1]);
        	  	     d = Integer.parseInt(strAry[2]);
        	  	    }	    
        	  	     eventType = xpp.next();
        	  	    }
        	  	  } 
        	  	  
        	  	    catch(XmlPullParserException e) 
        	  	    {
        	  	    e.printStackTrace();
        	  	    } 
        	  	  
        	  	    catch (IOException e) 
        	  	    {
        	  	    e.printStackTrace();
        	  	    }
        		
        	        
                    Time time = new Time("Asia/Tokyo");
      	            time.setToNow();
      	            date = time.second;          	    
      	            co1 = SampleView.x;
      	            co2 = SampleView.y;
      	            try 
                    {
                    Thread.sleep(3000);
                    } 
                    catch(InterruptedException e)
                    {
              	
                    }
      	         }
      	      };
           });
        	      trd.start();
      }

	public void run() 
	{
		// TODO Auto-generated method stub
	}
}


class SampleView extends View
{
     //座標認識用にx,yの型を定義
     static float x;
	 static float y;
     
     //初期値設定
     public SampleView(Context cn)
     {
   	  super(cn);
   	  x = 400; y = 400;
     }
     
     
     
     public boolean onTouchEvent(MotionEvent e)
     {
	    x = e.getX();
	    y = e.getY();
	 
	    //更新を有効にする
	    this.invalidate();
	    return true;
     
     }
     
     
     protected void onDraw(Canvas cs)
     {
	   super.onDraw(cs);
	 
	   //描画方法の設定
	   Paint p = new Paint();
	   p.setColor(Color.BLACK);
       p.setStyle(Paint.Style.FILL);
       p.setStrokeWidth(8);
       
       //円の描画
       cs.drawCircle( x, y, 50, p);
      
     }
  
}