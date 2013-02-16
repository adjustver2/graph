package example.prehouse;

import android.app.*;
import android.app.AlertDialog.Builder;
import android.content.*;
import android.content.res.Resources;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class Prehouse extends Activity   
{      
	  ImageView iv;
	  SampleView sv;
  	  String date,str1,str2;  	  
  	  static String hantei="1";
  	  	  
      public void onCreate(Bundle savedIntanceState)
      {
    	  super.onCreate(savedIntanceState);
    	  LinearLayout ll = new LinearLayout(this);
    	  setContentView(ll);
          
    	  sv = new SampleView(this);
    	  ll.addView(sv); 
    	  
    	  //Bitmap bmp = BitmapFactory.decodeResource(getResources(),R.drawable.face);
          //iv =  new ImageView(this);
          //iv.setImageBitmap(bmp);
    	  //ll.addView(iv);    
      }

}


        

class SampleView extends View
{
     static float x,y;
     private float dx,dy,dx1,dy1;
	 //private Resources resources;
	 private Bitmap bgBitmap;
	 //private Object ObjectBitmap;
	 private int dp_w;
	 private int dp_h;
	 private int drow_h;
	 private int drow_s;
     
 	 public SampleView(Context cn)
     {
      super(cn);     
      
      // ���\�[�X����bitmap���쐬
      bgBitmap = BitmapFactory.decodeResource(cn.getResources(), R.drawable.face);
      // WindowManager�擾
      WindowManager wm = (WindowManager)cn.getSystemService(Context.WINDOW_SERVICE);
      // Display�C���X�^���X����
      Display dp = wm.getDefaultDisplay();
      // �f�B�X�v���C�T�C�Y�擾
      dp_w = dp.getWidth();
      dp_h = dp.getHeight();
      // ���T�C�Y�摜�̍���
      drow_h = (dp_w / 2) * 3 + 80;
      // �`��n�_�̍���
      drow_s = (dp_h - drow_h) / 2;
      
      //�R���X�g���N�^�ŁA���\�[�X�̎擾
      //resources = this.getContext().getResources();
      //bgBitmap = BitmapFactory.decodeResource(resources, R.drawable.face);
      //ObjectBitmap = BitmapFactory.decodeResource(resources, R.drawable.face);
      
      x = 100; y = 600;
     }
 	 
    public boolean onTouchEvent(MotionEvent e)
    {		
		dx = x-e.getX();
		dy = y-e.getY();
    	  
		dx1 = 250 - e.getX();
		dy1 = 250 - e.getY();
		
    	if(dx<100)
    	{
    		if(dx>-100)
    		{
    		   if(dy<100)
    		   {
    		      if(dy>-100)
    		      {
    		       x = e.getX();
    	           y = e.getY();
    		       this.invalidate();
    		       
    		       if(dx1<20)
    		       {
    		           if(dx1>-20)
    		           {	   
    		    	       if(dy1<20)
    		               {
    		    	           if(dy1>-20)
    		    	           {	   
    		    	    	      if(Prehouse.hantei=="1")
    		    	              {
    		    	                  if(e.getAction() == MotionEvent.ACTION_MOVE)
    		    	                  {
    		    	                  new AlertDialog.Builder(this.getContext())
    		    	    	          .setTitle("�Q�[���N���A")
    		    	    	          .setMessage("�Q�[�����I�����܂�")
    		    	    	          .setPositiveButton("OK", null).show();
    		    	                  }
    		    	               } 
    		    	            }
    		    	         }
    		             }
    		       }
    		           
    		           return true;
    	          }
    	          
    	          }
    	       }
    		   else
    		   {
    		   return false;	
    		   }
    		}
    		else
    		{
    		return false;
    		}
    		
    	
    	
    	
    	return true;
    	
    }
       
     public void onDraw(Canvas cs)
     {      
       super.onDraw(cs);
       
	   //�`����@�̐ݒ�
	   Paint p = new Paint();
	   p.setColor(Color.BLACK);
       p.setStyle(Paint.Style.FILL);
       p.setStrokeWidth(8);
       
       //�摜�`��
       //cs.drawBitmap(bgBitmap,0,0,p);
       // �C���[�W�摜���T�C�Y
       bgBitmap = Bitmap.createScaledBitmap(bgBitmap, dp_w, drow_h , true);  
       // �`��
       cs.drawBitmap(bgBitmap, 0, drow_s, null);       
       //�~�̕`��
       cs.drawCircle( x, y, 50, p);
       cs.drawCircle(250,250,50,p);
     }
  
}
