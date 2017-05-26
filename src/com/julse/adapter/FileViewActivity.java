package com.julse.adapter;

import java.io.File;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class FileViewActivity extends Activity {
	private Spinner spinner;
	private EditText file_name;
	private EditText file_content;
	private Button btn_add;
	private Button btn_delete;
	private Button btn_show;
	private Button btn_write;
	private File file;

	private ArrayAdapter adapter;
	private String[] file_list;

	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_file_view);
		
		spinner=(Spinner) findViewById(R.id.spinner1);
		file_name=(EditText) findViewById(R.id.editText2);
		file_content=(EditText) findViewById(R.id.editText1);
		btn_add=(Button) findViewById(R.id.btn_root);
		btn_delete=(Button) findViewById(R.id.btn_public);
		btn_show=(Button) findViewById(R.id.btn_private);
		btn_write=(Button) findViewById(R.id.button4);
		
		init_file_list();
		adapter=new ArrayAdapter(FileViewActivity.this, android.R.layout.simple_dropdown_item_1line,file_list);
		spinner=new Spinner(FileViewActivity.this);
		spinner.setAdapter(adapter);
	}
	public void init_file_list(){
		file_list=fileList();
		Toast.makeText(FileViewActivity.this, "文件数目："+file_list.length, Toast.LENGTH_SHORT).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.file_view, menu);
		return true;
	}

}
