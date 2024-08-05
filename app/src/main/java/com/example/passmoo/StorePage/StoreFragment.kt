package com.example.passmoo.StorePage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.passmoo.R
import com.example.passmoo.StorePage.RecyclerView.StoreAdapter
import com.example.passmoo.StorePage.RecyclerView.StoreData
import com.example.passmoo.databinding.FragmentStoreBinding


class StoreFragment : Fragment() {
    private lateinit var binding: FragmentStoreBinding
    private val list: List<StoreData> = listOf(StoreData(1,"32323"),
        StoreData(1,"323213"),
        StoreData(1,"323223"),
        StoreData(1,"323243"),
        StoreData(1,"323243243"),
    )
    companion object {
        @JvmStatic
        fun newInstance() = StoreFragment()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStoreBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val adapter =
        binding.rcViewStore.apply {
            adapter = StoreAdapter(list)
            layoutManager = LinearLayoutManager(context)
        }
    }

}