package net.dixq.irairabar;

import net.dixq.irairabar.Def.eHitCode;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;

public class Barricade extends Task {
	public enum eType{
		OUT,
		GOAL,
	}
	
	protected PointF  _center = new PointF(0,0);		//�}�`�̒��S�_
	protected PointF  _pt[];							//�}�`�̒��_
	protected Paint   _paint = new Paint();				//�y�C���g
	protected eType   _type = eType.OUT;				//�^�C�v(������ƃA�E�g�ȕǁA�S�[���̕ǁA��)
	protected float   _rotaSpeed = 0;					//��]�X�s�[�h

	//�R���X�g���N�^�B type=�^�C�v�A n=���_�̐��A conf=�ݒ���
	public Barricade(int n, BConf conf){
		if( conf != null ){
			_rotaSpeed 	= conf.speed;	//��]�X�s�[�h
			_type 		= conf.type;	//���̂̃^�C�v
		}
		switch(_type){
		case OUT:	//�ڐG���ăA�E�g�ȕ�
			_paint.setColor(Color.BLACK);
			break;
		case GOAL:	//�ڐG���ăS�[���ȕ�
			_paint.setColor(Color.GREEN);
			break;
		}
		_pt = new PointF[n];	//���_�z������
		for( int i=0; i<n; i++ ){
			_pt[i] = new PointF();	//���_�����
		}
		_paint.setAntiAlias(true);
	}

	//�X�V����
	public boolean onUpdate()
	{
		if( _rotaSpeed != 0 )
		{	//��]����Ȃ�
			DiagramCalcr.RotateDiagram( _pt, _center, _rotaSpeed );	//���_���X�g(_pt)��_center�𒆐S�ɉ�]����
		}
		return true;
	}


	
	//�ڐG���Ă��邩��₤�B�~cir������vec�ƐڐG���Ă���ΐڐG�������̂̃^�C�v��Ԃ��B�ڐG���Ă��Ȃ����NO��Ԃ�
	public Def.eHitCode isHit( final Circle cir, Vec vec )
	{
		if( DiagramCalcr.isHit( _pt, cir, vec ) == true )
		{
			switch(_type){
			case OUT:
				return Def.eHitCode.OUT;
			case GOAL:
				return Def.eHitCode.GOAL;
			}
		}
		return Def.eHitCode.NO;
	}
	
	//�`�悷��
	public void onDraw(Canvas c){
		if( _pt.length < 1 ){	//���_��1�����Ȃ�Đ}�`�͂��肦�Ȃ�
			return;
		}
		Path path = new Path();
		path.moveTo(_pt[0].x, _pt[0].y);	//�p�X�̏����ʒu���Z�b�g
		for( int i=0; i<_pt.length; i++ ){
			path.lineTo(_pt[i].x, _pt[i].y);	//���_�̈ʒu�փ��C���������Ă���
		}
		c.drawPath(path, _paint);	//���������C����`�悷��
	}

}
