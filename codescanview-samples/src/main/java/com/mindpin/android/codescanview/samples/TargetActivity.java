package com.mindpin.android.codescanview.samples;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by dd on 14-6-26.
 */
public class TargetActivity extends Activity {
    String result;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);
        result = getIntent().getStringExtra("result");
        TextView tv_result = (TextView) findViewById(R.id.tv_result);
        tv_result.setText(result);
    }
}