package net.dixq.irairabar;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Player extends Task {
	final static float SIZE = 20;		//���@�̑傫��
	static Circle _cir = null;			//���@�̉~
	static Paint _paint = new Paint();	//�`��ݒ�
	private Vec _vec = new Vec();		//���@�̈ړ��x�N�g��
	
	public Player(){
		_cir = new Circle( 240, 0, SIZE );	//(240,0)�̈ʒu��SIZE�̑傫���̉~�����
		_paint.setColor(Color.BLUE);		//�F��ɐݒ�
		_paint.setAntiAlias(true);			//�G�C���A�X���I��
		_vec._y = 2;						//�ړ��x�N�g�������Ɍ�����
	}

	@Override
	public boolean onUpdate(){
		
		_vec._x = -AcSensor.Inst().getX();	//�����x�Z���T�[�̏����擾
		_vec._y =  AcSensor.Inst().getY();
		
		_cir._x += _vec._x;	//�ړ��x�N�g��_vec���w�������Ɉړ������� 
		_cir._y += _vec._y;

		return true;
	}

	@Override
	public void onDraw( Canvas c ){
		c.drawCircle(_cir._x, _cir._y, _cir._r, _paint);
	}

}
