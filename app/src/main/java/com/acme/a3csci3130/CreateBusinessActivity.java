package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class CreateBusinessActivity extends Activity {

    private Button submitButton;
    private EditText businessNumber, businessName, businessAddress;
    private Spinner businessType, provinceOrTerritoryName;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_business_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());
        submitButton = (Button) findViewById(R.id.submitButton);
        businessNumber = (EditText) findViewById(R.id.businessNumber);
        businessName = (EditText) findViewById(R.id.businessName);
        businessType = (Spinner) findViewById(R.id.businessType);
        businessAddress = (EditText) findViewById(R.id.address);
        provinceOrTerritoryName = (Spinner) findViewById(R.id.provinceOrTerritoryName);

    }

    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String uid = appState.firebaseReference.push().getKey();
        String number = businessNumber.getText().toString();
        String name = businessName.getText().toString();
        String type = businessType.getSelectedItem().toString();
        String address = businessAddress.getText().toString();
        String provinceOrTerritory = provinceOrTerritoryName.getSelectedItem().toString();
        Business business = new Business(uid, number, name, type, address, provinceOrTerritory);
        appState.firebaseReference.child(uid).setValue(business);
        finish();
    }


}
