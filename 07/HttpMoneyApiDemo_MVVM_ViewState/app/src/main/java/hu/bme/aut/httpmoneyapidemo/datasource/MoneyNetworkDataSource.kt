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
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MoneyNetworkDataSource {

    fun getMoneyExchange(): MutableLiveData<MoneyViewState> {
        val call = RetrofitClient.apiInterface.getRates(BuildConfig.MONEY_API_KEY)

        val moneyResultData = MutableLiveData<MoneyViewState>()
        moneyResultData.value = InProgress

        call.enqueue(object: Callback<MoneyResult> {
            override fun onResponse(call: Call<MoneyResult>, response: Response<MoneyResult>) {
                Log.d("DEBUG : ", response.body().toString())
                moneyResultData.value = MoneyResponseSuccess(response.body()!!)
            }

            override fun onFailure(call: Call<MoneyResult>, t: Throwable) {
                Log.d("DEBUG : ", t.message.toString())
                moneyResultData.value = MoneyResponseError(t.message!!)
            }

        })

        return moneyResultData
    }



}