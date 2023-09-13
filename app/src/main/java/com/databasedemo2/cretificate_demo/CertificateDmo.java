package com.databasedemo2.cretificate_demo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.databasedemo2.R;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CertificateDmo extends AppCompatActivity {

    EditText ed;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certificate_dmo);

        ed = findViewById(R.id.nameInput);
        submit = findViewById(R.id.generateButton);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateCertificate();
            }
        });

    }

    private void generateCertificate() {

        String name = ed.getText().toString();
        if (name.isEmpty()) {
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
            return;
        }
        Document document = new Document();
        try {
            String filePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS) + "/certificate.pdf";
            PdfWriter.getInstance(document, Files.newOutputStream(Paths.get(filePath)));

            document.open();
            document.add(new Paragraph("Certificate of Achievement"));
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("This is to certify that"));
            document.add(new Paragraph(name));
            document.add(new Paragraph("has successfully completed the course."));
            document.close();

            Toast.makeText(this, "Certificate generated at " + filePath, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(Intent.ACTION_VIEW);
            File file = new File(filePath);
            Uri uri = FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID+ ".fileprovider", file);
            intent.setDataAndType(uri, "application/pdf");
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            startActivity(intent);
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error generating certificate", Toast.LENGTH_SHORT).show();
        }

    }
}