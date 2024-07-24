package com.example.passmoo.GeneratorPage.RecyclerVIew

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.passmoo.R
import com.example.passmoo.databinding.MainCardBinding

class GeneratorAdapter(private val list: List<PasswordData>):
    RecyclerView.Adapter<GeneratorAdapter.PasswordHolder>() {

    class PasswordHolder(item: View): RecyclerView.ViewHolder(item){
        private val binding = MainCardBinding.bind(item)
        fun bind(password: PasswordData) {
            binding.password.text = password.password
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PasswordHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_card,parent,false)
        return PasswordHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PasswordHolder, position: Int) = holder.bind(list[position])

    fun addData(password: List<PasswordData>) = list + password
}