package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText un,em,pas,rn;
    Spinner sp;
    String[] country={"Country","India","Pakistan","USA","Japan","Singapore","Bangladesh","Sri Lanka","China","England","Other"};
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        un=findViewById(R.id.username);
        em=findViewById(R.id.email);
        sp=findViewById(R.id.drop);
        rn=findViewById((R.id.regNo));

        b= findViewById(R.id.button);
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,country);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String value=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(un.getText().toString())){
                    un.setError("UserName is compulsory");
                    return;
                }

                    if(validateEmailAddress(em)==false){
                        em.setError("Email format is wrong");
                        return;
                    }


                if (TextUtils.isEmpty(rn.getText().toString())){
                    rn.setError("Registration number is compulsory");
                    return;
                }
                Toast.makeText(MainActivity.this, "Registration Completed Successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private boolean validateEmailAddress(EditText em){
        String emailip=em.getText().toString();

        if (!emailip.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailip).matches()) {

            Toast.makeText(MainActivity.this, "Email validated successfully", Toast.LENGTH_SHORT).show();
            return true;
        }else {
            Toast.makeText(MainActivity.this, "Invalid Email address", Toast.LENGTH_SHORT).show();
            return  false;
        }
    }
}