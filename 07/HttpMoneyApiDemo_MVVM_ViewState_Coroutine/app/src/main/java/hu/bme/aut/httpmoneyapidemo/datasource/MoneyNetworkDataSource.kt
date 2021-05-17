package hu.bme.aut.httpmoneyapidemo.datasource

import android.util.Log
import androidx.lifecycle.MutableLiveData
import hu.bme.aut.httpmoneyapidemo.BuildConfig
import hu.bme.aut.httpmoneyapidemo.data.MoneyResult
import hu.bme.aut.httpmoneyapidemo.network.RetrofitClient
import hu.bme.aut.httpmoneyapidemo.ui.InProgress
import hu.bme.aut.httpmoneyapidemo.ui.MoneyResponseError
import hu.bme.aut.httpmoneyapidemo.ui.MoneyResponseSuccess
import hu.bme.aut.httpmoneyapidemo.ui.MoneyViewState
import hu.bme.aut.httpmoneyapidemo.util.NetworkErrorResult
import hu.bme.aut.httpmoneyapidemo.util.NetworkResponse
import hu.bme.aut.httpmoneyapidemo.util.NetworkResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

object MoneyNetworkDataSource {

    suspend fun getMoneyExchange(): NetworkResponse<Any> {
        try {
            val response = RetrofitClient.apiInterface.getRates(BuildConfig.MONEY_API_KEY)

            response?.let {
                return NetworkResult(it.body()!!)
            }

            return NetworkErrorResult(Exception("No data"))
        } catch (e: Exception) {
            return NetworkErrorResult(e)
        }
    }



}