package com.example.passmoo.GeneratorPage.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.passmoo.GeneratorPage.PasswordViewModel
import com.example.passmoo.R
import com.example.passmoo.databinding.MainCardBinding

class GeneratorAdapter(private var list: MutableList<PasswordData>):
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

    fun addList(item: MutableList<PasswordData>){
        list = item
        notifyItemInserted(list.size-1)

    }

}