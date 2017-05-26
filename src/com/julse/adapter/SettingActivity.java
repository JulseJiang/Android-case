package com.julse.adapter;
/**
 * 列表的使用方法
 * 设置界面
 * 第四次作业：ListView实现增删改查
 */
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import android.location.GpsStatus.Listener;
import android.os.Bundle;
import android.provider.MediaStore.Images;
import android.app.Activity;
import android.text.format.Time;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class SettingActivity extends Activity {
	private ListView lv;
//	strSettingsStrings:6
	private String[] strSettingsStrings={"新消息提醒","勿扰模式","聊天","隐私","通用","账号与安全"};
//	name:5
	private String[] name={"张三","李四","王二","麻子","赵五"};
//	images:5
	private int[] images={R.drawable.head1,R.drawable.head2,R.drawable.head3,R.drawable.head4,R.drawable.head5};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);
		setTitle("联系人列表");
		lv=(ListView) findViewById(R.id.listView1);
//		方法一：实现最简单的adapter
		/*ArrayAdapter adapter= new ArrayAdapter(SettingActivity.this, 
				android.R.layout.simple_list_item_1,
				strSettingsStrings);
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
//				arg2是点击的项id
				Toast.makeText(SettingActivity.this,strSettingsStrings[arg2]+" arg2="+arg2, Toast.LENGTH_LONG).show();
			}
		});
		lv.setOnItemLongClickListener(new OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(SettingActivity.this,strSettingsStrings[arg2]+" arg2="+arg2+"长按", Toast.LENGTH_LONG).show();
				return false;
			}
		});*/
		
//		方法二：设置文字组
		/*ArrayList arrayList= new ArrayList();
		for (int i = 0; i < strSettingsStrings.length; i++) {
			HashMap map=new HashMap();
			map.put("content", strSettingsStrings[i]);
			map.put("state", "否");
			arrayList.add(map);
			
		}
		SimpleAdapter simple= new SimpleAdapter(SettingActivity.this, 
				arrayList, R.layout.item_listview, 
				new String[]{"content","state"}, 
				new int[]{R.id.textView1,R.id.textView2});
		lv.setAdapter(simple);
	}*/
//		方法三：既有图片又有文字
		
		ArrayList arrayList2=new ArrayList();
/*		SimpleDateFormat formatter    =   new    SimpleDateFormat    ("yyyy年MM月dd日    HH:mm:ss     ");       
		Date curDate    =   new    Date(System.currentTimeMillis());//获取当前时间       
		String    str    =    formatter.format(curDate);  */
		
		SimpleDateFormat time_format=new SimpleDateFormat("HH:mm");
		for (int i = 0; i < name.length; i++) {
			Date date=new Date(System.currentTimeMillis());
			String nowTime=time_format.format(date);
			HashMap map=new HashMap();
			map.put("head",images[i]);
			map.put("name", name[i]);
			map.put("time", nowTime);
			map.put("signal", strSettingsStrings[i]);
			arrayList2.add(map);
		}
		SimpleAdapter simples=new SimpleAdapter(
				SettingActivity.this,
				arrayList2,
				R.layout.weixin,
				new String[]{"head","name","time","signal"},
				new int[]{R.id.image_head,R.id.textNo,R.id.text_sent,R.id.text_content});
		lv.setAdapter(simples);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.setting, menu);
		return true;
	}

}
