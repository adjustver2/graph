package net.dixq.irairabar;

import java.util.LinkedList;

import android.graphics.Canvas;
import android.graphics.Color;

public class GameMgr {

	LinkedList<Task> _taskList = new LinkedList<Task>();//�^�X�N���X�g
	
	GameMgr(){
		_taskList.add( new Player() );
		_taskList.add( new FpsController() );
	}
	
	public boolean onUpdate() {
		for(int i=0; i<_taskList.size(); i++){
			if(_taskList.get(i).onUpdate() == false){	//�X�V���s�Ȃ�
				_taskList.remove(i);					//���̃^�X�N������
				i--;
			}
		}
		return true;
	}

	public void onDraw(Canvas c) {
		c.drawColor(Color.WHITE);	//���œh��Ԃ�
		for(int i=0; i<_taskList.size(); i++){
			_taskList.get(i).onDraw(c);//�`��
		}
	}

}
