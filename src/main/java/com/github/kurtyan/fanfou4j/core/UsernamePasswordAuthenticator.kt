package com.github.kurtyan.fanfou4j.core

import com.github.kurtyan.fanfou4j.http.Authenticator
import java.net.HttpURLConnection
import java.util.*

/**
 * Created by yanke on 2016/12/1.
 */
class UsernamePasswordAuthenticator(val username: String, val password: String) : Authenticator {

    override fun auth(conn: HttpURLConnection): HttpURLConnection {
        val authorization = Base64.getEncoder().encodeToString("$username:$password".toByteArray(charset("utf-8")))
        conn.setRequestProperty("Authorization", "Basic $authorization")
        return conn
    }

}