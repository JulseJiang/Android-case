package com.julse.adapter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OutStorageSaveActivity extends Activity {
	private Button btnRoot,btnPublic,btnPrivate;
	private EditText edtFileName,edtFileContent;
	private static String TAG="Life";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_out_storage_save);
		
		btnRoot=(Button) findViewById(R.id.btn_root);
		btnPublic=(Button) findViewById(R.id.btn_public);
		btnPrivate=(Button) findViewById(R.id.btn_private);
		edtFileName=(EditText) findViewById(R.id.editText1);
		edtFileContent=(EditText)findViewById(R.id.editText2);
		
		btnRoot.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
//				MEDIA_MOUNTED:判断当前外部存储区是否处于挂载状态
				if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
					String fileName=edtFileName.getText().toString();
					if (TextUtils.isEmpty(fileName)) {
						Toast.makeText(OutStorageSaveActivity.this, "文件名不能为空", Toast.LENGTH_SHORT).show();
						
					}
					else {
//						获取根目录路径
						String path=Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+fileName;
						try {
							FileOutputStream fos=new FileOutputStream(path);
							fos.write(edtFileContent.getText().toString().getBytes());
							fos.close();
							Toast.makeText(OutStorageSaveActivity.this, "根目录保存成功", Toast.LENGTH_SHORT).show();
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							Log.i(TAG,"......................没有找到文件............");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							Log.i(TAG,"......................写入异常............");
						}
					}
				}
				Log.i(TAG,"......................不处于挂载状态............");
			}
			
		});
		
		btnPublic.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
					String fileName=edtFileName.getText().toString();
					if (TextUtils.isEmpty(fileName)) {
						Toast.makeText(OutStorageSaveActivity.this, "文件名不能为空", Toast.LENGTH_SHORT).show();
					}
					else {
//						属于下载类
						File pubPath=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
//						如果不存在这个文件夹，就创建
						if (!pubPath.exists()) {
							pubPath.mkdir();
						}
						String path=pubPath.getAbsolutePath()+File.separator+fileName;
						try {
							FileOutputStream fos=new FileOutputStream(path);
							fos.write(edtFileContent.getText().toString().getBytes());
							fos.close();
							Toast.makeText(OutStorageSaveActivity.this, "公共文件保存成功", Toast.LENGTH_SHORT).show();
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				}
				
			}
		});
		btnPrivate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
					String fileName=edtFileName.getText().toString();
					if (TextUtils.isEmpty(fileName)) {
						Toast.makeText(OutStorageSaveActivity.this, "文件名不能为空", Toast.LENGTH_SHORT).show();
					}
					else {
//						获取私有的文件路径
						File path=getExternalFilesDir(Environment.DIRECTORY_DCIM);
						String strPath=path.getAbsolutePath()+File.separator+fileName;
						FileOutputStream fos;
						try {
							fos = new FileOutputStream(path);
							fos.write(edtFileContent.getText().toString().getBytes());
							fos.close();
							Toast.makeText(OutStorageSaveActivity.this, "私有文件保存成功", Toast.LENGTH_SHORT).show();
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				}
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.out_storage_save, menu);
		return true;
	}

}
