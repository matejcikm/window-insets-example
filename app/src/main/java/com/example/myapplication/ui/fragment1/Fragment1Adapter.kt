package com.example.myapplication.ui.fragment1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ListItemSampleBinding
import com.example.myapplication.model.SampleItem

class Fragment1Adapter(
    private val onClick: (view: View, item: SampleItem) -> Unit
) : ListAdapter<SampleItem, Fragment1Adapter.ViewHolder>(DiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ListItemSampleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ).also { binding ->
                binding.onClick = View.OnClickListener { onClick(it, binding.item!!) }
            }
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: ListItemSampleBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: SampleItem) {
            binding.item = item
            binding.executePendingBindings()
        }

    }

    object DiffUtilCallback : DiffUtil.ItemCallback<SampleItem>() {

        override fun areContentsTheSame(oldItem: SampleItem, newItem: SampleItem): Boolean =
            oldItem == newItem

        override fun areItemsTheSame(oldItem: SampleItem, newItem: SampleItem): Boolean =
            oldItem.id == newItem.id
    }
}
