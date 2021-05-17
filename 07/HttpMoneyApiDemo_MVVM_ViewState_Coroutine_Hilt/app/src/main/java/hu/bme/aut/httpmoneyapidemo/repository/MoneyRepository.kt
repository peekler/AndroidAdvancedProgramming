package hu.bme.aut.httpmoneyapidemo.repository

import androidx.lifecycle.MutableLiveData
import hu.bme.aut.httpmoneyapidemo.data.MoneyResult
import hu.bme.aut.httpmoneyapidemo.datasource.MoneyNetworkDataSource
import hu.bme.aut.httpmoneyapidemo.ui.MoneyViewState
import hu.bme.aut.httpmoneyapidemo.util.NetworkResponse

class MoneyRepository(private val moneyNetworkDataSource: MoneyNetworkDataSource) {
    suspend fun getMoneyRates() : NetworkResponse<Any> {
        return moneyNetworkDataSource.getMoneyExchange()
    }
}