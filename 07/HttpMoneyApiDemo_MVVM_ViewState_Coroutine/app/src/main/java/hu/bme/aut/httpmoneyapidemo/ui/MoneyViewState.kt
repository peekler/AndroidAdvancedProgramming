package hu.bme.aut.httpmoneyapidemo.ui

import hu.bme.aut.httpmoneyapidemo.data.MoneyResult

sealed class MoneyViewState

object InProgress : MoneyViewState()
data class MoneyResponseSuccess(val data: MoneyResult) : MoneyViewState()
data class MoneyResponseError(val exceptionMsg: String) : MoneyViewState()