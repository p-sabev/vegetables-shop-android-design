package com.example.vegetablesshop2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetails extends AppCompatActivity {
    TextView name;
    TextView description;
    ImageView image;
    Button orderBtn;
    private int img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        name = findViewById(R.id.details_text);
        description = findViewById(R.id.details_description);
        image = findViewById(R.id.details_image);
        orderBtn = findViewById(R.id.orderBtn);

        Bundle b = getIntent().getExtras();

        if (b != null) {
            image.setImageResource(b.getInt("Image"));
            name.setText(b.getString("Name"));
            description.setText(b.getString("Description"));
            img = b.getInt("Image");
        }

        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductDetails.this, OrderProduct.class);

                Bundle b = new Bundle();
                b.putString("Name", name.getText().toString());
                b.putInt("Image", img);

                intent.putExtras(b);
                startActivityForResult(intent, 200, b);
            }
        });
    }
}
