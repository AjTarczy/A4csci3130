package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines how the data will be stored in the
 * Firebase database. This is converted to a JSON format
 */

public class Business implements Serializable {

    public String uid;
    public String businessNumber;
    public String businessName;
    public String businessType;
    public String address;
    public String provinceOrTerritoryName;

    public Business() {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    public Business(String uid, String businessNumber, String businessName, String businessType,
                    String address, String provinceOrTerritoryName) {
        this.uid = uid;
        this.businessNumber = businessNumber;
        this.businessName = businessName;
        this.businessType = businessType;
        this.address = address;
        this.provinceOrTerritoryName = provinceOrTerritoryName;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("businessNumber", businessNumber);
        result.put("businessName", businessName);
        result.put("businessType", businessType);
        result.put("address", address);
        result.put("provinceOrTerritoryName", provinceOrTerritoryName);

        return result;
    }
}