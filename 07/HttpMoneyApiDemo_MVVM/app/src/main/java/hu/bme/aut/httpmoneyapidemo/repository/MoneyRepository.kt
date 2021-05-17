package hu.bme.aut.httpmoneyapidemo.repository

import androidx.lifecycle.MutableLiveData
import hu.bme.aut.httpmoneyapidemo.data.MoneyResult
import hu.bme.aut.httpmoneyapidemo.datasource.MoneyNetworkDataSource

class MoneyRepository {
    fun getMoneyRates() : MutableLiveData<MoneyResult> {
        return MoneyNetworkDataSource.getMoneyExchange()
    }
}