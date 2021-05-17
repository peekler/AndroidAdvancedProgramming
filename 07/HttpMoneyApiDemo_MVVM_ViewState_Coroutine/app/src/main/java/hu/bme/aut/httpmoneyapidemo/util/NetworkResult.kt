package hu.bme.aut.httpmoneyapidemo.util

/**
 *                           NetworkResult
 *                         /
 *                       /
 *  NetworkResponse
 *                       \
 *                        \
 *                         NetworkErrorResult
 *
 */
sealed class NetworkResponse<out T: Any>

class NetworkResult<K : Any>(val result: K) : NetworkResponse<K>()

class NetworkErrorResult(val errorMessage: Exception) : NetworkResponse<Nothing>()
