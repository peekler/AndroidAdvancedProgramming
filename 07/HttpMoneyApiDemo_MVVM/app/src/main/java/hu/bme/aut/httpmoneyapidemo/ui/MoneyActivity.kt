package hu.bme.aut.httpmoneyapidemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
                object: Observer<MoneyResult> {
                    override fun onChanged(moneyResult: MoneyResult) {
                        binding.tvData.text = moneyResult.rates!!.HUF.toString()

                        moneyViewModel.getMoneyRates()?.removeObserver(this)
                    }
                })
        }

    }
}