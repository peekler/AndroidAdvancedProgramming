package hu.bme.aut.httpmoneyapidemo.repository

import androidx.lifecycle.MutableLiveData
import hu.bme.aut.httpmoneyapidemo.data.MoneyResult
import hu.bme.aut.httpmoneyapidemo.datasource.MoneyNetworkDataSource
import hu.bme.aut.httpmoneyapidemo.ui.MoneyViewState

class MoneyRepository {
    fun getMoneyRates() : MutableLiveData<MoneyViewState> {
        return MoneyNetworkDataSource.getMoneyExchange()
    }
}