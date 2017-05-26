package com.julse.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import adapterAuto.MyAdapter;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

public class AutoActivity extends Activity {
	private ListView listView;
	private MyAdapter myAdapter;
	private ArrayList list;
	private int[] images={R.drawable.head1,R.drawable.head2,R.drawable.head3,R.drawable.head4,R.drawable.head5};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_auto);
		setTitle("微博界面");
		listView = (ListView) findViewById(R.id.listView1);
		initList();
		myAdapter = new MyAdapter(
				AutoActivity.this,
				list, 
				R.layout.auto_item);
		listView.setAdapter(myAdapter);
	}
	public void initList(){
		list=new ArrayList();
		for (int i = 0; i < 3; i++) {
			HashMap map=new HashMap();
			map.put("head", images[i]);
			map.put("name", "张"+i);
			map.put("message", i+"这个人很懒，什么都没有留下");
			list.add(map);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.auto, menu);
		return true;
	}

}
