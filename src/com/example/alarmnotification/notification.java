package com.example.alarmnotification;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.Toast;

public class notification extends Activity implements OnClickListener {

	Button dismiss, snooze;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notificationlayout);
		dismiss = (Button) findViewById(R.id.dismiss);
		snooze = (Button) findViewById(R.id.snooze);
		dismiss.setOnClickListener(this);
		snooze.setOnClickListener(this);
	}

	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId() == R.id.dismiss) {
			Toast.makeText(getApplicationContext(), "Alarm Dismissed...!!!",
					Toast.LENGTH_SHORT).show();
			finish();
		}

		else if (v.getId() == R.id.snooze) {
			Toast.makeText(getApplicationContext(), "Alarm Snoozed...!!!",
					Toast.LENGTH_SHORT).show();
			NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
			Notification.Builder nb = new Notification.Builder(
					getApplicationContext());
			RemoteViews rv = new RemoteViews("com.example.alarmnotification",
					R.layout.messagelayout);
			rv.setTextViewText(R.id.tv, "Alarm Snoozed...!!!");
			rv.setImageViewResource(R.id.iv, R.drawable.qaz);
			Intent i = new Intent(getApplicationContext(), notification.class);
			PendingIntent pi = PendingIntent.getActivity(
					getApplicationContext(), 0, i, 0);
			
			Intent i2=new Intent(getApplicationContext(),MainActivity.class);
		//	i2.putExtra("x", true);
			PendingIntent pi2=PendingIntent.getActivity(getApplicationContext(), 0, i2, 0);

			nb.setContent(rv).setContentIntent(pi).setAutoCancel(true)
					.setSmallIcon(R.drawable.icon).setTicker("Alarm").setDeleteIntent(pi2);
			
			nm.notify(1, nb.build());
			finish();
		}
	}

}
