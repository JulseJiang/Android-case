package adapterAuto;
import java.util.ArrayList;
import java.util.HashMap;
import com.julse.adapter.R;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
//    �������Ƿ���listview������ͨ��

public class MyAdapter extends BaseAdapter {
	private ArrayList list;
	private Context context;
	private int layout;
	private ViewHolder holder;
	
	class ViewHolder{
		ImageView photo;
		TextView text_name;
		TextView text_content;
		TextView text_Forward;
		TextView text_Comment;
	}
	public MyAdapter(Context context,ArrayList list,int layout) {
		this.list=list;
		this.context=context;
		this.layout=layout;
	}
//	������������listview��item����
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}
//	arg0:��ȡ��ǰ��Ŷ�Ӧ������
	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}
//	��ȡ��ǰ���
	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}
//	��ȡÿ���б��������
	@Override
	public View getView(final int i, View convertView, ViewGroup arg2) {
		if (convertView==null) {
//			תxmlΪview
			LayoutInflater inflater= LayoutInflater.from(context);
//			layout:������ǲ����ļ���id
			convertView = inflater.inflate(layout, null);
			holder=new ViewHolder();
			holder.photo=(ImageView) convertView.findViewById(R.id.image_head);
			holder.text_name=(TextView) convertView.findViewById(R.id.text_name);
			holder.text_content=(TextView) convertView.findViewById(R.id.text_content);
			holder.text_Forward=(TextView) convertView.findViewById(R.id.text_sent);
			holder.text_Comment=(TextView) convertView.findViewById(R.id.text_review);
			
			convertView.setTag(holder);
//			convertView=view;
		}
		else {
			holder=(ViewHolder) convertView.getTag();
		}
		HashMap map=(HashMap)list.get(i);
//		�Ż�ǰ�����Ҵ����Ƚ϶�
//		ImageView photo=(ImageView) convertView.findViewById(R.id.image_head);
//		TextView text_name=(TextView) convertView.findViewById(R.id.text_name);
//		TextView text_content=(TextView) convertView.findViewById(R.id.text_content);
//		TextView text_Forward=(TextView) convertView.findViewById(R.id.text_sent);
//		TextView text_Comment=(TextView) convertView.findViewById(R.id.text_review);
		
		holder.text_name.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Toast.makeText(context, "��"+i+"����������", Toast.LENGTH_SHORT).show();
			}
		});
		holder.photo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Toast.makeText(context, "��"+i+"ͷ�񱻵���", Toast.LENGTH_SHORT).show();
			}
		});
		holder.text_Comment.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Toast.makeText(context, "��"+i+"���۱�����", Toast.LENGTH_SHORT).show();
			}
		});
		holder.text_Forward.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
//				Toast.makeText(context, "��"+i+"����ת��", Toast.LENGTH_SHORT).show();
				AlertDialog.Builder builder=new AlertDialog.Builder(context);
				builder.setTitle("��ʾ��");
				builder.setIcon(android.R.drawable.alert_light_frame);
				builder.setMessage("ȷ��Ҫת��ô��");
				builder.setPositiveButton("ȷ��", null);
				builder.setNegativeButton("ȡ��", null);
				builder.create().show();
			}
		});
		holder.photo.setImageResource((Integer)map.get("head"));
		holder.text_name.setText(map.get("name").toString());
		holder.text_content.setText(map.get("message").toString());
		
		return convertView;
	}

}
