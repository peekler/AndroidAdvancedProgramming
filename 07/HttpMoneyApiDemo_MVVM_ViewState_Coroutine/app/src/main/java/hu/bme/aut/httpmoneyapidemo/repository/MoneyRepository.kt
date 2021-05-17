package hu.bme.aut.httpmoneyapidemo.repository

import androidx.lifecycle.MutableLiveData
import hu.bme.aut.httpmoneyapidemo.data.MoneyResult
import hu.bme.aut.httpmoneyapidemo.datasource.MoneyNetworkDataSource
import hu.bme.aut.httpmoneyapidemo.ui.MoneyViewState
import hu.bme.aut.httpmoneyapidemo.util.NetworkResponse

class MoneyRepository {
    suspend fun getMoneyRates() : NetworkResponse<Any> {
        return MoneyNetworkDataSource.getMoneyExchange()
    }
}