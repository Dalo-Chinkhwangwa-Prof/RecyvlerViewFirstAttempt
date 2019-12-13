package com.example.internalstorageapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.internalstorageapp.R;
import com.example.internalstorageapp.model.Receipt;

import java.util.List;

public class ReceiptRVAdapter extends RecyclerView.Adapter<ReceiptRVAdapter.CustomReceiptViewHolder> {

    private List<Receipt> receipts;
    private ReceiptAdapterDelegate receiptDelegate;


    public interface ReceiptAdapterDelegate{
        void receiptSelected(Receipt selectedReceipt);
    }

    public ReceiptRVAdapter(List<Receipt> receipts, ReceiptAdapterDelegate receiptDelegate) {
        this.receipts = receipts;
        this.receiptDelegate = receiptDelegate;
}

    @NonNull
    @Override
    public CustomReceiptViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.receipt_item_layout, parent, false);

        return new CustomReceiptViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomReceiptViewHolder holder, final int position) {
        holder.receiptTitle.setText(receipts.get(position).getReceiptTitle());
        holder.receiptPrice.setText(receipts.get(position).getReceiptPrice());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                receiptDelegate.receiptSelected(receipts.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return receipts.size();
    }

    class CustomReceiptViewHolder extends RecyclerView.ViewHolder {

        public TextView receiptTitle;
        public TextView receiptPrice;

        public CustomReceiptViewHolder(@NonNull View itemView) {
            super(itemView);
            receiptPrice = itemView.findViewById(R.id.receipt_cost_textview);
            receiptTitle = itemView.findViewById(R.id.receipt_title_textview);
        }
    }
}
