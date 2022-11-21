package mobile.jetpackrecycleview.mvvm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_mvvm.view.*
import mobile.jetpackrecycleview.R


class MainRecyclerAdapter (val viewModel: MainViewModel, val arrayList: ArrayList<Books>, val context: Context): RecyclerView.Adapter<MainRecyclerAdapter.NotesViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainRecyclerAdapter.NotesViewHolder {
        var root = LayoutInflater.from(parent.context).inflate(R.layout.item_mvvm,parent,false)
        return NotesViewHolder(root)
    }

    override fun onBindViewHolder(holder: MainRecyclerAdapter.NotesViewHolder, position: Int) {
        holder.bind(arrayList.get(position))
    }

    override fun getItemCount(): Int {
        if(arrayList.size==0){
            Toast.makeText(context,"List is empty", Toast.LENGTH_LONG).show()
        }else{

        }
        return arrayList.size
    }


    inner  class NotesViewHolder(private val binding: View) : RecyclerView.ViewHolder(binding) {
        fun bind(blog: Books){
            binding.title.text = blog.title
            binding.delete.setOnClickListener {
                viewModel.remove(blog)
                notifyItemRemoved(arrayList.indexOf(blog))
            }
        }

    }

}