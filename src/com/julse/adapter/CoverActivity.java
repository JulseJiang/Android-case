package com.julse.adapter;

import savePlace.LoginActivity;
import savePlace.StudentInfoActivity;
import savePlace.WelcomeActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CoverActivity extends Activity {
	private Button btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_10;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cover);
		setTitle("封面");
		
		btn_1=(Button) findViewById(R.id.button1);
		btn_2=(Button) findViewById(R.id.button2);
		btn_3=(Button) findViewById(R.id.button3);
		btn_4=(Button) findViewById(R.id.button4);
		btn_5=(Button) findViewById(R.id.button5);
		btn_6=(Button) findViewById(R.id.button6);
//		btn_7=(Button) findViewById(R.id.button7);
//		btn_8=(Button) findViewById(R.id.button8);
//		btn_9=(Button) findViewById(R.id.button9);
//		btn_10=(Button) findViewById(R.id.button10);
//		1-调节字体大小颜色--ok
		btn_1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent =new Intent(CoverActivity.this,WelcomeActivity.class);
				startActivity(intent);
			}
		});
//		2-学生信息列表操作
		btn_2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent =new Intent(CoverActivity.this,StudentInfoActivity.class);
				startActivity(intent);
			}
		});
//		3-记住密码登录界面
		btn_3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent =new Intent(CoverActivity.this,LoginActivity.class);
				startActivity(intent);
			}
		});
//		4-微博列表界面
		btn_4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent =new Intent(CoverActivity.this,AutoActivity.class);
				startActivity(intent);
			}
		});
//		5-联系人列表界面
		btn_5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent =new Intent(CoverActivity.this,SettingActivity.class);
				startActivity(intent);
			}
		});
//		6-文件操作
		btn_6.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(CoverActivity.this,FileViewActivity.class));
			}
		});
		
	}
	class btn_action implements OnClickListener{
		private Class class1;
		public btn_action(Class class1) {
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onClick(View arg0) {
			startActivity(new Intent(CoverActivity.this,class1));
			
		}
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cover, menu);
		return true;
	}

}
