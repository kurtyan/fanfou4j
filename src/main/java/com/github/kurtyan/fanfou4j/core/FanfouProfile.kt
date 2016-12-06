package com.github.kurtyan.fanfou4j.core

import com.github.kurtyan.fanfou4j.http.Authenticator

/**
 * Created by yanke on 2016/12/3.
 */
class FanfouProfile(val endpoint: String = "http://api.fanfou.com", val authenticator: Authenticator) {

    constructor(authenticator: Authenticator) : this("http://api.fanfou.com", authenticator)

    fun getRequestUrl(action: String): String {
        return "$endpoint$action"
    }

}