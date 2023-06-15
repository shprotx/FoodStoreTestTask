package ru.shprot.foodstoretesttask.common.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.shprot.foodstoretesttask.data.dishes.DishesItem
import ru.shprot.foodstoretesttask.R
import ru.shprot.foodstoretesttask.common.interfaces.DishClickListener
import ru.shprot.foodstoretesttask.databinding.ItemDishBinding

class DishesAdapter(
    private val dishes: List<DishesItem>,
    private val listener: DishClickListener
    ) : RecyclerView.Adapter<DishesAdapter.MyViewHolder>() {

    private lateinit var binding: ItemDishBinding


    inner class MyViewHolder(b: ItemDishBinding) : RecyclerView.ViewHolder(b.root) {

        val title: TextView = b.dishTitle
        val image: ImageView = b.dishImage

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onDishClicked(dishes[position])
                }
            }
        }

    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        binding = ItemDishBinding.bind(
            LayoutInflater
            .from(parent.context).inflate(R.layout.item_dish, parent, false))

        return MyViewHolder(binding)

    }




    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = dishes[position]
        holder.title.text = currentItem.name

        Picasso.get().load(currentItem.image_url).into(holder.image)

    }




    override fun getItemCount() : Int {

        return dishes.size

    }

}