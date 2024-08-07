package com.example.passmoo.GeneratorPage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.passmoo.GeneratorPage.RecyclerView.PasswordData

class PasswordViewModel:ViewModel() {

    val password: MutableLiveData<MutableList<PasswordData>> by lazy {  MutableLiveData<MutableList<PasswordData>>()}
    val passwordDurability: MutableLiveData<String> by lazy {  MutableLiveData<String>()}
}