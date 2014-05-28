package com.example.alarmnotification;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{
	
	Button bt1;
	//TextView status;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bt1=(Button)findViewById(R.id.bt1);
		/*status=(TextView)findViewById(R.id.des);
		Intent i=getIntent();
		Boolean value=i.getBooleanExtra("x", false);
		if(value) status.setText("Alarm snoozed and removed...!!!");*/
		bt1.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==R.id.bt1)
		{
			AlarmManager am=(AlarmManager)getSystemService(Context.ALARM_SERVICE);
			Intent i=new Intent(getApplicationContext(),notification.class);
			PendingIntent pi=PendingIntent.getActivity(getApplicationContext(), 0, i, 0);
			am.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, 10000, pi);
			
		}
		
	}

}
