package com.example.internalstorageapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.internalstorageapp.R;
import com.example.internalstorageapp.model.Receipt;
import com.example.internalstorageapp.util.Logger;

import java.util.List;

public class ReceiptAdapter extends BaseAdapter {

    private List<Receipt> receipts;

    public ReceiptAdapter(List<Receipt> receipts) {
        this.receipts = receipts;
    }

    @Override
    public int getCount() {
        return receipts.size();
    }

    @Override
    public Receipt getItem(int position) {
        if(receipts.get(position) != null)
            return receipts.get(position);
        else {
            Logger.logError(new Throwable("getItem returned null."));
            return new Receipt("","");
        }
    }

    @Override
    public long getItemId(int position) {
        return (long) position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.receipt_item_layout, parent, false);

        TextView receiptNameTextView = view.findViewById(R.id.receipt_title_textview);
        TextView receiptCostTextView = view.findViewById(R.id.receipt_cost_textview);

        receiptNameTextView.setText(receipts.get(position).getReceiptTitle());
        receiptCostTextView.setText(receipts.get(position).getReceiptPrice());
        return view;
    }
}
