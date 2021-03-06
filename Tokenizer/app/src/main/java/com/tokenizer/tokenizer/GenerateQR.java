package com.tokenizer.tokenizer;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import net.glxn.qrgen.android.QRCode;


public class GenerateQR extends AppCompatActivity {

    public int counter = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_qr);

        final ImageView imageView = (ImageView) findViewById(R.id.qrCodeView);
        imageView.setImageBitmap(QRCode.from("Hello World!").bitmap());
        final TextView tV = (TextView) findViewById(R.id.textView);
        new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tV.setText(String.valueOf(millisUntilFinished / 1000));
                counter -= 1;
            }

            @Override
            public void onFinish() {
                imageView.setImageResource(R.drawable.slowpoke);
                tV.setTextSize(40);
                tV.setTextColor(Color.RED);
                tV.setText("QR Code has expired, please try again");
            }
        }.start();

    }
}
