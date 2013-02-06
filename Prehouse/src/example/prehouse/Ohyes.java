package example.prehouse;

import android.text.format.Time;

public class Ohyes extends Thread
{
		String date;
		
		public void run()
		{
		Time time = new Time("Asia/Tokyo");
	    time.setToNow();
	    date = time.second + "•b";
		System.out.println(date);
		}
}
