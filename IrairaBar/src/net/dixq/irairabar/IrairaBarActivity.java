package net.dixq.irairabar;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;

public class IrairaBarActivity extends Activity 
{

	GameSurfaceView _view;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);//画面のタイムアウト防止 
		
		_view = new GameSurfaceView(this);
		setContentView(_view);
		AcSensor.Inst().onCreate(this); // センサー初期化
	}

	@Override
	protected void onResume() { // アクティビティが動き始める時呼ばれる
		super.onResume();
		AcSensor.Inst().onResume();// 開始時にセンサーを動かし始める
	}

	@Override
	protected void onPause() { // アクティビティの動きが止まる時呼ばれる
		super.onPause();
		AcSensor.Inst().onPause();// 中断時にセンサーを止める
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			_view = new GameSurfaceView(this);
			setContentView(_view); // 処理の実体はGameSurfaceView内のGameMgr
			return false;
		} else {
			return super.onKeyDown(keyCode, event);
		}
	}
}