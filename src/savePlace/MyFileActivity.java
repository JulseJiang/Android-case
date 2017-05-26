package savePlace;
/**
 * int read() 
 * �Ӵ��������ж�ȡһ�������ֽڡ� 
 * int read(byte[] b) 
 * �Ӵ��������н���� b.length ���ֽڵ����ݶ���һ�� byte �����С�
 * int read(byte[] b, int off, int len) 
 * �Ӵ��������н���� len ���ֽڵ����ݶ���һ�� byte �����С� ��ָ��λ�ö�ȡָ������
 * ����ʵ�ʶ�ȡ�ĳ���
 * 
 * StringBuffer��StringBuilder����ȣ�ͨ��Ӧ������ʹ�� StringBuilder �࣬
 * ��Ϊ��֧��������ͬ�Ĳ���������������ִ��ͬ���������ٶȸ��졣
 * �෴��StringBuffer���̰߳�ȫ��
 */


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.julse.adapter.R;
import com.julse.adapter.R.id;
import com.julse.adapter.R.layout;
import com.julse.adapter.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MyFileActivity extends Activity {
	private EditText edit_title;
	private EditText edit_content;
	private Button btn_read;
	private Button btn_write;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_file);
		setTitle("���±�");
		
		edit_title=(EditText) findViewById(R.id.edit_title);
		edit_content=(EditText) findViewById(R.id.edit_content);
		btn_read=(Button) findViewById(R.id.btn_read);
		btn_write=(Button) findViewById(R.id.btn_write);
		
		btn_read.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String file_title=edit_title.getText().toString();
				if (TextUtils.isEmpty(file_title)) {
					Toast.makeText(MyFileActivity.this, "�ļ�������Ϊ��", Toast.LENGTH_SHORT).show();
				}
				else {
					try {
						FileInputStream fis=openFileInput(file_title);
//						����һ��256���ȵ��ֽ����飬���ڴ洢
						byte[] buffer=new byte[256];
//						 �Ӵ��������ж�ȡһ�������ֽڡ�
						StringBuffer sb=new StringBuffer();
						try {
							while(fis.read(buffer)>=0){
								sb.append(new String(buffer));
							}
							edit_content.setText(sb);
							fis.close();
						} catch (IOException e) {
							Toast.makeText(MyFileActivity.this, "�ļ���ȡʧ��", Toast.LENGTH_SHORT).show();
							e.printStackTrace();
						}
						
					} catch (FileNotFoundException e) {
						Toast.makeText(MyFileActivity.this, "�ļ�������", Toast.LENGTH_SHORT).show();
						e.printStackTrace();
					}
					
				}
			}
		});
		btn_write.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String file_title=edit_title.getText().toString();
				if (TextUtils.isEmpty(file_title)) {
					Toast.makeText(MyFileActivity.this, "�ļ�������Ϊ��", Toast.LENGTH_SHORT).show();
				}
				else {
					
//						MODE_APPEND:ÿ��д��Ķ�����ԭ�е��ļ���������
						FileOutputStream fos;
						try {
							
							fos = openFileOutput(file_title,MODE_APPEND);
//							getBytes
							try {
								fos.write(edit_content.getText().toString().getBytes());
								fos.close();
								Toast.makeText(MyFileActivity.this, "����ɹ�", Toast.LENGTH_SHORT).show();
							} catch (IOException e) {
								Toast.makeText(MyFileActivity.this, "����ʧ��", Toast.LENGTH_SHORT).show();
								e.printStackTrace();
							}
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
				}
			
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_file, menu);
		return true;
	}

}
