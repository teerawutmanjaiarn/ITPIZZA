/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.materialme;

import android.support.v4.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * This activity handles radio buttons for choosing a delivery method for an
 * order, and EditText input controls.
 */
public class Address extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private static final String LOG_TAG = Address.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.android.materialme.extra.MESSAGE";
    public static final String EXTRA_ADDRESS = "com.example.android.materialme.extra.ADDRESS";
    public static final String EXTRA_PHONE = "com.example.android.materialme.extra.PHONE";
    public static final String EXTRA_DATE = "com.example.android.materialme.extra.DATE";
    public static final String EXTRA_RADIO = "com.example.android.materialme.extra.RADIO";

    public static final String EXTRA_CHOICES = "com.example.android.materialme.extra.CHOICES";
    public static final String EXTRA_PRICES = "com.example.android.materialme.extra.PRICES";
    public static final String EXTRA_USD = "com.example.android.materialme.extra.USD";

    String price ;
    String choice,prices,usd_price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);


        showdata1 = (TextView) findViewById((R.id.Showdata));
        Spinner spinner = findViewById(R.id.label_spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }

        ////////////////////////////////////////////////////////////////////////
        ////////////
        ///  ส่งค่าจาก address
        Button button = (Button) findViewById(R.id.confirm_address);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        ///////////////////////////////////////////////////////////////////////
        ///////////
        //////  ส่งค่า ราคาและสินค้า
        Intent i = getIntent();
        choice = i.getStringExtra(OrderActivity.EXTRA_CHOICES);
        prices = i.getStringExtra(OrderActivity.EXTRA_PRICES);
        usd_price = i.getStringExtra(OrderActivity.EXTRA_USD);


    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////   เรียกใช้ method ในการส่งค่า address
    public void openActivity2(){
        //text
        EditText mMessageEditText = findViewById(R.id.name_text);
        String name = mMessageEditText.getText().toString();

        EditText mMessageAddressText = findViewById(R.id.address_text);
        String address = mMessageAddressText.getText().toString();

        EditText mMessagePhoneText = findViewById(R.id.phone_text);
        String phone = mMessagePhoneText.getText().toString();

        EditText mMessageDateText = findViewById(R.id.Showdata);
        String date = mMessageDateText.getText().toString();
        //Radio
        RadioGroup radioGroup = findViewById(R.id.radioGroup2);
        int radioId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(radioId);
        String radiob = (String) radioButton.getText();




        Intent intent = new Intent(this, Confirmorder.class);

        intent.putExtra(EXTRA_CHOICES, choice);
        intent.putExtra(EXTRA_PRICES, prices);
        intent.putExtra(EXTRA_USD, usd_price);


        intent.putExtra(EXTRA_MESSAGE, name);
        intent.putExtra(EXTRA_ADDRESS, address);
        intent.putExtra(EXTRA_PHONE, phone);
        intent.putExtra(EXTRA_DATE, date);
        intent.putExtra(EXTRA_RADIO, radiob);
        startActivity(intent);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked.
        switch (view.getId()) {
            case R.id.sameday:
                if (checked)
                    // Same day service
                    displayToast(getString(R.string.same_day_messenger_service));
                break;
            case R.id.nextday:
                if (checked)
                    // Next day delivery
                    displayToast(getString(R.string.next_day_ground_delivery));
                break;
            case R.id.pickup:
                if (checked)
                    // Pick up
                    displayToast(getString(R.string.pick_up));
                break;
            default:
                // Do nothing.
                break;
        }
    }

    /**
     * Displays the actual message in a toast message.
     *
     * @param message Message to display.
     */
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),getString(R.string.datepicker));
    }

    TextView showdata1;

    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year+543);
        String dateMessage = (day_string + "/" + month_string + "/" + year_string);
        showdata1.setText(dateMessage);

        Toast.makeText(this, "Date: " + dateMessage,
                Toast.LENGTH_SHORT).show();
    }




}
