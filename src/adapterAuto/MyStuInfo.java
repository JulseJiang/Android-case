package adapterAuto;

import java.util.HashMap;

import com.julse.adapter.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MyStuInfo extends Activity{
	private View view;
	private EditText edtNo,edtName,edtMajor,edtqur;
	private Button btn_cancel,btn_ok;
	
	MyStuInfo(HashMap map){
//		this.view=view;
		String info_name[]=new String[]{"No","Name","Major"};
//		int ids=new int[]{R.id.textNo,R.id.textName,R.id.textMajor};
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
}
