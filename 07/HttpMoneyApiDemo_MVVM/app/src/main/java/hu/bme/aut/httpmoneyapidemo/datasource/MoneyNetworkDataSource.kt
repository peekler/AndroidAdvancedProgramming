package hu.bme.aut.httpmoneyapidemo.datasource

import android.util.Log
import androidx.lifecycle.MutableLiveData
import hu.bme.aut.httpmoneyapidemo.BuildConfig
import hu.bme.aut.httpmoneyapidemo.data.MoneyResult
import hu.bme.aut.httpmoneyapidemo.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MoneyNetworkDataSource {

    fun getMoneyExchange(): MutableLiveData<MoneyResult> {
        val call = RetrofitClient.apiInterface.getRates(BuildConfig.MONEY_API_KEY)

        val moneyResultData = MutableLiveData<MoneyResult>()

        call.enqueue(object: Callback<MoneyResult> {
            override fun onResponse(call: Call<MoneyResult>, response: Response<MoneyResult>) {
                Log.d("DEBUG : ", response.body().toString())
                moneyResultData.value = response.body()
            }

            override fun onFailure(call: Call<MoneyResult>, t: Throwable) {
                Log.d("DEBUG : ", t.message.toString())
            }

        })

        return moneyResultData
    }



}