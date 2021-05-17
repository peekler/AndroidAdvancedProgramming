package hu.bme.aut.httpmoneyapidemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import hu.bme.aut.httpmoneyapidemo.data.MoneyResult
import hu.bme.aut.httpmoneyapidemo.databinding.ActivityMainBinding

class MoneyActivity : AppCompatActivity() {

    private val moneyViewModel : MoneyViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

        binding.btnGetMoney.setOnClickListener {
            moneyViewModel.getMoneyRates()?.observe(this,
                { moneyViewState -> render(moneyViewState) })
        }
    }

    private fun render(result: MoneyViewState) {
        when (result) {
            is InProgress -> {
                binding.progressLoad.visibility = View.VISIBLE
            }
            is MoneyResponseSuccess -> {
                binding.progressLoad.visibility = View.GONE
                binding.tvData.text = result.data.rates!!.HUF.toString()
            }
            is MoneyResponseError -> {
                binding.progressLoad.visibility = View.GONE
                binding.tvData.text = result.exceptionMsg
            }
        }
    }
}