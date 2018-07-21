package com.app.kasturi.utopiafinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class LastPage extends AppCompatActivity {

    ImageView image_icon;
    TextView thanks;
    Button continue_shopping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_page);

        image_icon = (ImageView)findViewById(R.id.image_icon);
        thanks = (TextView)findViewById(R.id.thanks);
        continue_shopping = (Button)findViewById(R.id.continue_shop);

        continue_shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_menu();
            }
        });
    }

    private void open_menu()
    {
        Intent intent = new Intent(LastPage.this,Category_menu.class);
        startActivity(intent);
        finish();
    }
}
