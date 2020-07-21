package com.example.android.materialme;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.content.res.ResourcesCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.Locale;

public class Confirmorder extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm);

        Intent intent = getIntent();


        String name = intent.getStringExtra(Address.EXTRA_MESSAGE);
        String address = intent.getStringExtra(Address.EXTRA_ADDRESS);
        String phone = intent.getStringExtra(Address.EXTRA_PHONE);
        String date = intent.getStringExtra(Address.EXTRA_DATE);
        String radiob = intent.getStringExtra(Address.EXTRA_RADIO);

        String choice = intent.getStringExtra(Address.EXTRA_CHOICES);
        String prices = intent.getStringExtra(Address.EXTRA_PRICES);
        String usd_price = intent.getStringExtra(Address.EXTRA_USD);

        TextView textView1 = (TextView) findViewById(R.id.name_message);
        TextView textView2 = (TextView) findViewById(R.id.address_message);
        TextView textView3 = (TextView) findViewById(R.id.phone_message);
        TextView textView4 = (TextView) findViewById(R.id.date_message);
        TextView textView5 = (TextView) findViewById(R.id.payment_message);
        TextView textView6 = (TextView) findViewById(R.id.orderDetailstextView2);
        TextView textView7 = (TextView) findViewById(R.id.showprice2);



        textView1.setText(name);
        textView2.setText(address);
        textView3.setText(phone);
        textView4.setText(date);
        textView5.setText(radiob);
        textView6.setText(choice);
        textView7.setText("Total : " + prices + " Baht\n" + "USD : " + Integer.parseInt(prices)/33 +" $");

        ///////////////////////////////////////////////////////////////////////
        ///////////
        //////  ส่งค่า ราคาและสินค้า

        /*Bundle bundle1 = getIntent().getExtras();
        String data = bundle1.getString("choice_iteams");
        bdt_price = bundle1.getString("bdt_price");
        usd_price = bundle1.getString("usd_price");


        ordered__list = findViewById(R.id.orderDetailstextView2);


        show_price_view = findViewById(R.id.showprice2);
        show_price_view.setText("Total : " + bdt_price + " Baht\n" + "USD : " + usd_price + " $");

        ordered__list.setText(data);*/











    }

    public void go_lastpage(View view) {
        Intent intent = new Intent(Confirmorder.this, image.class);
        startActivity(intent);

    }
}
