package com.lhh.jetpackdemo.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lhh.jetpackdemo.databinding.ShoeItemBinding
import com.lhh.jetpackdemo.db.data.Shoe

class shoeAdapter(): ListAdapter<Shoe,shoeAdapter.ViewHolder>(ShoeDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return  ViewHolder(ShoeItemBinding.inflate( LayoutInflater.from(parent.context)
            , parent
            , false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val shoe = getItem(position)
        holder.apply {
            bindData(onCreateListener(shoe.id), shoe)
            itemView.tag = shoe
        }
    }

    /**
     * Holder的点击事件
     */
    private fun onCreateListener(id: Long): View.OnClickListener {
        // TODO 点击事件
        return View.OnClickListener {
            Log.e("TAG","点击了："+id)

        }
    }
    class ViewHolder(private  val binding: ShoeItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindData(listener: View.OnClickListener, shoe: Shoe?) {
            binding.apply {
                this.onClincklistener = listener
                this.shoe = shoe
                executePendingBindings()
            }
        }


    }
}

private class ShoeDiffCallback : DiffUtil.ItemCallback<Shoe>() {
    override fun areItemsTheSame(oldItem: Shoe, newItem: Shoe): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Shoe, newItem: Shoe): Boolean {
        return oldItem == newItem
    }

}