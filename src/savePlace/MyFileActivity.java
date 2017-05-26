package savePlace;
/**
 * int read() 
 * 从此输入流中读取一个数据字节。 
 * int read(byte[] b) 
 * 从此输入流中将最多 b.length 个字节的数据读入一个 byte 数组中。
 * int read(byte[] b, int off, int len) 
 * 从此输入流中将最多 len 个字节的数据读入一个 byte 数组中。 从指定位置读取指定长度
 * 返回实际读取的长度
 * 
 * StringBuffer与StringBuilder类相比，通常应该优先使用 StringBuilder 类，
 * 因为它支持所有相同的操作，但由于它不执行同步，所以速度更快。
 * 相反，StringBuffer是线程安全的
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
		setTitle("记事本");
		
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
					Toast.makeText(MyFileActivity.this, "文件名不能为空", Toast.LENGTH_SHORT).show();
				}
				else {
					try {
						FileInputStream fis=openFileInput(file_title);
//						定义一个256长度的字节数组，用于存储
						byte[] buffer=new byte[256];
//						 从此输入流中读取一个数据字节。
						StringBuffer sb=new StringBuffer();
						try {
							while(fis.read(buffer)>=0){
								sb.append(new String(buffer));
							}
							edit_content.setText(sb);
							fis.close();
						} catch (IOException e) {
							Toast.makeText(MyFileActivity.this, "文件读取失败", Toast.LENGTH_SHORT).show();
							e.printStackTrace();
						}
						
					} catch (FileNotFoundException e) {
						Toast.makeText(MyFileActivity.this, "文件不存在", Toast.LENGTH_SHORT).show();
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
					Toast.makeText(MyFileActivity.this, "文件名不能为空", Toast.LENGTH_SHORT).show();
				}
				else {
					
//						MODE_APPEND:每次写入的东西在原有的文件上面增加
						FileOutputStream fos;
						try {
							
							fos = openFileOutput(file_title,MODE_APPEND);
//							getBytes
							try {
								fos.write(edit_content.getText().toString().getBytes());
								fos.close();
								Toast.makeText(MyFileActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
							} catch (IOException e) {
								Toast.makeText(MyFileActivity.this, "保存失败", Toast.LENGTH_SHORT).show();
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
