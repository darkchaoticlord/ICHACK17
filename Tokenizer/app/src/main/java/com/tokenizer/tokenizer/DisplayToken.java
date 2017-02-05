package com.tokenizer.tokenizer;

import java.util.Date;


public class DisplayToken {

    private final String name;
    private final Date expiryDate;
    private final String organisation;
    private int quantity;

    public DisplayToken(String name, Date expiryDate, String organisation, int quantity) {

        this.name = name;
        this.expiryDate = expiryDate;
        this.organisation = organisation;
        this.quantity = quantity;

    }

    public String getName() {
        return name;
    }

    public String getExpiryDate() {
        return expiryDate.toString();
    }

    public String getOrganisation() {
        return organisation;
    }

    public String getQuantity() {
        return Integer.toString(quantity);
    }

    public void removeToken() {
        quantity--;
    }

    public void addTokens(int moreTokens) {
        quantity += moreTokens;
    }

}
