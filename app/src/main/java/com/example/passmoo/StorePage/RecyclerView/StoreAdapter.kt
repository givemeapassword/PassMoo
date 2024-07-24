package com.example.passmoo.StorePage.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.passmoo.R
import com.example.passmoo.databinding.StoreCardBinding

class StoreAdapter(private val list: List<StoreData>): RecyclerView.Adapter<StoreAdapter.StoreViewHolder>() {
    class StoreViewHolder(item: View):ViewHolder(item) {
        private val binding = StoreCardBinding.bind(item)
        fun bind(storeData: StoreData){
            binding.text.text = storeData.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.store_card,parent,false)
        return StoreViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) = holder.bind(list[position])
}