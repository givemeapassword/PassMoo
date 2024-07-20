package com.example.passmoo.GeneratorPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.passmoo.databinding.FragmentFirstPopBinding

class FirstPopFragment: DialogFragment() {
    private lateinit var binding: FragmentFirstPopBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstPopBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonDialog.setOnClickListener{
            dismiss()
        }
    }

}