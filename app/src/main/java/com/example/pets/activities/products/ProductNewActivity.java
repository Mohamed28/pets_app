package com.example.pets.activities.products;

/*import com.example.pets.daos.seeds.ProductDAO;*/

/*public class ProductNewActivity extends AppCompatActivity {
    private EditText Id, Produto, Tipo, Marca, Preco;
    private ProductDAO productDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_new_activity);
        Produto = findViewById(R.id.editProduct);
        Tipo = findViewById(R.id.editTipoProduto);
        Marca = findViewById(R.id.editMarca);
        Preco = findViewById(R.id.editPreco);
    }


    public void save(View view) {
        try {
            productDAO.insert(new Product(
                    editId.getText().toInt(),
                    editProduct.getText().toString(),
                    editTipoProduto.getText().toString(),
                    editMarca.getText().toString(),
                    editPreco.getText().toString())
            );

            Toast.makeText(this, "Novo produto inserido com sucesso!", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(this, "Falha ao tentar gravar dados, verifique os dados e tente novamente", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, ProductNewActivity.class));
        }
        startActivity(new Intent(this, StartActivity.class));
    }

    public void back(View view) {
        startActivity(new Intent(this, StartActivity.class));
    }
}
*/