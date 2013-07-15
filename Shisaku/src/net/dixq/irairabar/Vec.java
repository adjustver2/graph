package net.dixq.irairabar;

public class Vec {
	
	public float _x, _y;
	
	Vec(){
		_x = _y = 0;
	}
	
	Vec( float x, float y ){
		_x = x;
		_y = y;
	}
	
	//Šp“x‚ğæ“¾‚·‚é
	float getAngle(){
		return (float)Math.atan2(_y, _x);
	}

	//‘å‚«‚³‚ğæ“¾‚·‚é
	float getLength(){
		return (float)Math.sqrt( _x*_x + _y*_y );
	}
	
}
