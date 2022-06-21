package com.meicode.cipher;

import static com.meicode.cipher.Utility.decrypt1;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.badge.BadgeUtils;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button encrypt, decrypt;
    private EditText message,cipher,key;
    private TextView screenOutput;

    private static final String ALPHABETSTRING="abcdefghijklmnopqrstuvwxyz";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        encrypt =findViewById(R.id.btnEncrypt);
        decrypt =findViewById(R.id.btnDecrypt);
        screenOutput =findViewById(R.id.tV1);
        message =findViewById(R.id.inputMessage);
        cipher =findViewById(R.id.ciphEdt);
        key =findViewById(R.id.keyDT);

        encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                encrypt21(message.getText().toString(),Integer.parseInt(key.getText().toString()));

            }
        });

        decrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrypt21(cipher.getText().toString(),Integer.parseInt(key.getText().toString()));
            }
        });

    }  // oncreate

    public void decrypt21(String cipher,int key){
        screenOutput.setText(decrypt1(cipher,key).toLowerCase());
    } // decrypt 21 class

    public String encrypt21(String message, int shiftKey){
        message =message.toLowerCase();
        String cipherText="";
        for (int i = 0; i < message.length(); i++) {
            int charPosition=ALPHABETSTRING.indexOf(message.charAt(i));
            int keyVal =(shiftKey+charPosition)%26;
            char replaceVAL =ALPHABETSTRING.charAt(keyVal);
            cipherText+=replaceVAL;
            screenOutput.setText(cipherText);
            cipher.setText(cipherText);
        } // for loop
        return cipherText;
    } // encrypt 21 class

} // main activity