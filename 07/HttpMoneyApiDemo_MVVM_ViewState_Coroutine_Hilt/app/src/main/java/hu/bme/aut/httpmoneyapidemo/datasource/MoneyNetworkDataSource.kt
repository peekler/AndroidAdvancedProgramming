package hu.bme.aut.httpmoneyapidemo.datasource

import hu.bme.aut.httpmoneyapidemo.BuildConfig
import hu.bme.aut.httpmoneyapidemo.network.MoneyAPI
import hu.bme.aut.httpmoneyapidemo.util.NetworkErrorResult
import hu.bme.aut.httpmoneyapidemo.util.NetworkResponse
import hu.bme.aut.httpmoneyapidemo.util.NetworkResult
import java.lang.Exception

class MoneyNetworkDataSource(private val moneyAPI: MoneyAPI) {

    suspend fun getMoneyExchange(): NetworkResponse<Any> {
        try {
            val response = moneyAPI.getRates(BuildConfig.MONEY_API_KEY)

            response?.let {
                return NetworkResult(it.body()!!)
            }

            return NetworkErrorResult(Exception("No data"))
        } catch (e: Exception) {
            return NetworkErrorResult(e)
        }
    }


}