package pe.edu.cibertec.inventory;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvProduct;
    ArrayList<Product> items;
    AdapterProduct adapterProduct;
    final static int REQUEST_CODE_MAIN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvProduct = findViewById(R.id.rvProduct);

        items = new ArrayList<>();

        loadItems("Laptop", "Marca Toshiba", 2);
        loadItems("Mouse", "Marca Razer", 20);
        loadItems("Teclado", "Marca Razer", 10);
        loadItems("Pantalla", "Marca Toshiba", 10);

        adapterProduct = new AdapterProduct(items);
        rvProduct.setAdapter(adapterProduct);
        rvProduct.setLayoutManager(new LinearLayoutManager(this));
    }

    private void loadItems(String name, String description, int quantity) {
        Product item = new Product(name, description, quantity);
        items.add(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, ProductActivity.class);
        startActivityForResult(intent, REQUEST_CODE_MAIN);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        switch(requestCode){
            case REQUEST_CODE_MAIN:
                if(resultCode == RESULT_OK){
                    String name = data.getStringExtra("product_name");
                    String description = data.getStringExtra("product_description");
                    int quantity = data.getIntExtra("product_quantity",0);
                    Product product = new Product(name, description, quantity);
                    items.add(product);
                    adapterProduct.notifyDataSetChanged();
                }
                break;
        }
    }
}
