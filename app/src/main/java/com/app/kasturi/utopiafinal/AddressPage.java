package com.app.kasturi.utopiafinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

public class AddressPage extends AppCompatActivity {

    private ImageButton back;
    private Button checkout;


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
                open_lastPage();
            }
        });
    }
    private void open_lastPage()
    {
        Intent intent = new Intent(AddressPage.this,LastPage.class);
        startActivity(intent);
        finish();
    }
}
