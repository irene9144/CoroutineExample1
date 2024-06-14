package com.example.coroutineexample1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutineexample1.databinding.TodoitemBinding

interface OnItemClick {
    fun deleteTodo(todo: Todo)
}
class TodoAdapter(listener: OnItemClick) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder> (){

    private val mCallback = listener
    private val items = ArrayList<Todo>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = TodoitemBinding.inflate(layoutInflater)
        return TodoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(items[position])
    }
    fun setList(todo: List<Todo>){
        items.clear()
        items.addAll(todo)
    }
    inner class TodoViewHolder(private val binding: TodoitemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Todo){
            binding.tvTodo.text = item.content
            binding.tvicon.setOnClickListener {
                mCallback.deleteTodo(item)
            }
        }
    }

}