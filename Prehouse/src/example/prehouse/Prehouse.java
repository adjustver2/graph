package example.prehouse;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.text.format.Time;
import android.util.Log;
import android.view.*;
import android.widget.*;

public class Prehouse extends Activity implements Runnable
{
      SampleView sv;
	  String date;
  	  String str1,str2;
	  
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
                 Time time = new Time("Asia/Tokyo");
      	         time.setToNow();
      	         date = time.second+"秒";
      	                        	    
      	         str1 = String.valueOf(SampleView.x);
      	         str2 = String.valueOf(SampleView.y);
      	    
      	         Log.d("test", str1);
      	         Log.d("test", str2);
                 Log.d("time", date);
      	    
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

	@Override
	public void run() {
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
