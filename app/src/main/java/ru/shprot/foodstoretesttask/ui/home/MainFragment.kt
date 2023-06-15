package ru.shprot.foodstoretesttask.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ru.shprot.foodstoretesttask.MainViewModel
import ru.shprot.foodstoretesttask.R
import ru.shprot.foodstoretesttask.common.adapters.CategoriesAdapter
import ru.shprot.foodstoretesttask.common.interfaces.CategoryClickListener
import ru.shprot.foodstoretesttask.common.location.DateHolder
import ru.shprot.foodstoretesttask.common.location.LocationHolder
import ru.shprot.foodstoretesttask.data.categories.CategoryItem
import ru.shprot.foodstoretesttask.databinding.FragmentMainBinding

class MainFragment: Fragment(), CategoryClickListener {

    lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMainBinding.bind(inflater.inflate
            (R.layout.fragment_main, container, false))

        return binding.root

    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updateLocation()
        updateDate()

        binding.rvMain.adapter = CategoriesAdapter(MainViewModel.categories, this)
        binding.rvMain.layoutManager = LinearLayoutManager(context)

    }




    private fun updateLocation() {

        LocationHolder().getCurrentCity(context!!) { city ->
            binding.head.locationCityTextView.text = city
        }

    }




    private fun updateDate() {

        val currentDate = DateHolder().getCurrentDate()
        binding.head.locationDataTextView.text = currentDate

    }




    override fun onItemClicked(item: CategoryItem) {

        val bundle = Bundle()
        bundle.putString("categoryName", item.name)
        findNavController().navigate(R.id.action_mainFragment_to_categoryFragment, bundle)

    }

}