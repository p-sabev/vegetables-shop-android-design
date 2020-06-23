package com.example.vegetablesshop2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetails extends AppCompatActivity {
    TextView name;
    TextView description;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        name = findViewById(R.id.details_text);
        description = findViewById(R.id.details_description);
        image = findViewById(R.id.details_image);

        Bundle b = getIntent().getExtras();

        if (b != null) {
            image.setImageResource(b.getInt("Image"));
            name.setText(b.getString("Name"));
            description.setText(b.getString("Description"));
        }
    }
}
