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
//    适配器是访问listview的数据通道

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
//	返回条数即是listview的item条数
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}
//	arg0:获取当前序号对应的内容
	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}
//	获取当前序号
	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}
//	获取每个列表项的内容
	@Override
	public View getView(final int i, View convertView, ViewGroup arg2) {
		if (convertView==null) {
//			转xml为view
			LayoutInflater inflater= LayoutInflater.from(context);
//			layout:传入的是布局文件的id
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
//		优化前，查找次数比较多
//		ImageView photo=(ImageView) convertView.findViewById(R.id.image_head);
//		TextView text_name=(TextView) convertView.findViewById(R.id.text_name);
//		TextView text_content=(TextView) convertView.findViewById(R.id.text_content);
//		TextView text_Forward=(TextView) convertView.findViewById(R.id.text_sent);
//		TextView text_Comment=(TextView) convertView.findViewById(R.id.text_review);
		
		holder.text_name.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Toast.makeText(context, "第"+i+"姓名被点中", Toast.LENGTH_SHORT).show();
			}
		});
		holder.photo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Toast.makeText(context, "第"+i+"头像被点中", Toast.LENGTH_SHORT).show();
			}
		});
		holder.text_Comment.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Toast.makeText(context, "第"+i+"评论被点中", Toast.LENGTH_SHORT).show();
			}
		});
		holder.text_Forward.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
//				Toast.makeText(context, "第"+i+"正在转发", Toast.LENGTH_SHORT).show();
				AlertDialog.Builder builder=new AlertDialog.Builder(context);
				builder.setTitle("提示：");
				builder.setIcon(android.R.drawable.alert_light_frame);
				builder.setMessage("确认要转发么？");
				builder.setPositiveButton("确认", null);
				builder.setNegativeButton("取消", null);
				builder.create().show();
			}
		});
		holder.photo.setImageResource((Integer)map.get("head"));
		holder.text_name.setText(map.get("name").toString());
		holder.text_content.setText(map.get("message").toString());
		
		return convertView;
	}

}
