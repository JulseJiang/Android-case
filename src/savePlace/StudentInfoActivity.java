package savePlace;

import java.util.ArrayList;
import java.util.HashMap;

import com.julse.adapter.R;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class StudentInfoActivity extends Activity {
	private EditText edtNo,edtName,edtMajor,edtqur;
	private ListView listView;
	private Button btnInsert,btnqur;
	private ArrayList arrayList;
	private SimpleAdapter adapter;
	private int checkedId;
	private String message=null;
	
 	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.student_info);
		setTitle("simpleAdapter");
		
		edtName=(EditText) findViewById(R.id.editName);
		edtNo=(EditText) findViewById(R.id.editNo);
		edtMajor=(EditText) findViewById(R.id.editMajor);
		edtqur=(EditText) findViewById(R.id.editqur);
		listView=(ListView) findViewById(R.id.listView1);
		btnInsert=(Button) findViewById(R.id.btn_root);
		btnqur=(Button) findViewById(R.id.btn_public);
		
		
		arrayList = new ArrayList();
		
		adapter=new SimpleAdapter(StudentInfoActivity.this,
				arrayList,
				R.layout.item_stu,
				new String[]{"No","Name","Major"},
				new int[]{R.id.textNo,R.id.textName,R.id.textMajor});
		listView.setAdapter(adapter);
		
		listView.setOnItemLongClickListener(new OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				checkedId=arg2;
				// TODO Auto-generated method stub
//				arrayList.remove(arg2);
//				adapter.notifyDataSetChanged();
//				Toast.makeText(StudentInfoActivity.this, "长按删除", Toast.LENGTH_LONG).show();
				PopupMenu pm=new PopupMenu(StudentInfoActivity.this,listView);
				pm.getMenuInflater().inflate(R.menu.four_opr, pm.getMenu());
				pm.setOnMenuItemClickListener(new OnMenuItemClickListener() {
					
					@Override
					public boolean onMenuItemClick(MenuItem arg0) {
						
						switch (arg0.getItemId()) {
						case R.id.item1:
							arrayList.remove(checkedId);
							adapter.notifyDataSetChanged();
							message="删除成功";
							break;
						case R.id.item2:
							LayoutInflater inflater=LayoutInflater.from(StudentInfoActivity.this);
							View view=inflater.inflate(R.layout.change_stu_info, null);
//							EditText newNo=(EditText) view.findViewById(R.id.editNo);
//							EditText newName=(EditText) view.findViewById(R.id.editName);
//							EditText newMajor=(EditText) view.findViewById(R.id.editMajor);
							
							
							edtName=(EditText) view.findViewById(R.id.editName);
							edtNo=(EditText) view.findViewById(R.id.editNo);
							edtMajor=(EditText) view.findViewById(R.id.editMajor);
							
							
							AlertDialog.Builder builder = new AlertDialog.Builder(StudentInfoActivity.this);
							builder.setTitle("修改");
							builder.setView(view);
							builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
								
								@Override
								public void onClick(DialogInterface arg0, int arg1) {
									HashMap map=(HashMap) arrayList.get(checkedId);
									map.put("Name", edtName.getText().toString());
									map.put("No", edtNo.getText().toString());
									map.put("Major", edtMajor.getText().toString());
									arrayList.set(checkedId,map);
									adapter.notifyDataSetChanged();
									message="修改成功";
								}
							});
							builder.setNegativeButton("取消", null);
							builder.create().show();
							
							
							
//							arrayList.set(checkedId, object);
							message="修改成功";
							break;
						case R.id.item3:
							arrayList.add(arrayList.get(checkedId));
							adapter.notifyDataSetChanged();
							message="复制成功";
						}
						
						Toast.makeText(StudentInfoActivity.this, message, Toast.LENGTH_LONG).show();
						return false;
					}
				});
				pm.show();
				
				return false;
			}
		});
//		listView.setOnItemClickListener(new OnItemClickListener() {
//
//			@Override
//			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
//					long arg3) {
//				arrayList.add(arrayList.get(arg2));
//				adapter.notifyDataSetChanged();
//				Toast.makeText(StudentInfoActivity.this, "复制成功", Toast.LENGTH_LONG).show();
//			}
//			
//		});

		btnInsert.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String stuNo=edtNo.getText().toString();
				String stuName=edtName.getText().toString();
				String stuMajor=edtMajor.getText().toString();
//				TextUtils.isEmpty(stuNo):判断字符串是否为空
				if (TextUtils.isEmpty(stuNo)||TextUtils.isEmpty(stuName)||TextUtils.isEmpty(stuMajor)) {
					Toast.makeText(StudentInfoActivity.this, "不能出现空值", Toast.LENGTH_LONG).show();
				}
				else {
					HashMap map=new HashMap();
					map.put("No",stuNo);
					map.put("Name",stuName);
					map.put("Major",stuMajor);
					arrayList.add(map);
					
					adapter.notifyDataSetInvalidated();
					listView.setAdapter(adapter);
				}
			}
		});
		btnqur.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String qur=edtqur.getText().toString();
				
//				if (qur.isEmpty()) {
				if (TextUtils.isEmpty(qur)) {
					
					Toast.makeText(StudentInfoActivity.this, "查询语句不能为空", Toast.LENGTH_LONG).show();
				}
				else {
					ArrayList qur_array=new ArrayList();
					for (int i = 0; i < arrayList.size(); i++) {
						HashMap map=new HashMap();
						map=(HashMap)arrayList.get(i);
						String no=map.get("No").toString();
						String name=map.get("Name").toString();
						String major=map.get("Major").toString();
						if (no.equals(qur)||name.equals(qur)||major.equals(qur)) {
							qur_array.add(map);
						}
					}
					if (qur_array.isEmpty()) {
						Toast.makeText(StudentInfoActivity.this, "查无此人", Toast.LENGTH_LONG).show();
					}
					else {
						SimpleAdapter qur_adapter=new SimpleAdapter(StudentInfoActivity.this,
								qur_array,
								R.layout.item_stu,
								new String[]{"No","Name","Major"},
								new int[]{R.id.textNo,R.id.textName,R.id.textMajor});
						
						listView.setAdapter(qur_adapter);
					}
					
				}
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.student_info, menu);
		return true;
	}

}
