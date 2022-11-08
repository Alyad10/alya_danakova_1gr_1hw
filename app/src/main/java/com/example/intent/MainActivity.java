package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    MaterialButton btn_send;
    TextInputEditText text_theme;
    TextInputEditText text_message;
    TextInputEditText e_mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_send = findViewById(R.id.btn_send);
        text_theme = findViewById(R.id.text_theme);
        text_message = findViewById(R.id.message);
        e_mail = findViewById(R.id.e_mail);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Intent intent = new Intent(Intent.ACTION_SEND_MULTIPLE);
                    intent.setType("text/html");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{String.valueOf(e_mail.getText())});
                    intent.putExtra(Intent.EXTRA_SUBJECT, text_theme.getText().toString());
                    intent.putExtra(Intent.EXTRA_TEXT, text_message.getText());
                    intent.setPackage("com.google.android.gm");

                    startActivity(Intent.createChooser(intent, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(MainActivity.this, "Что то пошло не так", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}