package com.example.vegetablesshop2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class OrderProduct extends AppCompatActivity {
    TextView name;
    ImageView image;
    Button sendOrderBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_product);

        name = findViewById(R.id.order_text);
        image = findViewById(R.id.order_image);
        sendOrderBtn = findViewById(R.id.orderNowBtn);

        Bundle b = getIntent().getExtras();

        if (b != null) {
            image.setImageResource(b.getInt("Image"));
            name.setText(b.getString("Name"));
            sendOrderBtn.setText("Order " + b.getString("Name").toLowerCase());
        }

        sendOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishActivity(200);
                Intent i = new Intent(OrderProduct.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
