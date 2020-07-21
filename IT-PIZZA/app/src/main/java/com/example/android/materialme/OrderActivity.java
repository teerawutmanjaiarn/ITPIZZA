package com.example.android.materialme;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.materialme.R;

import java.util.Timer;
import java.util.TimerTask;

public class OrderActivity extends Activity {
    public static final String EXTRA_CHOICES = "com.example.android.materialme.extra.CHOICES";
    public static final String EXTRA_PRICES = "com.example.android.materialme.extra.PRICES";
    public static final String EXTRA_USD = "com.example.android.materialme.extra.USD";




    TextView menu, tomyumkungname, chickenname, Meatname, Shrimpname, Hawaiianname, Veggiename, Double_Pepperoniname;  // namemenu
    TextView tomyumkungpice, chickenprice, Meatprice, Shrimpprice, Hawaiianprice, Veggieprice, Double_Pepperoniprice;   // pricemenu
    String choices = "";
    String prices, usd_price_string;
    double usd_price = 0;
    Button  tomyumkung, chicken, Meat, Shrimp, Hawaiian, Veggie, Double_Pepperoni;  //name add button

    //removing button

    Button  order, rm_tomyumkung, rm_chicken, rm_Meat, rm_Shrimp, rm_Hawaiian, rm_Veggie, rm_Double_Pepperoni;   //name removebutton

    int count_chicken = 0,  count_tomyumkung = 0, count_Meat = 0, count_Shrimp = 0, count_Hawaiian =0, count_Veggie =0, count_Double_Pepperoni = 0;   // count product
    int total_chicken = 0,  total_tomyumkung = 0, total_Meat =0, total_Shrimp =0, total_Hawaiian =0, total_Veggie =0, total_Double_Pepperoni =0;  //ราคารวมของสินค้านั้น
    int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        menu = findViewById(R.id.menuTv);
        Meatname = findViewById(R.id.Meat_textView);
        chickenname = findViewById(R.id.chicken_textView);
        Shrimpname = findViewById(R.id.Shrimp_textView);
        Hawaiianname = findViewById(R.id.Hawaiian_textView);
        Veggiename = findViewById(R.id.Veggie_textView);
        Double_Pepperoniname = findViewById(R.id.Double_Pepperoni_textView);
        tomyumkungname = findViewById(R.id.tomyumkung_textView);
//button of iteams add

        chicken = (Button) findViewById(R.id.chicken_button);
        Meat = (Button) findViewById(R.id.Meat_button);
        Shrimp = (Button) findViewById(R.id.Shrimp_button);
        Hawaiian = (Button) findViewById(R.id.Hawaiian_button);
        Veggie = (Button) findViewById(R.id.Veggie_button);
        Double_Pepperoni = (Button) findViewById(R.id.Double_Pepperoni_button);
        tomyumkung = (Button) findViewById(R.id.tomyumkung_button);
        // removing button identifing

        rm_chicken = (Button) findViewById(R.id.chicken_button_rm);
        rm_Meat = (Button) findViewById(R.id.Meat_button_rm);
        rm_Shrimp = (Button) findViewById(R.id.Shrimp_button_rm);
        rm_Veggie = (Button) findViewById(R.id.Veggie_button_rm);
        rm_Hawaiian = (Button) findViewById(R.id.Hawaiian_button_rm);
        rm_Double_Pepperoni = (Button) findViewById(R.id.Double_Pepperoni_button_rm);
        rm_tomyumkung = (Button) findViewById(R.id.tomyumkung_button_rm);

        /// order Button

        order = (Button) findViewById(R.id.order_button);


        Meatprice = findViewById(R.id.Meat_price);
        chickenprice = findViewById(R.id.chicken_price);
        Shrimpprice = findViewById(R.id.Shrim_price);
        Hawaiianprice = findViewById(R.id.Hawaiian_price);
        Veggieprice = findViewById(R.id.Veggie_price);
        Double_Pepperoniprice = findViewById(R.id.Double_Pepperoni_price);
        tomyumkungpice = findViewById(R.id.tomyumkung_price);

        Typeface french_font = ResourcesCompat.getFont(this, R.font.french);
        Typeface gatholic = ResourcesCompat.getFont(this, R.font.gatholic);

        menu.setTypeface(french_font);


        tomyumkung.setTypeface(french_font);
        chickenname.setTypeface(french_font);
        Meatname.setTypeface(french_font);
        Shrimpname.setTypeface(french_font);
        Hawaiian.setTypeface(french_font);
        Veggie.setTypeface(french_font);
        Double_Pepperoni.setTypeface(french_font);



        tomyumkung.setTypeface(gatholic);
        chickenprice.setTypeface(gatholic);
        Meatprice.setTypeface(gatholic);
        Shrimpprice.setTypeface(gatholic);
        Hawaiian.setTypeface(gatholic);
        Veggie.setTypeface(gatholic);
        Double_Pepperoni.setTypeface(gatholic);
        // setting order button font

        order.setTypeface(gatholic);


