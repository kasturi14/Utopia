package com.app.kasturi.utopiafinal;

import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.content.Intent;
        import android.widget.Button;
        import android.widget.ImageButton;
        import android.widget.TextView;

public class WelcomePage extends AppCompatActivity {

    private Button shop;
    private ImageButton home;
    private TextView welcome;
    private TextView success;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        shop = (Button) findViewById(R.id.etbhome);
        home = (ImageButton) findViewById(R.id.ethome);
        welcome = (TextView)findViewById(R.id.etwelcome);
        success = (TextView)findViewById(R.id.etmsg);

        home.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                openhome();
            }
        });
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMenu();
            }
        });
    }

    public void openhome() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
    public void openMenu() {
        Intent i2 = new Intent(this, Category_menu.class);
        startActivity(i2);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent i3 = new Intent(this,MainActivity.class);
        startActivity(i3);
        finish();
    }
}