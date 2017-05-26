package webviewtest;

import com.julse.adapter.R;
import com.julse.adapter.R.layout;
import com.julse.adapter.R.menu;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends Activity {
	
	private WebView webView;
	private Handler handler=new Handler();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_view);
		webView=(WebView) findViewById(R.id.webView1);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.setWebViewClient(new WebViewClient(){
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				super.shouldOverrideUrlLoading(view, url);
				return true;
			}
		});
		webView.loadUrl("/storage/sdcard/html/login.html");
//		new HttpThread("http://www.baidu.com", webView, handler).start();
//		new LoginThread("/storage/sdcard/html/login.html", webView, handler).start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.web_view, menu);
		return true;
	}

}
