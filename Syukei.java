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
		    //(1)�������镶����𐶐�
		    String str = new String("01222222212");
		    //(2)�������split���\�b�h�ŕ���
		    String[] strAry = str.split("");
		    //(3)�������ꂽ������̕\��
		    //i�͕����񐔂̃J�E���g		    
		    for(int i=10; i<strAry.length; i++)
		    { 
		    	 //�M�����i�[���ꂽ�z����J�E���g	        		    	
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
		        //�����ɏo�̓v���O������u��
		        System.out.println(a);
		        System.out.println(b);
	   
	   }
		   
}    
