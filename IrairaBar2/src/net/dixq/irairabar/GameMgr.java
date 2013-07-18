package net.dixq.irairabar;

import java.util.ArrayList;
import java.util.LinkedList;

import net.dixq.irairabar.Barricade.eType;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class GameMgr {
	
	private enum eStatus
	{
		NORMAL,
		GAMEOVER,
		GAMECLEAR, HANTEI
	};

	private static final float PI = (float) Math.PI;
	private ArrayList<Barricade> _barrList = new ArrayList<Barricade>();//��Q�����X�g
	private LinkedList<Task> _taskList = new LinkedList<Task>();// �^�X�N���X�g
	private eStatus _status = eStatus.NORMAL;
	private Player _player;

	GameMgr() {
		_barrList.add(new BarricadeSquare(  0,  0,480, 20, null));// ���4���Ɏl�p�`��z�u
		_barrList.add(new BarricadeSquare(  0,  0, 20,800, null));
		_barrList.add(new BarricadeSquare(460,  0, 20,800, null));
		_barrList.add(new BarricadeSquare(  0,780,480, 20, null));
		
		_barrList.add(new BarricadeSquare(  0,220,150, 20, null));

		//_barrList.add(new BarricadeTriangle(  0, 0, 200, new BConf(+PI / 150)));// �����]����O�p�`
		//_barrList.add(new BarricadeTriangle(480, 0, 180, new BConf(+PI / 150)));// �E���]����O�p�`

		//_barrList.add(new BarricadeStar(240, 240, 50, 200, new BConf(-PI / 360)));// �����ɉ�]���鐯
		//_barrList.add(new BarricadeStar(240, 240, 20,  80, new BConf(+PI / 360)));// �����ɉ�]���鐯
		
		_barrList.add(new BarricadeSquare(300, 440, 200, 20, null));//�E���̌Œ�ʘH
		_barrList.add(new BarricadeSquare(250, 520, 130, 20, null));//
		_barrList.add(new BarricadeSquare(330, 620, 130, 20, null));//
		_barrList.add(new BarricadeSquare(300, 80, 200, 20, null));

		_barrList.add(new BarricadeSquare(200, 300, 130, 20, null));//
		_barrList.add(new BarricadeSquare(80, 140, 180, 20, new BConf(-PI / 150)));
		_barrList.add(new BarricadeSquare(90, 380, 200, 20, new BConf(+PI / 150)));
		_barrList.add(new BarricadeSquare(80, 620, 200, 20, new BConf(-PI / 150)));
		
		
		
		//_barrList.add(new BarricadeSquare(230, 390, 20, 350, null));//������؂��

		//_barrList.add(new BarricadeSquare(0, 480, 240, 20, new BConf(+PI / 360)));// ������]����o�[

		//_barrList.add(new BarricadeSquare( 20, 600, 110, 20, new BConf(+PI / 360)));// ������]����o�[
		//_barrList.add(new BarricadeSquare(130, 600, 110, 20, new BConf(+PI / 360)));// ������]����o�[
		//_barrList.add(new BarricadeSquare(185, 600,  55, 20, new BConf(+PI / 360)));// ������]����o�[

		//_barrList.add(new BarricadeSquare(20, 680,  80, 20, null));// �S�[���ɐڐG�����o�[

		_barrList.add(new BarricadeSquare(20, 20,  440, 40, new BConf(eType.GOAL)));// �S�[��
		
		for (Barricade bar : _barrList) {
			_taskList.add(bar);	//�^�X�N���X�g�ɏ�Q����ǉ�
		}

		_player = new Player();
		_taskList.add(_player);
		_taskList.add(new FpsController());
	}

	@SuppressWarnings("incomplete-switch")
	private boolean Collision(){
		
		Vec vec = new Vec();
		final Circle cir = _player.getPt();
		for(Barricade barr : _barrList){
			Def.eHitCode code = barr.isHit(cir, vec);
			switch(code){
			case OUT:
				_status = eStatus.GAMEOVER;
				return true;
			case GOAL:
				_status = eStatus.GAMECLEAR;
				return true;
			}
		}
	  return false;
	}
	

	
	public boolean onUpdate() {
		if( _status != eStatus.NORMAL )
		{
			return true;
		}
		//�ǉ�
		if(IrairaBarActivity.st==1)
		{
			return true;
		}
		if( Collision() ){
			return true;
		}
		for (int i = 0; i < _taskList.size(); i++) {
			if (_taskList.get(i).onUpdate() == false) { // �X�V���s�Ȃ�
				_taskList.remove(i); // ���̃^�X�N������
				i--;
			}
		}
		return true;
	}

	private void drawStatus(Canvas c){
		if(IrairaBarActivity.st==1)
		{
			Paint paint = new Paint();
			paint.setTextSize(80);
			paint.setColor(Color.RED);
			c.drawText("GameOver",40,100,paint);
		}
		else
			{
			switch( _status ){
		case GAMEOVER:
			{
				Paint paint = new Paint();
				paint.setTextSize(80);
				paint.setColor(Color.BLACK);
				c.drawText("GameOver", 40, 100, paint);
			}
			break;
		
			
		
		case GAMECLEAR:
			{
				Paint paint = new Paint();
				paint.setTextSize(80);
				paint.setColor(Color.BLACK);
				c.drawText("GameClear", 40, 100, paint);
			}
			break;
		}
	}
 }
	public void onDraw(Canvas c) {
		c.drawColor(Color.WHITE); // ���œh��Ԃ�
		for (Task task : _taskList) {
			task.onDraw(c);// �`��
		}
		drawStatus(c);
	}

}