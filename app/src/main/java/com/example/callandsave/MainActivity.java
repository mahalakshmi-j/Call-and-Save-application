package com.example.callandsave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;


public class MainActivity extends AppCompatActivity {
    EditText phone;
    Button call,save;
    String phoneNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phone = findViewById(R.id.phone);
        call = findViewById(R.id.bCall);
        save = findViewById(R.id.bSave);

        call.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String phoneNum=phone.getText().toString();
                Uri phoneData = Uri.parse("tel:"+phoneNum);
                Intent myInt=new Intent(Intent.ACTION_DIAL);
                myInt.setData(phoneData);
                startActivity(myInt);
            }

        });
        save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String phoneNum=phone.getText().toString();
                Intent myInt=new Intent(Intent.ACTION_INSERT);
                myInt.setType(ContactsContract.Contacts.CONTENT_TYPE);
                myInt.putExtra(ContactsContract.Intents.Insert.PHONE,phoneNum);
                startActivity(myInt);
            }

        });

    }
    public void inputNumber(View view) {
        Button btn=(Button)view;
        String digit=btn.getText().toString();
        String phoneNum=phone.getText().toString();
        phone.setText(phoneNum+digit);
    }
}