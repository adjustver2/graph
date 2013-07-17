package net.dixq.irairabar;

import android.graphics.Canvas;

public abstract class Task {

	public boolean onUpdate()
	{
		if(IrairaBarActivity.st==1)
		{
			return false;
		}
		return true;
	}
	
	public void onDraw(Canvas c){		
	}

}
