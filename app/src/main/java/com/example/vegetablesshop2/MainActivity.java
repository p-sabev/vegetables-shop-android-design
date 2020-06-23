package com.example.vegetablesshop2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TableLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {
    private boolean collapsed = false;
    GridView gridView;

    String[] vegetables = {"Potatoes", "Carrots", "Tomatoes", "Onion", "Mushrooms", "Lemons"};
    String[] descriptions = {"The potato is a root vegetable native to the Americas, a starchy tuber of the plant Solanum tuberosum, and the plant itself, a perennial in the family Solanaceae.",
            "The carrot (Daucus carota) is a root vegetable often claimed to be the perfect health food. It is crunchy, tasty, and highly nutritious.",
            "The tomato is the edible, often red, berry of the plant Solanum lycopersicum,[2][1] commonly known as a tomato plant. The species originated in western South America and Central America.",
            "The onion (Allium cepa L., from Latin cepa \"onion\"), also known as the bulb onion or common onion, is a vegetable that is the most widely cultivated species of the genus Allium. Its close relatives include the garlic, scallion, shallot, leek, chive,[2] and Chinese onion.[3]",
            "A mushroom or toadstool is the fleshy, spore-bearing fruiting body of a fungus, typically produced above ground, on soil, or on its food source.",
            "The lemon, Citrus limon, is a species of small evergreen tree in the flowering plant family Rutaceae, native to South Asia, primarily North eastern India. Its fruits are round in shape."};
    int[] images = {R.drawable.potatoes, R.drawable.carrots, R.drawable.tomatoes, R.drawable.onion, R.drawable.mushrooms, R.drawable.lemons};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_products, R.id.navigation_my_orders)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    public void collapseTable(View view) {
        TableLayout table = findViewById(R.id.table);
        Button btn = findViewById(R.id.switchButton);

        table.setColumnCollapsed(1, collapsed);
        table.setColumnCollapsed(2, collapsed);
//        table.setColumnCollapsed(3, collapsed);

        if (collapsed) {
            collapsed = false;
            btn.setText("Show more");
        } else {
            collapsed = true;
            btn.setText("Show less");
        }
    }

    public void loadProducts() {
        gridView = findViewById(R.id.grid_view);

        MainAdapter adapter = new MainAdapter(MainActivity.this, vegetables, images);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, ProductDetails.class);

                Bundle b = new Bundle();
                b.putString("Name", vegetables[+i]);
                b.putString("Description", descriptions[+i]);
                b.putInt("Image", images[+i]);

                intent.putExtras(b);
                startActivityForResult(intent, 200, b);
            }
        });
    }

}
