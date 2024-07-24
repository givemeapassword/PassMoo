package com.example.passmoo.GeneratorPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.passmoo.GeneratorPage.RecyclerVIew.GeneratorAdapter
import com.example.passmoo.GeneratorPage.RecyclerVIew.PasswordData
import com.example.passmoo.databinding.FragmentGeneratorBinding

class GeneratorFragment : Fragment() {
    private lateinit var binding: FragmentGeneratorBinding
    private val list: List<PasswordData> = listOf(
        PasswordData("fsdfsd"),
        PasswordData("fsddfsfsd"),
        PasswordData("fsaadfsd")
    )
    companion object {
        @JvmStatic
        fun newInstance() = GeneratorFragment()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGeneratorBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val showDialog = FirstPopFragment()
        showDialog.show((activity as AppCompatActivity).supportFragmentManager,"ShowDialog")

        binding.settings.setOnClickListener{
            val settingPopFragment = SettingPopFragment()
            settingPopFragment.show((activity as AppCompatActivity).supportFragmentManager, "SettingDialog")
        }

        binding.apply {
            val adapter = GeneratorAdapter(list)
            rcViewMain.adapter = adapter
            rcViewMain.layoutManager = LinearLayoutManager(context)
        }

    }


}