package com.databasedemo2.openhelperdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.databasedemo2.R;

import java.util.ArrayList;

public class OpenHelperDataBaseDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_helper_data_base_demo);

        MyHelper myHelper = new MyHelper(this);
//        myHelper.contactadd("Daksh","834723843");
//        myHelper.contactadd("Daks","834723843");
//        myHelper.contactadd("Dakh","834723843");
//        myHelper.contactadd("Dksh","834723843");
//        myHelper.contactadd("Dash","8347234843");

//        ContactModel model = new ContactModel();
//        model.id = 2;
//
//        myHelper.updateData(model);
//

//       ArrayList<ContactModel> models =  myHelper.getData();
//
//       for (int i = 0 ; i<models.size();i++)
//           Log.d("info1",models.toString());


        myHelper.deleteData(2);
    }
}