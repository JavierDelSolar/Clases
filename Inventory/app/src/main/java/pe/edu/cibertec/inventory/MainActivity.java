package pe.edu.cibertec.inventory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Vista
    RecyclerView rvProduct;

    // Modelo: información a mostrar
    ArrayList<Product> items;

    // Adaptador
    AdapterProduct adapterProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvProduct = findViewById(R.id.rvProduct);

        items = new ArrayList<>();

        loadItems("Laptop", "Marca Toshiba", 2);
        loadItems("Mouse", "Marca Razer", 20);

        adapterProduct = new AdapterProduct(items);
        rvProduct.setAdapter(adapterProduct);
        rvProduct.setLayoutManager(new LinearLayoutManager(this));
    }

    private void loadItems(String name, String description, int quantity) {
        Product item = new Product(name, description, quantity);
        items.add(item);
    }
}
