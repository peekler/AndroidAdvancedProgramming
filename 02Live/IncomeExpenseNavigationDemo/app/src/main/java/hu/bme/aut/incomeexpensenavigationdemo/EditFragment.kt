package hu.bme.aut.incomeexpensenavigationdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


/**
 * A simple [Fragment] subclass.
 * Use the [EditFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_edit, container, false)

        val fragmentStatePagerAdapter = IncomeExpensePagerAdapter(requireActivity(), 2)
        val mainViewPager = rootView.findViewById<ViewPager2>(R.id.mainViewPager)
        val tabLayout = rootView.findViewById<TabLayout>(R.id.tabLayout)

        mainViewPager.adapter = fragmentStatePagerAdapter

        TabLayoutMediator(tabLayout, mainViewPager) { tab, position ->
            //To get the first name of doppelganger celebrities
            if (position == 0) {
                tab.text = "Income"
            } else {
                tab.text = "Expense"
            }
        }.attach()


        return rootView
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            EditFragment()
    }
}