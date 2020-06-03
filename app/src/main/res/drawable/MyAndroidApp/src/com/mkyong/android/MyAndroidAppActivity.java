package com.mkyong.android;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;

public class MyAndroidAppActivity extends Activity {

	Button imageButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		addListenerOnButton();

	}

	public void addListenerOnButton() {

		imageButton = (Button) findViewById(R.id.imageButtonSelector);

		imageButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Toast.makeText(MyAndroidAppActivity.this,
						"ImageButton (selector) is clicked!",
						Toast.LENGTH_SHORT).show();

			}

		});

	}

}