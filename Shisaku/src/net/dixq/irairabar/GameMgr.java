package net.dixq.irairabar;

import java.util.LinkedList;

import android.graphics.Canvas;
import android.graphics.Color;

public class GameMgr {

	LinkedList<Task> _taskList = new LinkedList<Task>();//タスクリスト
	
	GameMgr(){
		_taskList.add( new Player() );
		_taskList.add( new FpsController() );
	}
	
	public boolean onUpdate() {
		for(int i=0; i<_taskList.size(); i++){
			if(_taskList.get(i).onUpdate() == false){	//更新失敗なら
				_taskList.remove(i);					//そのタスクを消す
				i--;
			}
		}
		return true;
	}

	public void onDraw(Canvas c) {
		c.drawColor(Color.WHITE);	//白で塗りつぶす
		for(int i=0; i<_taskList.size(); i++){
			_taskList.get(i).onDraw(c);//描画
		}
	}

}