         ////////////////////////////////////////////////////////////////
        ////////////////////  เงื่อนไขถ้าค่าว่าง

        if(savedInstanceState != null) {
            count_chicken = savedInstanceState.getInt("c_c");
            chicken.setText(String.valueOf(count_chicken));

            count_tomyumkung = savedInstanceState.getInt("c_t");
            tomyumkung.setText(String.valueOf(count_tomyumkung));

            count_Meat = savedInstanceState.getInt("c_m");
            Meat.setText(String.valueOf(count_Meat));

            count_Shrimp = savedInstanceState.getInt("c_s");
            Shrimp.setText(String.valueOf(count_Shrimp));

            count_Hawaiian = savedInstanceState.getInt("c_h");
            Hawaiian.setText(String.valueOf(count_Hawaiian));

            count_Veggie = savedInstanceState.getInt("c_v");
            Veggie.setText(String.valueOf(count_Veggie));

            count_Double_Pepperoni = savedInstanceState.getInt("c_dp");
            Double_Pepperoni.setText(String.valueOf(count_Double_Pepperoni));
        }

    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////
    //////   get value chang   Landscape
    @Override
    protected void onSaveInstanceState( Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("c_c", count_chicken);
        outState.putInt("c_t", count_tomyumkung);
        outState.putInt("c_m", count_Meat);
        outState.putInt("c_s", count_Shrimp);
        outState.putInt("c_h", count_Hawaiian);
        outState.putInt("c_v", count_Veggie);
        outState.putInt("c_dp", count_Double_Pepperoni);
    }

