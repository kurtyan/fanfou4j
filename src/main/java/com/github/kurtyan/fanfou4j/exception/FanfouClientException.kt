package com.github.kurtyan.fanfou4j.exception

/**
 * Created by yanke on 2016/12/4.
 */
class FanfouClientException(val errorCode: Int, errorMessage: String, cause: Throwable) : Exception(errorMessage, cause) {
}