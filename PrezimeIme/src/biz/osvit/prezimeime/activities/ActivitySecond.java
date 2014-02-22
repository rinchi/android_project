package biz.osvit.prezimeime.activities;

import biz.osvit.prezimeime.R;
import biz.osvit.prezimeime.utils.C;
import android.os.Bundle;
import android.widget.TextView;

public class ActivitySecond extends ActivityBase {

	public TextView mShowName;
	public TextView mShowLastName;
	public String mName;
	public String mLastName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		initUi();
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			initExtras(extras);
		}
		setTitleView();
	}

	@Override
	public void initUi() {
		mShowName = (TextView) findViewById(R.id.activity_second_text_view_ime);
		mShowLastName = (TextView) findViewById(R.id.activity_second_text_view_prezime);

	}

	private void initExtras(Bundle extras) {
		mName = extras.getString(C.MAIN_ACTIVITIY_BUNDLE_KEY_IME);
		mLastName = extras.getString(C.MAIN_ACTIVITIY_BUNDLE_KEY_PREZIME);

	}

	private void setTitleView() {
		mShowName.setText(mName);
		mShowLastName.setText(mLastName);
	}

	@Override
	public void initListeners() {
		// TODO Auto-generated method stub

	}

}
