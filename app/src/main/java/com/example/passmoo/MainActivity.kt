package com.example.passmoo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.passmoo.InfoPage.InfoFragment
import com.example.passmoo.GeneratorPage.GeneratorFragment
import com.example.passmoo.StorePage.StoreFragment
import com.example.passmoo.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity() {
    private val NUMBER_PAGE = 1
    private lateinit var binding: ActivityMainBinding
    private val list = listOf(
        InfoFragment.newInstance(),
        GeneratorFragment.newInstance(),
        StoreFragment.newInstance()
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ViewPagerAdapter(this,list)
        binding.pager.adapter = adapter
        binding.pager.currentItem = NUMBER_PAGE

    }

}