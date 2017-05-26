package savePlace;


import com.julse.ConfigWelcome;
import com.julse.adapter.R;
import com.julse.adapter.R.id;
import com.julse.adapter.R.layout;
import com.julse.adapter.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class WelcomeActivity extends Activity {
	private TextView textView;
	private ConfigWelcome configWelcome=new ConfigWelcome();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		textView=(TextView) findViewById(R.id.textView);
		Info_Load();
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.welcome, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(WelcomeActivity.this,TextControlActivity.class);
		startActivityForResult(intent, 0x11);
//		startActivity(intent);
		return super.onOptionsItemSelected(item);
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		if (resultCode==0x12) {
//			float textSize=data.getFloatExtra("textSize", (float) 1.0);
//			textView.setTextSize(textSize);
			Info_Load();
		}
	}
	public void Info_Load(){
		SharedPreferences pref=getSharedPreferences("info", Context.MODE_PRIVATE);
		configWelcome.setText_size(pref.getFloat("text_size", (float) (30.0*45.0/100)));
		configWelcome.setPro_length(pref.getInt("pro_length",30));
		configWelcome.setText_color_id(pref.getInt("text_color", 0));
		
		textView.setTextSize(configWelcome.getText_size());
//		Log.i(TextControlActivity.TAG, "configWelcome.getText_color_id()="+configWelcome.getText_color_id());
		textView.setTextColor(configWelcome.color[configWelcome.getText_color_id()]);
//		Log.i(TextControlActivity.TAG, "³É¹¦");
	}
}
