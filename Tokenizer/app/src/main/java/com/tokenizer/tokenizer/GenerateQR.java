package com.tokenizer.tokenizer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class GenerateQR extends AppCompatActivity {

    public int counter = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_qr);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        final TextView tV = (TextView) findViewById(R.id.textView);
        new CountDownTimer(15000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tV.setText(String.valueOf(counter));
                counter -= 1;
            }

            @Override
            public void onFinish() {
                tV.setTextSize(40);
                tV.setText("QR Code has expired, please try again");
            }
        }.start();

    }
}
