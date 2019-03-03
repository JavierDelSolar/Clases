package pe.edu.cibertec.inventory;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

public class ProductActivity extends AppCompatActivity {
    EditText et_name, et_description, et_quantity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        et_name = findViewById(R.id.et_name);
        et_description = findViewById(R.id.et_description);
        et_quantity = findViewById(R.id.et_quantity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String name = et_name.getText().toString();
        String description = et_description.getText().toString();
        int quantity = Integer.parseInt(et_quantity.getText().toString());
        Product product = new Product(name, description, quantity);
        Intent intent = getIntent();
        intent.putExtra("product_name",name);
        intent.putExtra("product_description",description);
        intent.putExtra("product_quantity",quantity);
        setResult(RESULT_OK, intent);
        finish();
        return true;
    }
}
