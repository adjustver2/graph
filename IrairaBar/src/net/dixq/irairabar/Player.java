package net.dixq.irairabar;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Player extends Task 
{
	private final static float MAX_SPEED = 15;		//�ړ�����ő�X�s�[�h
	private final static float SIZE = 30;			//���@�̑傫��
	private Circle _cir = null;			//���@�̉~
	private Paint _paint = new Paint();	//�`��ݒ�
	private Vec _vec     = new Vec();	//���@�̈ړ��x�N�g��
	private Vec _sensorVec = new Vec();	//�Z���T�[�̃x�N�g��
	
	public Player()
	{
		_cir = new Circle( 380, 700, SIZE );	//(240,0)�̈ʒu��SIZE�̑傫���̉~�����
		_paint.setColor(Color.BLUE);		//�F��ɐݒ�
		_paint.setAntiAlias(true);			//�G�C���A�X���I��
	}
	
	//���@���S�~���擾����
	public final Circle getPt(){
		return _cir;
	}

	// �x�N�g�����Z�b�g����
	private void setVec(){
		float x = -AcSensor.Inst().getX()*2;	//�����x�Z���T�[�̏����擾
		float y =  AcSensor.Inst().getY()*2;
		_sensorVec._x = x < 0 ? -x*x : x*x;	//2�悵�ĕω����U���ɂ���
		_sensorVec._y = y < 0 ? -y*y : y*y;	//2�悷���+�ɂȂ�̂ŁA���Ȃ�}�C�i�X��t����
		_sensorVec.setLengthCap(MAX_SPEED);	//�x�N�g���̑傫�����ő�X�s�[�h�ȏ�ɂȂ�Ȃ��悤�ɂ���		
		_vec.blend( _sensorVec, 0.05f );	//�Z���T�[�̃x�N�g�������Ɏ��ۂ̈ړ��x�N�g����5%�߂Â���
	}

	// �ړ��x�N�g���̌����Ă�����ɓ�����
	private void Move(){
		_cir._x += _vec._x;	//�ړ��x�N�g��_vec���w�������Ɉړ������� 
		_cir._y += _vec._y;
	}
	
	@Override
	public boolean onUpdate()
	{
		setVec();	//�ړ��x�N�g�����Z�b�g����
		Move();		//�ړ��x�N�g���������Ă�����ɓ�����
		return true;
	}

	@Override
	public void onDraw( Canvas c )
	{
		c.drawCircle(_cir._x, _cir._y, _cir._r, _paint);
	}

}
