package ru.shprot.foodstoretesttask.common.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.shprot.foodstoretesttask.R
import ru.shprot.foodstoretesttask.common.interfaces.NumberChangedListener
import ru.shprot.foodstoretesttask.data.dishes.DishesItem
import ru.shprot.foodstoretesttask.databinding.ItemCartBinding
import ru.shprot.foodstoretesttask.ui.cart.CartViewModel

class CartAdapter(
    private val orderedDishes : List<DishesItem>,
    private val listener : NumberChangedListener
    ) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    lateinit var binding : ItemCartBinding
    private val viewModel = CartViewModel


    inner class CartViewHolder(b: ItemCartBinding) : RecyclerView.ViewHolder(b.root) {

        val title = b.cartDishTitle
        val price = b.cartPriceTextView
        val weight = b.cartWeightTextView
        val image = b.cartImage
        val buttonPlus = b.buttonPlus
        val buttonMinus = b.buttonMinus
        val number = b.numberInOrder

    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {

        binding = ItemCartBinding.bind(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cart, parent, false))

        return CartViewHolder(binding)

    }




    override fun getItemCount(): Int {

        return orderedDishes.size

    }




    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {

        val currentItem = orderedDishes[position]

        holder.title.text = currentItem.name
        holder.price.text = "${currentItem.price}₽"
        holder.weight.text = " · ${currentItem.weight}г"
        holder.number.text = viewModel.getDishNumber(position).toString()

        Picasso.get().load(currentItem.image_url).into(holder.image)

        holder.buttonPlus.setOnClickListener {

            viewModel.incrementDishNumber(position)
            holder.number.text = viewModel.getDishNumber(position).toString()
            listener.onNumberChanged()

        }

        holder.buttonMinus.setOnClickListener {

            val number = viewModel.decrementDishNumber(position)

            if (number > 0) {
                val currentNumber = viewModel.getDishNumber(position)
                holder.number.text = currentNumber.toString()
            } else {
                notifyDataSetChanged()
            }

            listener.onNumberChanged()

        }

    }

}