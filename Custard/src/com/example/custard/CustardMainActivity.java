package com.example.custard;



import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class CustardMainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);
		
		ImageView custardImage = (ImageView) findViewById(R.id.imageView1);
		Animation splashSpin = AnimationUtils.loadAnimation(this, R.anim.twirl_spin);
		custardImage.startAnimation(splashSpin);
		
		TextView splashText = (TextView) findViewById(R.id.splashTextView);
		Animation TradeMarkAlpha = AnimationUtils.loadAnimation(this, R.anim.fadein);
		splashText.startAnimation(TradeMarkAlpha);
		
		new Handler().postDelayed(new Thread(){
			@Override
			public void run(){
				
				Intent mainScreen = new Intent(CustardMainActivity.this, CustardMainScreenActivity.class);
				      CustardMainActivity.this.startActivity(mainScreen);
				      CustardMainActivity.this.finish();
				        
				      overridePendingTransition(R.anim.fadein, R.anim.fadeout);
			}
		},CustardKonstants.SplashScreenDelay);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getSupportActionBar().setBackgroundDrawable(new ColorDrawable(
				getResources().getColor(R.color.color_sun_flower)));
		getMenuInflater().inflate(R.menu.custard_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
