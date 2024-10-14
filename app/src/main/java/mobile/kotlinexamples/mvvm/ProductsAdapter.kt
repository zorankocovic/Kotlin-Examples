package mobile.kotlinexamples.mvvm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import mobile.kotlinexamples.R


class ProductsAdapter  : ListAdapter<Product, ProductsAdapter.ProductsViewHolder>(ProductsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item_mvvm, parent, false)
        return ProductsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ProductsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val bookNameTextView: TextView = itemView.findViewById(R.id.book_name)
        private val bookAuthorTextView: TextView = itemView.findViewById(R.id.book_author)

        fun bind(product: Product) {
            bookNameTextView.text = product.name
            bookAuthorTextView.text = product.eEmployeeCodeNumber
        }
    }

    class ProductsDiffCallback : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean = oldItem.name == newItem.name
        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean = oldItem == newItem
    }
}