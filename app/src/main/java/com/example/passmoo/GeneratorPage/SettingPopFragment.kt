package com.example.passmoo.GeneratorPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.example.passmoo.GeneratorPage.RecyclerView.PasswordData
import com.example.passmoo.databinding.FragmentPopSettingBinding
import kotlin.math.ceil
import kotlin.math.log
import kotlin.math.log2
import kotlin.math.pow
import kotlin.math.round
import kotlin.math.roundToInt
import kotlin.math.roundToLong

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
    private fun passwordDurability(): String{
        val speed = 10000000000 //скорость перебора паролей в секунду
        val entropy = numberSliderSize * log2(passwordBuilder.getCharSetSize())
        val crackingTime = ((2.0.pow(entropy-1))/speed)
        val translatingTime = translateTime(crackingTime)
        return translatingTime
    }
    private fun translateTime(seconds: Double):String{
        val minute = seconds/60
        val hours = minute/60
        val days = hours/24
        val years = days/365

        return when{
            years>=1000 -> "Он умрет от старости"
            years.toInt() == 1 -> "${years.roundToInt()} год"
            years.toInt() in (2..4) -> "${years.roundToInt()} года"
            years>=5 -> "${years.roundToInt()} лет"
            days.toInt() == 1 -> "${years.roundToInt()} день"
            days.toInt() in (2..4) -> "${years.roundToInt()} дня"
            days>=5 -> "${days.roundToInt()} дней"
            hours.toInt() == 1 -> "${years.roundToInt()} час"
            hours.toInt() in (2..4) -> "${years.roundToInt()} часа"
            hours>=5 -> "${hours.roundToInt()} часов"
            minute.toInt() == 1 -> "${years.roundToInt()} минуту"
            minute.toInt() in (2..4) -> "${years.roundToInt()} минуты"
            minute>=5 -> "${minute.roundToInt()} минут"
            seconds<=1 -> "смогу без рук"
            else -> "${seconds.roundToInt()} секунд"
        }
    }

}
