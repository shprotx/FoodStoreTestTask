package ru.shprot.foodstoretesttask.ui.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.shprot.foodstoretesttask.R
import ru.shprot.foodstoretesttask.databinding.FragmentAccountBinding

class AccountFragment : Fragment() {

    lateinit var binding : FragmentAccountBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAccountBinding.bind(inflater
            .inflate(R.layout.fragment_account, container, false))

        return binding.root

    }

}