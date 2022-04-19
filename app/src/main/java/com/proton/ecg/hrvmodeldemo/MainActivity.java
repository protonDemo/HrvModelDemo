package com.proton.ecg.hrvmodeldemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.proton.ecg.hrvmodel.HrvModelHelper;
import com.proton.ecg.hrvmodel.bean.HrvModelOutput;
import com.proton.ecg.hrvmodel.calllback.HrvModelListener;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "----";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(android.R.id.content).setOnClickListener(v -> {
            test();
        });
    }

    private void test() {
        byte[] sourceData = new byte[1];
        HrvModelHelper.fetchHrvModelOutputResult(sourceData, 256, 18, 1, 200, 50, 0,
                110, 0, 170, 60, new HrvModelListener() {
                    @Override
                    public void onHrvModelOutput(HrvModelOutput hrvModelOutput) {
                        Log.d(TAG, "onHrvModelOutput: " + hrvModelOutput.toString());
                    }
                });
    }
}