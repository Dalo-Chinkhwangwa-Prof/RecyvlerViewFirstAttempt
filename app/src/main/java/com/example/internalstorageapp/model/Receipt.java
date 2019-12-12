package com.example.internalstorageapp.model;

public class Receipt {

    private String receiptTitle;

    private String receiptPrice;

    public Receipt(String receiptTitle, String receiptPrice) {
        this.receiptTitle = receiptTitle;
        this.receiptPrice = receiptPrice;
    }

    public String getReceiptTitle() {
        return receiptTitle;
    }

    public void setReceiptTitle(String receiptTitle) {
        this.receiptTitle = receiptTitle;
    }

    public String getReceiptPrice() {
        return receiptPrice;
    }

    public void setReceiptPrice(String receiptPrice) {
        this.receiptPrice = receiptPrice;
    }
}
