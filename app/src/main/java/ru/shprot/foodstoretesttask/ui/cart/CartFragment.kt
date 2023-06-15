package ru.shprot.foodstoretesttask.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.shprot.foodstoretesttask.R
import ru.shprot.foodstoretesttask.common.adapters.CartAdapter
import ru.shprot.foodstoretesttask.common.interfaces.NumberChangedListener
import ru.shprot.foodstoretesttask.common.location.DateHolder
import ru.shprot.foodstoretesttask.common.location.LocationHolder
import ru.shprot.foodstoretesttask.databinding.FragmentCartBinding

class CartFragment : Fragment(), NumberChangedListener {

    lateinit var binding : FragmentCartBinding
    private val viewModel = CartViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCartBinding
            .bind(inflater.inflate(R.layout.fragment_cart, container, false))

        return binding.root

    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updateDate()
        updateLocation()
        changeButtonText()

        val adapter = CartAdapter(viewModel.getAllDishes(), this)
        binding.rvCart.adapter = adapter

        binding.buttonPayCart.setOnClickListener {
            binding.buttonPayCart.text = "Корзина пуста"
            viewModel.removeAllDishes()
            adapter.notifyDataSetChanged()
        }

    }




    override fun onNumberChanged() {

        changeButtonText()

    }




    private fun changeButtonText() {

        if (viewModel.getNumberOfDishes() > 0)
            binding.buttonPayCart.text = "Оплатить ${viewModel.getFullPrice()} ₽"
        else
            binding.buttonPayCart.text = "Корзина пуста"

    }




    private fun updateLocation() {

        val currentCity = LocationHolder().getCurrentCity(context!!)
        binding.headCart.locationCityTextView.text = currentCity

    }




    private fun updateDate() {

        val currentDate = DateHolder().getCurrentDate()
        binding.headCart.locationDataTextView.text = currentDate

    }

}