package example.graph4;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;


public class Graph4 extends Activity 
{
	    //�ǉ���
	    private int a;
　　　　　　private int b;
	　　private int d;

　　　　　　public void onCreate(Bundle savedInstanceState) 
	    {
	    super.onCreate(savedInstanceState);

	    DrawView view = new DrawView(getApplication());
	    setContentView(view);
	    
	    //�ǉ���
	    //Bundle extras=getIntent().getExtras();
	    //if (extras!=null) 
	    //{
	    //a = extras.getInt("a");
	    //b = extras.getInt("b");
	    //d = extras.getInt("d");
	    //}
	}
}




class DrawView extends View 
{

	  public DrawView(Context context) 
	  {
	    super(context);
	  }
	  
	　　　　//�t�B�[���h:���[��
		int a;
		int b;
		int d;
		
				
		//�t�B�[���h�F�~���p
		private int agr;
		private int dis;
		private int ind;
		private int mid;
		
	    		
		//���[���E�߂��l2
		int getA(){a = 4; return a;}
        　　　　int getB(){b = 2; return b;}
		int getD(){d = 2; return d;}
		
		int getAgr()
		{
			//�߂��l2
			int a = getA();
			int b = getB();
			int d = getD();
			
			agr = 360*a/(a+b+d);
			return agr;
		}
		
		int getDis()
		{
			//�߂��l
			int a = getA();
			int b = getB();
			int d = getD();
			
			dis = 360*b/(a+b+d);
			return dis;
		}
		
		int getInd()
		{
			ind = agr+dis;
			return ind;
		}
		
		int getMid()
		{
		//�߂��l
		int a = getA();
		int b = getB();
		int d = getD();
			
		mid = 360*d/(a+b+d);
		return mid;
		}
	  
	  public void onDraw(Canvas c)
	  {
	    
		//�~���p:�߂��l
		int agr= getAgr();
		int dis= getDis();
        　　　　int ind= getInd();
	    　　int mid= getMid();
		       
		c.drawColor(Color.WHITE);
	    
	    Paint paint = new Paint();
	    c.drawColor(Color.WHITE);
	    paint.setStrokeWidth(5);
	    paint.setAntiAlias(true);
	    
	    	    
	    //�O���t�`��
	    paint.setStyle(Paint.Style.FILL);
	    paint.setColor(Color.RED);
	    c.drawArc(new RectF(10.0f,10.0f,200.0f,150.0f), 0, agr, true, paint);
	    paint.setColor(Color.BLUE);
	    c.drawArc(new RectF(10.0f,10.0f,200.0f,150.0f), agr, dis, true, paint);
	    paint.setColor(Color.GRAY);
	    c.drawArc(new RectF(10.0f,10.0f,200.0f,150.0f), ind, mid, true, paint);
	    
	    int a = getA();
        int b = getB();
        int d = getD();
	    
	    //���ʕ\��
        paint.setColor(Color.BLACK);
        c.drawText("���[����", 280, 80, paint);
        paint.setColor(Color.RED);
        c.drawText("�^��"+a,280,100,paint);
        paint.setColor(Color.BLUE);
        c.drawText("����"+b,280,120,paint);
        paint.setColor(Color.GRAY);
        c.drawText("�����["+d,280,140,paint);
	    
	      
	  }
}	