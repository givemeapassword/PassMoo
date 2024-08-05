package com.example.passmoo.GeneratorPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.example.passmoo.GeneratorPage.RecyclerView.PasswordData
import com.example.passmoo.databinding.FragmentPopSettingBinding
import kotlin.math.log
import kotlin.math.pow

class SettingPopFragment:DialogFragment() {
    private lateinit var binding: FragmentPopSettingBinding
    private val passwordBuilder = PasswordBuilder()
    private val list: MutableList<PasswordData> = mutableListOf()
    private val model: PasswordViewModel by activityViewModels()
    private var numberSliderSize = 4
    private var numberSliderCount = 2

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
        with(binding) {
            lowReg.setOnCheckedChangeListener { _, isChecked ->
                when (isChecked) {
                    true -> passwordBuilder.lower()
                    false -> passwordBuilder.unlower()
                }
            }
            highReg.setOnCheckedChangeListener { _, isChecked ->
                when (isChecked) {
                    true -> passwordBuilder.upper()
                    false -> passwordBuilder.unupper()
                }
            }
            symbol.setOnCheckedChangeListener { _, isChecked ->
                when (isChecked) {
                    true -> passwordBuilder.symbol()
                    false -> passwordBuilder.unsymbol()
                }
            }
            login.setOnCheckedChangeListener { _, isChecked ->
                when (isChecked) {
                    true -> TODO()
                    false -> TODO()
                }
            }
            number.setOnCheckedChangeListener { _, isChecked ->
                when (isChecked) {
                    true -> passwordBuilder.digit()
                    false -> passwordBuilder.undigit()
                }
            }
            sliderSize.addOnChangeListener { _, value, _ ->
                numberSliderSize = value.toInt()
            }
            sliderCount.addOnChangeListener { _, value, _ ->
                numberSliderCount = value.toInt()
            }
            button.setOnClickListener {
                generatePassword()
                model.passwordDurability.value = passwordDurability()
                model.password.value = list
                dismiss()
            }
        }
    }
    private fun generatePassword(){
        repeat(numberSliderCount) {
            val password = passwordBuilder.generate(numberSliderSize)
            list.add(PasswordData(password))
        }
    }
    private fun passwordDurability(): Double{
        val entropy = (2.0.pow(log(passwordBuilder.getCharSetSize().pow(numberSliderSize), 2.0)))
        val speed = 0.0001*entropy
        return speed
    }

}
