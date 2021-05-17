package hu.bme.aut.httpmoneyapidemo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hu.bme.aut.httpmoneyapidemo.data.MoneyResult
import hu.bme.aut.httpmoneyapidemo.repository.MoneyRepository
import hu.bme.aut.httpmoneyapidemo.util.NetworkErrorResult
import hu.bme.aut.httpmoneyapidemo.util.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoneyViewModel : ViewModel() {
    private var moneyRepository: MoneyRepository = MoneyRepository()

    private val result = MutableLiveData<MoneyViewState>()

    fun getMoneyLiveData() = result

    fun getMoneyRates() {
        result.value = InProgress

        viewModelScope.launch(Dispatchers.IO) {
            val response = moneyRepository.getMoneyRates()
            when (response) {
                is NetworkResult -> {
                    val moneyResult = response.result as MoneyResult

                    result.postValue(MoneyResponseSuccess(moneyResult))
                }
                is NetworkErrorResult -> {
                    result.postValue(MoneyResponseError(response.errorMessage.message!!))
                }
            }
        }
    }
}