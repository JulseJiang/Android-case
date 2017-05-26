package timeToLive;

import com.julse.adapter.R;
import com.julse.adapter.R.layout;
import com.julse.adapter.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class LifeActivity extends Activity {
	private static String TAG="Life";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_life);
		Log.i(TAG,"......................OnCreate is running............");
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.i(TAG,"......................onPause is running............");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i(TAG,"......................onResume is running............");
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.i(TAG,"......................onStart is running............");
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.i(TAG,"......................onStop is running............");
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i(TAG,"......................onDestroy is running............");
	}
}
