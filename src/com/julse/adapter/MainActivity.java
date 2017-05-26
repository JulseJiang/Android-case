package com.julse.adapter;
/**
 * 四种Adapter适配器
 * ArrayAdapter：纯文字
 * SimpleAdapter：对数组或集合操作，包含多个控件时
 * SimpleCursorAdapter：对数据库进行操作，直接把游标作为数据源
 * 自定义Adapter：实现微博一样的复杂功能，点击不同控件，出现不同效果
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
        setTitle("自动补全");
        actv=(AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        spinner=(Spinner) findViewById(R.id.spinner1);
        
        String[] content={"no","nsu","neusoft"};
        ArrayAdapter adapter = new ArrayAdapter(this, 
        		android.R.layout.simple_dropdown_item_1line,
        		content);
        //R.layout.activity_list_item:系统内置的一种布局
        
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
