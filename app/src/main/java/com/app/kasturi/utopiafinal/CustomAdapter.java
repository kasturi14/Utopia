package com.app.kasturi.utopiafinal;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;



public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private ArrayList<String> images1;
    private ArrayList<String> Names1;
    private ArrayList<String> prices1;


    private Context context;

    public CustomAdapter(Context context, ArrayList<String> images, ArrayList<String> names, ArrayList<String> prices) {
        this.context = context;
        this.images1 = images;
        this.Names1 = names;
        this.prices1 = prices;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        new GetImageFromURL(holder.imageView).execute(images1.get(position));
        holder.name.setText(Names1.get(position));
        holder.price.setText(prices1.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),SingleItem.class);
                intent.putExtra("image",images1.get(position));
                intent.putExtra("name",Names1.get(position));
                intent.putExtra("price",prices1.get(position));
                view.getContext().startActivity(intent);

             //   view.getContext().finish();
            }
        });
    }



    @Override
    public int getItemCount() {
        return Names1.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name, price;
        Bitmap bitmap;
        // init the item view's

        public MyViewHolder(View itemView) {
            super(itemView);

            // get the reference of item view's
            imageView = (ImageView) itemView.findViewById(R.id.image);
            name = (TextView) itemView.findViewById(R.id.image_name);
            price = (TextView) itemView.findViewById(R.id.image_Price);
        }
    }

    public static class GetImageFromURL extends AsyncTask<String, Void, Bitmap> {
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
}





