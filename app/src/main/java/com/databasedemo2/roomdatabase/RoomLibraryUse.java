package com.databasedemo2.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.databasedemo2.R;

import java.util.ArrayList;

public class RoomLibraryUse extends AppCompatActivity {

    EditText title, amount;
    Button sub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_library_use);

        title=findViewById(R.id.title);
        amount = findViewById(R.id.amount);
        sub = findViewById(R.id.submit);

        DataBAseHelper helper = DataBAseHelper.getdata(getApplicationContext());
        ArrayList<Expense> arr = (ArrayList<Expense>) helper.expenceDemo().getAllData();
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 helper.expenceDemo().addData(new Expense(title.getText().toString(),amount.getText().toString()));

                 for (int i =0 ; i<arr.size();i++)
                     Log.d("data_",arr.get(i).getTitle() + ""+ arr.get(i).getAmount());

            }
        });

    }
}