package com.acme.a3csci3130;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class DetailViewActivity extends Activity {

    private EditText businessNumber, businessName, businessAddress;
    private Spinner businessType, provinceOrTerritoryName;
    Business receivedBusinessInfo;
    private MyApplicationData appState;
    private String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedBusinessInfo = (Business)getIntent().getSerializableExtra("Business");
        key = receivedBusinessInfo.uid;
        appState = ((MyApplicationData) getApplicationContext());
        businessNumber = (EditText) findViewById(R.id.businessNumber);
        businessName = (EditText) findViewById(R.id.businessName);
        businessType = (Spinner) findViewById(R.id.businessType);
        businessAddress = (EditText) findViewById(R.id.address);
        provinceOrTerritoryName = (Spinner) findViewById(R.id.provinceOrTerritoryName);

        if(receivedBusinessInfo != null){
            businessNumber.setText(receivedBusinessInfo.businessNumber);
            businessName.setText(receivedBusinessInfo.businessName);
            businessAddress.setText(receivedBusinessInfo.provinceOrTerritoryName);
        }
    }

    public void updateBusiness(View v){
        //updates firebase then returns to main page
        String uid = key;
        String number = businessNumber.getText().toString();
        String name = businessName.getText().toString();
        String type = businessType.getSelectedItem().toString();
        String address = businessAddress.getText().toString();
        String provinceOrTerritory = provinceOrTerritoryName.getSelectedItem().toString();
        Business business = new Business(uid, number, name, type, address, provinceOrTerritory);
        appState.firebaseReference.child(uid).setValue(business);
        finish();
    }

    public void deleteBusiness(View v)
    {
        //deletes a business, then returns to main page
        String uid = key;
        appState.firebaseReference.child(uid).removeValue();
        finish();


    }
}
