package ru.shprot.foodstoretesttask.common.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.shprot.foodstoretesttask.data.categories.CategoryItem
import ru.shprot.foodstoretesttask.R
import ru.shprot.foodstoretesttask.common.interfaces.CategoryClickListener
import ru.shprot.foodstoretesttask.databinding.ItemCategoryBinding

class CategoriesAdapter(
    private val categories: List<CategoryItem>,
    private val clickListener: CategoryClickListener
) : RecyclerView.Adapter<CategoriesAdapter.MyViewHolder>() {

    private lateinit var binding: ItemCategoryBinding


    inner class MyViewHolder(b: ItemCategoryBinding) : RecyclerView.ViewHolder(b.root) {

        val title: TextView = b.categoryTitle
        val image: ImageView = b.categoryImage

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    clickListener.onItemClicked(categories[position])
                }
            }
        }

    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        binding = ItemCategoryBinding.bind(LayoutInflater
                .from(parent.context).inflate(R.layout.item_category, parent, false))

        return MyViewHolder(binding)

    }




    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = categories[position]
        holder.title.text = currentItem.name

        Picasso.get().load(currentItem.image_url).into(holder.image)

    }




    override fun getItemCount() : Int {

        return categories.size

    }

}