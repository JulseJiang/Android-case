package mediaPlayer;
/**
 * 音频文件的三种存放
 * res/ran/...
 * assess assesMangeger
 * 外部存储
 * 
 * 作业：歌词，上一曲，下一曲，进度条，皮肤
 */
import com.julse.adapter.R;
import com.julse.adapter.R.layout;
import com.julse.adapter.R.menu;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MediaPlayerActivity extends Activity {
	private Button btn_start;
	private Button btn_pause;
	private Button btn_stop;
	private MediaPlayer player;
	private boolean flag=true;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_media_player);
		setTitle("音乐播放器");
		
		btn_start=(Button) findViewById(R.id.button1);
		btn_pause=(Button) findViewById(R.id.button2);
		btn_stop=(Button) findViewById(R.id.button3);
		
		BtnClickListener bcl=new BtnClickListener();
		btn_start.setOnClickListener(bcl);
		btn_pause.setOnClickListener(bcl);
		btn_stop.setOnClickListener(bcl);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.media_player, menu);
		return true;
	}
//	创建一个监听类，就不必挨个设置监听事件了
	class BtnClickListener implements OnClickListener{
		@Override
		public void onClick(View arg0) {
			switch (arg0.getId()) {
			case R.id.button1:
				if (flag) {
					player=MediaPlayer.create(MediaPlayerActivity.this, R.raw.music);
				}
				
				player.start();
				break;
			case R.id.button2:
				if (player!=null) {
					player.pause();
					flag=false;
				}
				
				break;
			case R.id.button3:
				if (player!=null) {
					player.stop();
					player.release();
					flag=true;
				}
				break;

			}
			
		}
	}

}
