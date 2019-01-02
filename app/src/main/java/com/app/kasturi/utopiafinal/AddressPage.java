package com.app.kasturi.utopiafinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class AddressPage extends AppCompatActivity {

    private ImageButton back;
    private Button checkout;
    private EditText pin;
    private EditText town;
    private EditText city;
    private EditText state1;
    private EditText name;
    private EditText mobile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_page);

        back = (ImageButton)findViewById(R.id.et_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddressPage.super.onBackPressed();
            }
        });

        checkout = (Button)findViewById(R.id.checkout);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });

        pin = (EditText) findViewById(R.id.pincode);
        town = (EditText) findViewById(R.id.locality);
        city = (EditText) findViewById(R.id.city);
        state1 = (EditText) findViewById(R.id.state);
        name = (EditText) findViewById(R.id.name);
        mobile = (EditText) findViewById(R.id.mobile);
    }
    public void register()
    {
        if (!validate())
        {
            Toast.makeText(this, "Fields need to be filled properly.", Toast.LENGTH_SHORT).show();
        }
        else
        {
            open_lastPage();
        }
    }

    public boolean validate()
    {
        boolean valid =true;
        if(pin.length()<6)
        {
            pin.setError("Minimum 6 characters required.");
            valid=false;
        }
        if(town.length()==0)
        {
            town.setError("The field cannot be empty");
            valid = false;
        }
        if(city.length()==0)
        {
            city.setError("The field cannot be empty");
            valid=false;
        }
        if(state1.length()==0)
        {
            state1.setError("The field cannot be empty");
            valid=false;
        }
        if(name.length()==0)
        {
            name.setError("The field cannot be empty");
            valid=false;
        }
        if( mobile.length()!=10)
        {
            mobile.setError("10 characters allowed");
            valid = false;
        }
        return valid;
    }
    private void open_lastPage()
    {
        Intent intent = new Intent(AddressPage.this,LastPage.class);
        startActivity(intent);
        finish();
    }
}
