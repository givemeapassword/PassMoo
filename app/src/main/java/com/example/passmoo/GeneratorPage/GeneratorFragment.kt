package com.example.passmoo.GeneratorPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.passmoo.GeneratorPage.RecyclerView.GeneratorAdapter
import com.example.passmoo.GeneratorPage.RecyclerView.PasswordData
import com.example.passmoo.databinding.FragmentGeneratorBinding

class GeneratorFragment : Fragment() {
    private lateinit var binding: FragmentGeneratorBinding
    private val model: PasswordViewModel by activityViewModels()
    private lateinit var adapter: GeneratorAdapter
    private var list: MutableList<PasswordData> = mutableListOf(
        PasswordData("ТУТ БУДЕТ ПАРОЛЬ")
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
            adapter = GeneratorAdapter(list)
            rcViewMain.adapter = adapter
            rcViewMain.apply {
                setIsScrollingEnabled(true)
                setOrientation(RecyclerView.VERTICAL)
                setAlpha(true)
                setFlat(true)
                setInfinite(true)
            }
        }

        with(model){
            passwordDurability.observe(viewLifecycleOwner){ item ->
                binding.Durability.text = String.format("%.3f",item)
            }
            password.observe(viewLifecycleOwner){ item ->
                adapter.addList(item)
            }
        }

    }


}