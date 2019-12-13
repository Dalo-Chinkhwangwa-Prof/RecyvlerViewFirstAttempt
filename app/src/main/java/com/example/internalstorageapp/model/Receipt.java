package com.example.internalstorageapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Receipt implements Parcelable {

    private String receiptTitle;

    private String receiptPrice;

    public Receipt(String receiptTitle, String receiptPrice)  {
        this.receiptTitle = receiptTitle;
        this.receiptPrice = receiptPrice;
    }

    protected Receipt(Parcel in) {
        receiptTitle = in.readString();
        receiptPrice = in.readString();
    }

    public static final Creator<Receipt> CREATOR = new Creator<Receipt>() {
        @Override
        public Receipt createFromParcel(Parcel in) {
            return new Receipt(in);
        }

        @Override
        public Receipt[] newArray(int size) {
            return new Receipt[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(receiptTitle);
        dest.writeString(receiptPrice);
    }
}
