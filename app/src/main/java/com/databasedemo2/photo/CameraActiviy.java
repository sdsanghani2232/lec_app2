package com.databasedemo2.photo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.databasedemo2.R;

public class CameraActiviy extends AppCompatActivity {

    private static final int CAMERA_CODE = 100;
    private static final int GALLERY_CODE = 200;
    ImageView iv;
    Button camera,gallery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_activiy);

        iv = findViewById(R.id.img);
        camera = findViewById(R.id.camera);
        gallery = findViewById(R.id.gallery);

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,CAMERA_CODE);
            }
        });

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_PICK);
                i.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);  // external is over storage and internal is app storage
                startActivityForResult(i,GALLERY_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK) // check data is not null
        {
            if(requestCode == CAMERA_CODE) // for camara
            {
                Bitmap img = (Bitmap) data.getExtras().get("data");  // data is fix so that get Bit map
                iv.setImageBitmap(img);
            }
            else if(requestCode == GALLERY_CODE)
            {
                iv.setImageURI(data.getData());
            }
        }
    }
}