package com.example.passmoo.GeneratorPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.passmoo.databinding.FragmentPopSettingBinding

class SettingPopFragment:DialogFragment() {
    private lateinit var binding: FragmentPopSettingBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPopSettingBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lowReg.setOnCheckedChangeListener{buttonView, isChecked ->
            when(isChecked){
                true -> TODO()
                false -> TODO()
            }
        }
        binding.highReg.setOnCheckedChangeListener{buttonView, isChecked ->
            when(isChecked){
                true -> TODO()
                false -> TODO()
            }
        }
        binding.symbol.setOnCheckedChangeListener{buttonView, isChecked ->
            when(isChecked){
                true -> TODO()
                false -> TODO()
            }
        }
        binding.login.setOnCheckedChangeListener{buttonView, isChecked ->
            when(isChecked){
                true -> TODO()
                false -> TODO()
            }
        }
        binding.number.setOnCheckedChangeListener{buttonView, isChecked ->
            when(isChecked){
                true -> TODO()
                false -> TODO()
            }
        }
        binding.slider
    }

}
