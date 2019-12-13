package com.example.internalstorageapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.internalstorageapp.R;
import com.example.internalstorageapp.model.Receipt;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Toast.makeText(this, ((Receipt) getIntent().getParcelableExtra("my_parcel")).getReceiptTitle(),
        Toast.LENGTH_SHORT).show();

    }
}
