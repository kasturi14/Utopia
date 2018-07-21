package com.app.kasturi.utopiafinal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.Matrix;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;

public class SingleItem extends AppCompatActivity {

    private ImageView imageView;
    private TextView item_name;
    private TextView item_price;
    private ImageButton et_back;
    private Button btn_buy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_item);


        Bundle extras = getIntent().getExtras();
       // SGD = new ScaleGestureDetector(this,new ScaleListener());

        imageView = (ImageView) findViewById(R.id.imageView);
        //imageView.setImageResource(extras.getString("image"));
      //  new GetImageFromURL(imageView).execute(extras."image");
        new GetImageFromURL(imageView).execute(extras.getString("image"));
        item_name = (TextView) findViewById(R.id.et_item_name);
        item_name.setText(extras.getString("name"));
        item_price = (TextView) findViewById(R.id.et_item_price);
        item_price.setText(extras.getString("price"));

        et_back = (ImageButton) findViewById(R.id.et_back);
        et_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SingleItem.super.onBackPressed();
            }
        });

        btn_buy = (Button) findViewById(R.id.buy_now_btn);
        btn_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               open_address();
            }
        });


       // Bitmap bitmap = (Bitmap)this.getIntent().getParcelableExtra("image");
     //   imageView.setImageBitmap(bitmap);

    }

    private void open_address()
    {
        Intent intent = new Intent(this,AddressPage.class);
        startActivity(intent);
        finish();
    }


    public class GetImageFromURL extends AsyncTask<String, Void, Bitmap> {
        ImageView imgV;
        Bitmap bitmap;


        public GetImageFromURL(ImageView imgV) {
            this.imgV = imgV;

        }

        @Override
        protected Bitmap doInBackground(String... url) {
            String urldisplay = url[0];
            bitmap = null;
            try {
                InputStream srt = new java.net.URL(urldisplay).openStream();
                bitmap = BitmapFactory.decodeStream(srt);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imgV.setImageBitmap(bitmap);
        }

    }

    @Override
    public void onBackPressed() {
        SingleItem.super.onBackPressed();
    }

}
