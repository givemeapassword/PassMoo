package com.example.passmoo.GeneratorPage.RecyclerView

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.CLIPBOARD_SERVICE
import android.os.Build
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.passmoo.R
import com.example.passmoo.databinding.MainCardBinding


class GeneratorAdapter(private var list: MutableList<PasswordData>):
    RecyclerView.Adapter<GeneratorAdapter.PasswordHolder>() {


    inner class PasswordHolder(item: View): RecyclerView.ViewHolder(item){
        private val binding = MainCardBinding.bind(item)
        @SuppressLint("ClickableViewAccessibility")
        fun bind(password: PasswordData) {
            binding.password.text = password.password
            binding.password.setOnTouchListener(object : View.OnTouchListener {
                override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                    when (event?.action) {
                        MotionEvent.ACTION_UP -> {
                            val clipBoard = ContextCompat.getSystemService(binding.root.context,ClipboardManager::class.java) as ClipboardManager
                            clipBoard.setPrimaryClip(ClipData.newPlainText("Пароль",binding.password.text))
                            if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.S_V2){
                                Toast.makeText(binding.root.context, "Copied",Toast.LENGTH_SHORT).show()
                            }
                            return true
                        }
                    }
                    return false
                }

            })
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