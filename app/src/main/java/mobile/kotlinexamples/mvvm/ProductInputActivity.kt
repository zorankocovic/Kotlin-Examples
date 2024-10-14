package mobile.kotlinexamples.mvvm

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import mobile.kotlinexamples.R

import androidx.recyclerview.widget.RecyclerView
class ProductInputActivity : AppCompatActivity() {

    private lateinit var viewModel: ProductViewModel
    private lateinit var productNameEditText: EditText
    private lateinit var productPriceEditText: EditText
    private lateinit var submitButton: Button
    private lateinit var productNameTextView: TextView
    private lateinit var productPriceTextView: TextView
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_input)

        // Initialize ViewModel using application scope
      /*  viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[ProductViewModel::class.java]*/
        viewModel = ViewModelProvider(this, ProductViewModelFactory())[ProductViewModel::class.java]


        recyclerView = findViewById(R.id.recycler_view)

        adapter = ProductsAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        viewModel.productsist.observe(this, { productsist ->
            adapter.submitList(productsist)
        })



        viewModel.getAllProducts()




    }

}