    @Override
    protected void onRestoreInstanceState( Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        savedInstanceState.getInt("c_c");
        savedInstanceState.getInt("c_t");
        savedInstanceState.getInt("c_m");
        savedInstanceState.getInt("c_s");
        savedInstanceState.getInt("c_h");
        savedInstanceState.getInt("c_v");
        savedInstanceState.getInt("c_dp");

    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void add_to_list(View view) {
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //SharedPreferences.Editor editor = prefs.edit();


        if (view == findViewById(R.id.Meat_button)) {
            Toast.makeText(this, "Meat Duluxe Added", Toast.LENGTH_SHORT).show();
            count_Meat = count_Meat + 1;

            //choices = (choices+"\nHaleem\t (1) Bowl.").toString();

            Meat.setText(Integer.toString(count_Meat));

        } else if (view == findViewById(R.id.chicken_button)) {
            Toast.makeText(this, "Chicken Trio Added", Toast.LENGTH_SHORT).show();
            // = (choices+"\nBiriyani\t (1) plate.").toString();
            count_chicken = count_chicken + 1;

            chicken.setText(Integer.toString(count_chicken));

        } else if (view == findViewById(R.id.Shrimp_button)) {
            Toast.makeText(this, "Shirmp Cocktail Added", Toast.LENGTH_SHORT).show();
            //choices = (choices+"\nTikkas\t (1) pieces.").toString();
            count_Shrimp= count_Shrimp + 1;
            Shrimp.setText(Integer.toString(count_Shrimp));

        } else if (view == findViewById(R.id.Hawaiian_button)) {
            Toast.makeText(this, "Hawaiian Added", Toast.LENGTH_SHORT).show();
            //choices = (choices+"\nBiriyani\t (1) plate.").toString();
            count_Hawaiian = count_Hawaiian + 1;

            Hawaiian.setText(Integer.toString(count_Hawaiian));
        } else if (view == findViewById(R.id.Veggie_button)) {
            Toast.makeText(this, "Veggie Added", Toast.LENGTH_SHORT).show();
            //choices = (choices+"\nTikkas\t (1) pieces.").toString();
            count_Veggie = count_Veggie + 1;

            Veggie.setText(Integer.toString(count_Veggie));
        } else if (view == findViewById(R.id.Double_Pepperoni_button)) {
            Toast.makeText(this, "Double_Pepperoni Added", Toast.LENGTH_SHORT).show();
            // choices = (choices+"\nTikkas\t (1) pieces.").toString();

            count_Double_Pepperoni = count_Double_Pepperoni + 1;

            Double_Pepperoni.setText(Integer.toString(count_Double_Pepperoni));
        }  else if (view == findViewById(R.id.tomyumkung_button)) {
        Toast.makeText(this, "tomyumkung Added", Toast.LENGTH_SHORT).show();
        // choices = (choices+"\nTikkas\t (1) pieces.").toString();

            count_tomyumkung = count_tomyumkung + 1;

            tomyumkung.setText(Integer.toString(count_tomyumkung));
    }



    }
    public void place_order(View view) {

        balancesheet();
        Intent i = new Intent(OrderActivity.this, orderDetails.class);
        Bundle bundle = new Bundle();
        bundle.putString("choice_iteams", choices);
        bundle.putString("bdt_price", prices);
        bundle.putString("usd_price", usd_price_string);
        ///////
        i.putExtra(EXTRA_CHOICES, choices);
        i.putExtra(EXTRA_PRICES, prices);
        i.putExtra(EXTRA_USD, usd_price_string);
        ///////
        i.putExtras(bundle);
        startActivity(i);
        choices = "";


    }




    public void balancesheet() {
        total_chicken = count_chicken * 279;
        total_Meat = count_Meat * 319;
        total_Shrimp = count_Shrimp * 319;
        total_Hawaiian = count_Hawaiian * 279;
        total_Veggie = count_Veggie * 319;
        total_Double_Pepperoni = count_Double_Pepperoni * 279;
        total_tomyumkung = count_tomyumkung *319;

        total = total_chicken + total_tomyumkung + total_Meat+ total_Shrimp + total_Hawaiian + total_Veggie + total_Double_Pepperoni;
        usd_price = total / 33;  // แปลงเงิน
        prices = Integer.toString(total);
        usd_price_string = Double.toString(usd_price);


        if (count_chicken > 0) {
            choices = choices + "\n\nChicken Trio    (" + count_chicken + " x 279) = " + total_chicken+"Baht";

        }

        if (count_Double_Pepperoni > 0) {
            choices = choices + "\n\nDouble Pepperoni(" + count_Double_Pepperoni + " x 279) = " + total_Double_Pepperoni+"Baht";
        }

        if (count_Veggie > 0) {
            choices = choices + "\n\nVeggie          (" + count_Veggie + " x 319) = " + total_Veggie+"Baht";
        }

        if (count_Shrimp > 0) {
            choices = choices + "\n\nShrimp Cocktail (" + count_Shrimp + " x 319) = " + total_Shrimp+"Baht";
        }
        if (count_Meat > 0) {
            choices = choices + "\n\nMeat Duluxe     (" + count_Meat + " x 319) = " + total_Meat+"Baht";
        }

        if (count_Hawaiian > 0) {
            choices = choices + "\n\nHawaiian        (" + count_Hawaiian + " x 279) = " + total_Hawaiian+"Baht";
        }
        if (count_tomyumkung > 0) {
            choices = choices + "\n\nTomyumkung      (" + count_tomyumkung + " x 319) = " + total_tomyumkung+"Baht";
        }

    }
    public void rmv_from_list(View view) {  // remove
    if (view == findViewById(R.id.Meat_button_rm)) {
        if (count_Meat > 0) {

            count_Meat = count_Meat - 1;
            Meat.setText(Integer.toString(count_Meat));
            Toast.makeText(this, "Meat Duluxe Removed", Toast.LENGTH_SHORT).show();
        }


        //choices = (choices+"\nHaleem\t (1) Bowl.").toString();

    } else if (view == findViewById(R.id.chicken_button_rm)) {

        // = (choices+"\nBiriyani\t (1) plate.").toString();
        if (count_chicken > 0) {
            count_chicken = count_chicken - 1;

            chicken.setText(Integer.toString(count_chicken));
            Toast.makeText(this, "Chicken Trio Removed", Toast.LENGTH_SHORT).show();
        }


    } else if (view == findViewById(R.id.Shrimp_button_rm)) {

        //choices = (choices+"\nTikkas\t (1) pieces.").toString();

        if (count_Shrimp > 0) {

            count_Shrimp = count_Shrimp - 1;
            Shrimp.setText(Integer.toString(count_Shrimp));
            Toast.makeText(this, "Shrimp Cocktail Removed", Toast.LENGTH_SHORT).show();
        }


    } else if (view == findViewById(R.id.Hawaiian_button_rm)) {

        //choices = (choices+"\nBiriyani\t (1) plate.").toString();
        if (count_Hawaiian > 0) {

            count_Hawaiian = count_Hawaiian - 1;
            Hawaiian.setText(Integer.toString(count_Hawaiian));
            Toast.makeText(this, "Hawaiian Removed", Toast.LENGTH_SHORT).show();
        }



    } else if (view == findViewById(R.id.Veggie_button_rm)) {

        //choices = (choices+"\nTikkas\t (1) pieces.").toString();
        if (count_Veggie > 0) {

            count_Veggie = count_Veggie - 1;
            Veggie.setText(Integer.toString(count_Veggie));
            Toast.makeText(this, "Veggie Removed", Toast.LENGTH_SHORT).show();
        }



    } else if (view == findViewById(R.id.Double_Pepperoni_button_rm)) {

        // choices = (choices+"\nTikkas\t (1) pieces.").toString();
        if (count_Double_Pepperoni > 0) {
            count_Double_Pepperoni = count_Double_Pepperoni - 1;
            Double_Pepperoni.setText(Integer.toString(count_Double_Pepperoni));
            Toast.makeText(this, "Double Pepperoni Removed", Toast.LENGTH_SHORT).show();
        }



    }   else if (view == findViewById(R.id.tomyumkung_button_rm)) {

        // choices = (choices+"\nTikkas\t (1) pieces.").toString();
        if (count_tomyumkung > 0) {
            count_tomyumkung = count_tomyumkung - 1;
            tomyumkung.setText(Integer.toString(count_tomyumkung));
            Toast.makeText(this, "tomyumkung Removed", Toast.LENGTH_SHORT).show();
        }



    }

}





}
