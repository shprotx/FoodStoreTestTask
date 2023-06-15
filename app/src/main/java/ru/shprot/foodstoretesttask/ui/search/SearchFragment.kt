package ru.shprot.foodstoretesttask.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.shprot.foodstoretesttask.R
import ru.shprot.foodstoretesttask.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    lateinit var binding : FragmentSearchBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSearchBinding
            .bind(inflater.inflate(R.layout.fragment_search, container, false))

        return binding.root
    }

}