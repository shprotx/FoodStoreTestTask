package ru.shprot.foodstoretesttask.ui.dishes

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayout
import ru.shprot.foodstoretesttask.MainViewModel
import ru.shprot.foodstoretesttask.R
import ru.shprot.foodstoretesttask.common.interfaces.DishClickListener
import ru.shprot.foodstoretesttask.common.adapters.DishesAdapter
import ru.shprot.foodstoretesttask.data.dishes.DishesItem
import ru.shprot.foodstoretesttask.databinding.FragmentCategoryBinding
import ru.shprot.foodstoretesttask.ui.item.ItemDialog

class CategoryFragment : Fragment(), DishClickListener, TabLayout.OnTabSelectedListener {

    lateinit var binding : FragmentCategoryBinding
    private val viewModel = MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCategoryBinding.bind(
            inflater.inflate(R.layout.fragment_category, container, false)
        )

        return binding.root

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabsList = getTabsTitles()

        setCategoryName()
        createTabs(tabsList)
        addListeners()

        binding.rvDishes.adapter = DishesAdapter(viewModel.dishes, this)

    }




    private fun setCategoryName() {

        binding.currentCategoryTextView.text = arguments?.getString("categoryName")

    }




    private fun createTabs(tabsList: List<String>) {

        for (i in tabsList) {

            val customTab = LayoutInflater.from(context).inflate(R.layout.item_tab, null)
            val tabTextView = customTab.findViewById<TextView>(R.id.tabTitle)
            val tab = binding.tabLayout.newTab()

            tabTextView.text = i
            tab.customView = customTab
            tab.text = i

            binding.tabLayout.addTab(tab)

        }

        binding.tabLayout.getTabAt(0)?.customView?.findViewById<TextView>(R.id.tabTitle)
            ?.setTextColor(Color.parseColor("#FFFFFF"))

    }




    private fun addListeners() {

        binding.tabLayout.addOnTabSelectedListener(this)
        binding.goBack.setOnClickListener { findNavController().popBackStack() }

    }




    private fun getTabsTitles(): List<String> {

        val tabsList = mutableListOf<String>()

        for (i in viewModel.dishes)
            for (j in i.tegs)
                if (!tabsList.contains(j))
                    tabsList.add(j)

        return tabsList

    }




    override fun onDishClicked(item: DishesItem) {

        val fragmentManager = activity?.supportFragmentManager
        if (fragmentManager != null)
            ItemDialog(item).show(fragmentManager, "TAG")

    }




    override fun onTabSelected(tab: TabLayout.Tab?) {

        val view = tab?.customView
        val textView = view?.findViewById<TextView>(R.id.tabTitle)
        val currentDishes = mutableListOf<DishesItem>()

        textView?.setTextColor(Color.parseColor("#FFFFFF"))

        for (i in viewModel.dishes)
            if (i.tegs.contains(tab?.text))
                currentDishes.add(i)

        binding.rvDishes.adapter = DishesAdapter(currentDishes, this@CategoryFragment)

    }




    override fun onTabUnselected(tab: TabLayout.Tab?) {

        val view = tab?.customView
        val textView = view?.findViewById<TextView>(R.id.tabTitle)
        textView?.setTextColor(Color.parseColor("#000000"))

    }




    override fun onTabReselected(tab: TabLayout.Tab?) {
        TODO("Not yet implemented")
    }

}