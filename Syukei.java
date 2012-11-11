package syukei;

import java.awt.event.InputEvent;
import java.io.*;


public class Syukei 
{   
	static int a;
	static int b;
	
	Syukei()
	{
		a=0;
		b=0;
	}
	
	
	   public static void main(String[] args) throws IOException
	   {
		    //(1)分割する文字列を生成
		    String str = new String("01222222212");
		    //(2)文字列をsplitメソッドで分割
		    String[] strAry = str.split("");
		    //(3)分割された文字列の表示
		    //iは文字列数のカウント		    
		    for(int i=10; i<strAry.length; i++)
		    { 
		    	 //信号が格納された配列をカウント	        		    	
		    	 int atai = Integer.parseInt(strAry[i]);
		    	  switch(atai)
		         {
		    	  case 1:
		    	  a++;
		    	  break;
		    	  
		    	  case 2:
		    	  b++;
		          break;
		          }
		     
		     }
		        //ここに出力プログラムを置く
		        System.out.println(a);
		        System.out.println(b);
	   
	   }
		   
}    
