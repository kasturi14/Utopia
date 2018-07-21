package com.app.kasturi.utopiafinal;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Category_menu extends AppCompatActivity {
    TextView head;
    Button tv1;
    Button tv2;
    Button tv3;
    Button tv4;
    Button tv5;
    Button tv6;
    Button tv7;
    Button tv8;
    Button tv9;
    Button tv10;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_menu);
        head = (TextView) findViewById(R.id.header);

        tv1 = (Button) findViewById(R.id.category1);
        tv2 = (Button) findViewById(R.id.category2);
        tv3 = (Button) findViewById(R.id.category3);
        tv4 = (Button) findViewById(R.id.category4);
        tv5 = (Button) findViewById(R.id.category5);
        tv6 = (Button) findViewById(R.id.category6);
        tv7 = (Button) findViewById(R.id.category7);
        tv8 = (Button) findViewById(R.id.category8);
        tv9 = (Button) findViewById(R.id.category9);
        tv10 = (Button) findViewById(R.id.category10);

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_category1();
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_category2();
            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_category3();
            }
        });
        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_category4();
            }
        });
        tv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_category5();
            }
        });
        tv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_category6();
            }
        });
        tv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_category7();
            }
        });
        tv8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_category8();
            }
        });
        tv9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_category9();
            }
        });
        tv10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_category10();
            }
        });


    }

    public void open_category1() {
        Intent intent = new Intent(this, MensTopwear.class);
        startActivity(intent);
        finish();
    }
    public void open_category2() {
        Intent intent1 = new Intent(this, MensBottomwear.class);
        startActivity(intent1);
        finish();
    }
    public void open_category3() {
        Intent intent3 = new Intent(this, MensFootwear.class);
        startActivity(intent3);
        finish();
    }

    public void open_category4() {
        Intent intent4 = new Intent(this, MensAccessories.class);
        startActivity(intent4);
        finish();
    }
    public void open_category5() {
        Intent intent5 = new Intent(this, BoysClothing.class);
        startActivity(intent5);
        finish();
    }

    public void open_category6() {
        Intent intent6 = new Intent(this, GirlsClothing.class);
        startActivity(intent6);
        finish();
    }
    public void open_category7() {
        Intent intent7 = new Intent(this, WomensTopwear.class);
        startActivity(intent7);
        finish();
    }

    public void open_category8() {
        Intent intent8 = new Intent(this, WomensBottomwear.class);
        startActivity(intent8);
        finish();
    }
    public void open_category9() {
        Intent intent9 = new Intent(this, WomensFootwear.class);
        startActivity(intent9);
        finish();
    }

    public void open_category10() {
        Intent intent10 = new Intent(this, WomensAccessories.class);
        startActivity(intent10);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent intentb = new Intent(this,MainActivity.class);
        startActivity(intentb);
        finish();

        //super.onBackPressed();
    }
}