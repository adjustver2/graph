package example.ohyes;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Ohyes extends Activity
{
  
  public void onCreate(Bundle savedInstanceState) 
  {  
	  super.onCreate(savedInstanceState);
	  LinearLayout layout = (LinearLayout) this.getLayoutInflater().inflate(R.layout.activity_ohyes, null);
      layout.setOrientation(LinearLayout.VERTICAL);
	  //DrawView view = 
 	  new DrawView(getApplication());
      //setContentView(view);
 	  setContentView(R.layout.activity_ohyes);
  
  }
}
  


   class Ohyeah extends Activity
  {
	  public static String a;
	  public static String b;
	  public static String d;
	  
	  
  protected void onCreate (Bundle savedInstanceState)
	         {
  try 
  {
   XmlPullParserFactory factory;
   factory = XmlPullParserFactory.newInstance();
   factory.setNamespaceAware(true);
   XmlPullParser xpp = factory.newPullParser();

   // assets���̎擾
   AssetManager asset = getResources().getAssets();
   // XML�t�@�C���̃X�g���[�������擾
   InputStream is = null;
   is = asset.open("XML.xml");
   InputStreamReader isr = new InputStreamReader(is);
   xpp.setInput(isr);
   
   int eventType = xpp.getEventType();
   while (eventType != XmlPullParser.END_DOCUMENT) 
   {
    //if (eventType == XmlPullParser.START_DOCUMENT) 
    //{
    //ab.setText("Start document");
    //} 
    //else if (eventType == XmlPullParser.START_TAG) 
    //{
    //cd.setText(xpp.getName());
    //} 
    //else if (eventType == XmlPullParser.END_TAG) 
    //{
     //ef.setText(xpp.getName());
    //} 
    //else 
     if (eventType == XmlPullParser.TEXT) 
    {
     String st = new String();
     st = xpp.getText();
     String strAry[] = st.split(",");
     a = strAry[0];
     b = strAry[1];
     d = strAry[2];
     //gh.setText(strAry[0]);
    }
    
     eventType = xpp.next();
   }
  } 
  catch (XmlPullParserException e) 
  {
   //TODO �����������ꂽ catch �u���b�N
   e.printStackTrace();
  } 
  catch (IOException e) 
  {
   //TODO �����������ꂽ catch �u���b�N
   e.printStackTrace();
  }
  //ij.setText("End document");
 }

}

    class Henkan
   {
	public static int f;
	public static int g;
	public static int h;

	public void main(String[] args) 
	 {
		 String a = Ohyeah.a;
	     f = Integer.parseInt(a);
	     
	     String b = Ohyeah.b; 
	     g = Integer.parseInt(b);
	     
	     String d = Ohyeah.d;
	     h =Integer.parseInt(d);
	 }	
    }


    
    class DrawView extends View 
    {

	  public DrawView(Context context) 
	  {
	    super(context);
	  }

	    //�t�B�[���h
		int a;
		int b;
		int d;
        
		
		//�~���p
		private int agr;
		private int dis;
		private int ind;
		private int mid;


		//�߂�l
		int getA()
		{
			a = Henkan.f; 
			return a;
		}
        
		int getB()
		{
			b = Henkan.g; 
			return b;
		}
		
		int getD()
		{
			d = Henkan.h; 
			return d;
		}

		int getAgr()
		{
			int a = getA();
			int b = getB();
			int d = getD();

			agr = 360*a/(a+b+d);
			return agr;
		}

		int getDis()
		{
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
		int a = getA();
		int b = getB();
		int d = getD();

		mid = 360*d/(a+b+d);
		return mid;
		}

	  @SuppressLint("DrawAllocation")
	  public void onDraw(Canvas c)
	  {
		int agr= getAgr();
		int dis= getDis();
        int ind= getInd();
	    int mid= getMid();

		c.drawColor(Color.WHITE);

	    Paint paint = new Paint();
	    c.drawColor(Color.WHITE);
	    paint.setStrokeWidth(5);
	    paint.setAntiAlias(true);


	    //�`��
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

	    //���[����
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


