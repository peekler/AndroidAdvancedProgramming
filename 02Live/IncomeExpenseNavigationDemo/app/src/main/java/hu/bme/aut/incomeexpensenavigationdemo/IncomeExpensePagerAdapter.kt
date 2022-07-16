package hu.bme.aut.incomeexpensenavigationdemo

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class IncomeExpensePagerAdapter(activity: FragmentActivity, val itemsCount: Int) :
    FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return itemsCount
    }

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) {
            EditIncomeFragment.newInstance()
        } else {
            EditExpenseFragment.newInstance()
        }
    }


}