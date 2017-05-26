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
//				MEDIA_MOUNTED:�жϵ�ǰ�ⲿ�洢���Ƿ��ڹ���״̬
				if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
					String fileName=edtFileName.getText().toString();
					if (TextUtils.isEmpty(fileName)) {
						Toast.makeText(OutStorageSaveActivity.this, "�ļ�������Ϊ��", Toast.LENGTH_SHORT).show();
						
					}
					else {
//						��ȡ��Ŀ¼·��
						String path=Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+fileName;
						try {
							FileOutputStream fos=new FileOutputStream(path);
							fos.write(edtFileContent.getText().toString().getBytes());
							fos.close();
							Toast.makeText(OutStorageSaveActivity.this, "��Ŀ¼����ɹ�", Toast.LENGTH_SHORT).show();
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							Log.i(TAG,"......................û���ҵ��ļ�............");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							Log.i(TAG,"......................д���쳣............");
						}
					}
				}
				Log.i(TAG,"......................�����ڹ���״̬............");
			}
			
		});
		
		btnPublic.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
					String fileName=edtFileName.getText().toString();
					if (TextUtils.isEmpty(fileName)) {
						Toast.makeText(OutStorageSaveActivity.this, "�ļ�������Ϊ��", Toast.LENGTH_SHORT).show();
					}
					else {
//						����������
						File pubPath=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
//						�������������ļ��У��ʹ���
						if (!pubPath.exists()) {
							pubPath.mkdir();
						}
						String path=pubPath.getAbsolutePath()+File.separator+fileName;
						try {
							FileOutputStream fos=new FileOutputStream(path);
							fos.write(edtFileContent.getText().toString().getBytes());
							fos.close();
							Toast.makeText(OutStorageSaveActivity.this, "�����ļ�����ɹ�", Toast.LENGTH_SHORT).show();
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
						Toast.makeText(OutStorageSaveActivity.this, "�ļ�������Ϊ��", Toast.LENGTH_SHORT).show();
					}
					else {
//						��ȡ˽�е��ļ�·��
						File path=getExternalFilesDir(Environment.DIRECTORY_DCIM);
						String strPath=path.getAbsolutePath()+File.separator+fileName;
						FileOutputStream fos;
						try {
							fos = new FileOutputStream(path);
							fos.write(edtFileContent.getText().toString().getBytes());
							fos.close();
							Toast.makeText(OutStorageSaveActivity.this, "˽���ļ�����ɹ�", Toast.LENGTH_SHORT).show();
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
