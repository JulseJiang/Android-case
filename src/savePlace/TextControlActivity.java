package savePlace;

import com.julse.ConfigWelcome;
import com.julse.adapter.R;
import com.julse.adapter.R.id;

import android.R.color;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class TextControlActivity extends Activity {
	public static String TAG="Life";
	private TextView textView1;
	private SeekBar text_seekBar;
	private Button btn_save;
	private RadioGroup colorRadioGroup;
//	private RadioButton radio_red,radio_green,radio_blue,radio_black;
//	private int min_radio=Math.min(R.id.radio0,R.id.radio3);
	private int min_radio=R.id.radio0;
//	private int[] color={Color.RED,Color.GREEN,Color.BLUE,Color.BLACK};
	
	
	private ConfigWelcome configWelcome=new ConfigWelcome();
	private SharedPreferences pref;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_text_control);
		
		textView1=(TextView) findViewById(R.id.textView1);
		text_seekBar=(SeekBar)findViewById(R.id.seekBar1);
		btn_save=(Button) findViewById(R.id.btn_root);
		colorRadioGroup=(RadioGroup) findViewById(R.id.radioGroup1);
//		radio_red=findViewById(id.)
		
		
		Info_Load();
		
		colorRadioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				arg1-=min_radio;
				Log.i(TAG, "arg1="+arg1);
				Log.i(TAG, "CheckedRadioButtonId()="+colorRadioGroup.getCheckedRadioButtonId());
				configWelcome.setText_color_id(arg1);
				textView1.setTextColor(configWelcome.color[arg1]);
			}
			
		});
		
		
		
		btn_save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
//				text_seekBar.getAlpha();
//				TextControlActivity.this.stopService(getIntent());
				Toast.makeText(TextControlActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
//				configWelcome.setText_color(colorRadioGroup.getCheckedRadioButtonId());
				SharedPreferences pref=getSharedPreferences("info", Context.MODE_PRIVATE);
				SharedPreferences.Editor editor = pref.edit();
				editor.putFloat("text_size", configWelcome.getText_size());
				editor.putInt("pro_length", configWelcome.getPro_length());
				editor.putInt("text_color", configWelcome.getText_color_id());
				editor.commit();//提交
//				Intent intent =getIntent();
//				intent.putExtra("textSize", configWelcome.getText_size());
//				startActivityForResult(intent, 0x11);


				setResult(0x12);
//				finishActivity(0x11);
				finish();
			}
		});
		text_seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
//				Toast.makeText(TextControlActivity.this, "ddddddddddd"+text_seekBar.getProgress(), Toast.LENGTH_SHORT).show();
				
				configWelcome.setPro_length(text_seekBar.getProgress());
				textView1.setTextSize(configWelcome.getText_size());
				
				
//				Toast.makeText(TextControlActivity.this, "ConfigWelcome.text_size"+configWelcome.getText_size()+"ConfigWelcome.pro_length"+configWelcome.getPro_length()+"configWelcome.getPro_length()"+configWelcome.getPro_length(), Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
				
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.text_control, menu);
		return true;
	}
	public void Info_Load(){
		pref=getSharedPreferences("info", Context.MODE_PRIVATE);
		
		configWelcome.setText_size(pref.getFloat("text_size", (float) (30.0*45.0/100)));
		configWelcome.setPro_length(pref.getInt("pro_length",30));
		configWelcome.setText_color_id(pref.getInt("text_color",0));
		
		textView1.setTextSize(configWelcome.getText_size());
		textView1.setTextColor(configWelcome.color[configWelcome.getText_color_id()]);
		text_seekBar.setProgress(configWelcome.getPro_length());
		colorRadioGroup.check(configWelcome.getText_color_id()+min_radio);
		
	}

}
