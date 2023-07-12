package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner sp1,sp2;
    EditText e1;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.txtamount);
        sp1 = findViewById(R.id.sp1);
        sp2 = findViewById(R.id.sp2);
        b =findViewById(R.id.b1);

        String[] from = {"INR"};
        ArrayAdapter ad = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(ad);

        String[] to = {"USD" , "SriLankan" , "WON" , "DINAR"};
        ArrayAdapter ad1 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,to);
        sp2.setAdapter(ad1);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double con;
                Double amount = Double.parseDouble(e1.getText().toString());

                if(sp1.getSelectedItem().toString() == "INR" && sp2.getSelectedItem().toString() == "USD"){
                    con = amount * 0.012;
                    Toast.makeText(MainActivity.this, con.toString(), Toast.LENGTH_SHORT).show();
                }
                else if(sp1.getSelectedItem().toString() == "INR" && sp2.getSelectedItem().toString() == "Sri Lankan"){
                    con = amount * 3.60;
                    Toast.makeText(MainActivity.this, con.toString(), Toast.LENGTH_SHORT).show();
                }

                else if(sp1.getSelectedItem().toString() == "INR" && sp2.getSelectedItem().toString() == "WON"){
                    con = amount * 15.62;
                    Toast.makeText(MainActivity.this, con.toString(), Toast.LENGTH_SHORT).show();
                }
                else{
                    con = amount * 0.0037;
                    Toast.makeText(MainActivity.this, con.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}