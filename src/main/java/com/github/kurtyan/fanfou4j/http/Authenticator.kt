package com.github.kurtyan.fanfou4j.http

import java.net.HttpURLConnection

/**
 * Created by yanke on 2016/5/2.
 */
interface Authenticator {
    fun auth(conn: HttpURLConnection): HttpURLConnection
}