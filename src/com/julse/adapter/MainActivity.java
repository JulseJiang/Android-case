package com.julse.adapter;
/**
 * ����Adapter������
 * ArrayAdapter��������
 * SimpleAdapter��������򼯺ϲ�������������ؼ�ʱ
 * SimpleCursorAdapter�������ݿ���в�����ֱ�Ӱ��α���Ϊ����Դ
 * �Զ���Adapter��ʵ��΢��һ���ĸ��ӹ��ܣ������ͬ�ؼ������ֲ�ͬЧ��
 */
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class MainActivity extends Activity {
	private AutoCompleteTextView actv;
	private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("�Զ���ȫ");
        actv=(AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        spinner=(Spinner) findViewById(R.id.spinner1);
        
        String[] content={"no","nsu","neusoft"};
        ArrayAdapter adapter = new ArrayAdapter(this, 
        		android.R.layout.simple_dropdown_item_1line,
        		content);
        //R.layout.activity_list_item:ϵͳ���õ�һ�ֲ���
        
        actv.setAdapter(adapter);
        actv.setThreshold(0);
        

        
        spinner.setAdapter(adapter);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
