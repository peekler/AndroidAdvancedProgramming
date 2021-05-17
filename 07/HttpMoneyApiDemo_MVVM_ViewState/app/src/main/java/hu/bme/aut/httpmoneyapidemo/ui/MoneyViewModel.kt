package hu.bme.aut.httpmoneyapidemo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import hu.bme.aut.httpmoneyapidemo.data.MoneyResult
import hu.bme.aut.httpmoneyapidemo.repository.MoneyRepository

class MoneyViewModel : ViewModel() {
    private var moneyRepository: MoneyRepository = MoneyRepository()

    fun getMoneyRates() : LiveData<MoneyViewState>? {
        return moneyRepository.getMoneyRates()
    }
}