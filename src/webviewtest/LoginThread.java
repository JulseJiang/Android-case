package webviewtest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.julse.adapter.R;

import android.os.Handler;
import android.webkit.WebView;

public class LoginThread extends Thread{
	private String url;
	private WebView webView;
	private Handler handler;
	private StringBuffer sb;
	
	public   LoginThread(String url,WebView webView,Handler handler) {
		this.url=url;
		this.webView=webView;
		this.handler=handler;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
	
			
			handler.post(new Runnable() {
				
				@Override
				public void run() {
//					webView.loadData(sb.toString(), "text/html;charset=utf-8", null);
					webView.loadUrl("/storage/sdcard/html/login.html");
				}
			});
	}
}
