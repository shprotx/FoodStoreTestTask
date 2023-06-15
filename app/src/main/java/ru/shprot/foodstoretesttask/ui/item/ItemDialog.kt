package ru.shprot.foodstoretesttask.ui.item

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.squareup.picasso.Picasso
import ru.shprot.foodstoretesttask.R
import ru.shprot.foodstoretesttask.data.dishes.DishesItem
import ru.shprot.foodstoretesttask.databinding.FragmentDialogBinding
import ru.shprot.foodstoretesttask.ui.cart.CartViewModel

class ItemDialog(private val item : DishesItem) : DialogFragment() {

    lateinit var binding : FragmentDialogBinding


    @SuppressLint("InflateParams")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        binding = FragmentDialogBinding.bind(layoutInflater.inflate(R.layout.fragment_dialog, null))

        val dialog = constructDialog()

        initElements()
        addListeners()

        dialog.setCanceledOnTouchOutside(false)

        return dialog

    }




    private fun addListeners() {

        binding.dishButtonCart.setOnClickListener {
            addToCart()
            dialog?.cancel()
        }

        binding.buttonClose.setOnClickListener { dialog?.cancel() }

    }




    private fun initElements() {

        binding.dishTitleTextView.text = item.name
        binding.dishPriceTextView.text = item.price.toString()
        binding.dishWeightTextView.text = item.weight.toString()
        binding.dishDeskTextView.text = item.description
        Picasso.get().load(item.image_url).into(binding.dishImageCard)

        binding.dishDeskTextView.movementMethod = ScrollingMovementMethod()

    }




    private fun constructDialog() : AlertDialog {

        val builder = MaterialAlertDialogBuilder(requireContext(), R.style.RoundedCornersDialog)

        builder.setView(binding.root)
        builder.background = ColorDrawable(Color.TRANSPARENT)

        return builder.create()

    }




    private fun addToCart() {

        val viewModel = CartViewModel
        viewModel.addDish(item)

    }

}