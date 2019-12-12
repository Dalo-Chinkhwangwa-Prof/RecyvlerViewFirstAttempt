package com.example.internalstorageapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.internalstorageapp.R;
import com.example.internalstorageapp.adapter.ReceiptAdapter;
import com.example.internalstorageapp.model.Receipt;
import com.example.internalstorageapp.util.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private String fileName = "MyAppDB.html";
    private String directoryPath = "MyAppFolder";

    @BindView(R.id.save_receipt_button)
    public Button saveReceiptButton;

    @BindView(R.id.price_edittext)
    public EditText priceEditText;

    @BindView(R.id.receipt_title_edittext)
    public EditText titleEditText;

    @BindView(R.id.main_listview)
    public ListView informationListView;

    private File external;

    private List receiptList = new ArrayList<Receipt>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        external = new File(getExternalFilesDir(directoryPath), fileName);


        saveReceiptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                writeToInternalStorage();
                writeToExternalStorage();
            }
        });

//        readFromInternalStorage();
        readFromExternalStorage();
    }


    private String getInput() {

        String input = titleEditText.getText() + "-$" + priceEditText.getText()+"\n";

        titleEditText.setText("");
        priceEditText.setText("");

        return input;

    }

    private void writeToInternalStorage() {
        try {
            FileOutputStream fileOutputStream = openFileOutput(fileName, Context.MODE_PRIVATE);

            String input = getInput();

            fileOutputStream.write(input.getBytes());
            fileOutputStream.close();

            Toast.makeText(this, input + " successfully added.", Toast.LENGTH_SHORT).show();

            readFromInternalStorage();

        } catch (IOException e) {
            Logger.logError(new Throwable(e.getMessage()));
        }

    }

    private void readFromInternalStorage() {

        try {
            FileInputStream fileInputStream = openFileInput(fileName);
            InputStreamReader streamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(streamReader);
            String currentLine = null;

            while ((currentLine = bufferedReader.readLine()) != null) {
                Logger.logDebug(currentLine);
            }

            bufferedReader.close();


        } catch (IOException e) {
            Logger.logError(new Throwable(e.getMessage()));
        }
    }


    private void writeToExternalStorage() {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(external, false);

            String input = getInput();
            fileOutputStream.write(input.getBytes());
            fileOutputStream.close();

            Toast.makeText(this, input + " successfully added to receipts.", Toast.LENGTH_SHORT).show();
            readFromExternalStorage();

        } catch (IOException e) {
            Logger.logError(new Throwable(e.getMessage()));
        }
    }

    private void readFromExternalStorage() {
        String delimiter = "-";
        try {
            FileInputStream fileInputStream = new FileInputStream(external);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String input = null;

            while ((input = bufferedReader.readLine()) != null) {
                Logger.logDebug(input);
               receiptList.add(new Receipt(input.split(delimiter)[0], input.split(delimiter)[1]));
            }
            bufferedReader.close();

            informationListView.setAdapter(new ReceiptAdapter(receiptList));

        } catch (IOException e) {
            Logger.logError(new Throwable(e.getMessage()));
        }

    }

//    @OnClick({R.id.save_receipt_button})
//    public void saveReceipt(){
//        Toast.makeText(this, "Receipt isbeing saved", Toast.LENGTH_SHORT).show();
//    }


}
