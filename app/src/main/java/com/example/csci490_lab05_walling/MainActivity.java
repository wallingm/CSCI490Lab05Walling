package com.example.csci490_lab05_walling;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private EditText editText3;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);

        button = findViewById(R.id.button);

        SharedPreferences SharedPreferences = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = SharedPreferences.edit();

        editText1.setText(SharedPreferences.getString("Name", ""));
        editText2.setText(SharedPreferences.getString("Password", ""));
        editText2.setText(SharedPreferences.getString("Email", ""));

        editor.apply();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = editText1.getText().toString();
                String p = editText2.getText().toString();
                String e = editText3.getText().toString();

                SharedPreferences SharedPreferences = getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = SharedPreferences.edit();

                editor.putString("Name", n);
                editor.putString("Pass", p);
                editor.putString("Email", e);
                editor.commit();

                editor.apply();

            }
        });

    }
}