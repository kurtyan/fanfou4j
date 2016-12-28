package com.github.kurtyan.fanfou4j.test

/**
 * Created by yanke on 2016/12/28.
 */
class ApiTestContext {

    var response: Object? = null

    fun withResponse(response: Object): ApiTestContext {
        this.response = response
        return this;
    }

}