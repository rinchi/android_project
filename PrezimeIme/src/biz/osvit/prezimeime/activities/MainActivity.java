package biz.osvit.prezimeime.activities;

import biz.osvit.prezimeime.R;
import biz.osvit.prezimeime.utils.C;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	public EditText mInputName;
	public EditText mInputLastName;
	public EditText mInputAddress;
	public Button mSubmitButton;
	public Button mCancleButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initUi();
		initListeners();
	}

	private void initUi() {
		mInputName = (EditText) findViewById(R.id.activity_main_ime_edit_text);
		mInputLastName = (EditText) findViewById(R.id.activity_main_prezime_edit_text);
		mInputAddress = (EditText) findViewById(R.id.activity_main_edit_adresa);
		mSubmitButton = (Button) findViewById(R.id.activity_main_submit);
		mCancleButton = (Button) findViewById(R.id.activity_main_cancel);

	}

	private void initListeners() {
		mSubmitButton.setOnClickListener(mClickListener);
		mCancleButton.setOnClickListener(mClickListener);

	}

	public OnClickListener mClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case (R.id.activity_main_submit):
				String name = mInputName.getText().toString();
				String lastName = mInputLastName.getText().toString();
				String adresa = mInputAddress.getText().toString();
				startActivitySecond(name, lastName, adresa);
				break;
			case (R.id.activity_main_cancel):
				mInputName.setText("");
				mInputLastName.setText("");
				break;
			}

		}

	};

	private void startActivitySecond(String name, String lastName, String adresa) {
		Intent intent = new Intent(this, ActivitySecond.class);
		intent.putExtra(C.MAIN_ACTIVITIY_BUNDLE_KEY_IME, name);
		intent.putExtra(C.MAIN_ACTIVITIY_BUNDLE_KEY_PREZIME, lastName);
		intent.putExtra(C.MAIN_ACIVITY_BUNDLE_KEY_ADRESA, adresa);
		startActivity(intent);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
