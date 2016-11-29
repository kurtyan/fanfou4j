package com.github.kurtyan.fanfou4j

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.github.kurtyan.fanfou4j.entity.Status
import com.github.kurtyan.fanfou4j.http.Authenticator
import com.github.kurtyan.fanfou4j.http.SimpleHttpClient
import java.net.HttpURLConnection
import java.util.*

/**
 * Created by yanke on 2016/11/30.
 */

fun main(args: Array<String>) {
    val digest = System.getenv("digest")
    val httpClient = SimpleHttpClient(
        authenticator = object : Authenticator {
            override fun auth(conn: HttpURLConnection): HttpURLConnection {
                conn.setRequestProperty("Authorization", digest)
                return conn
            }
        }
    )

    val objectMapper = ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    val result = httpClient.get("http://api.fanfou.com/statuses/public_timeline.json", HashMap()) {
        val resultString = it.bufferedReader(charset("utf-8")).readLine()
        val parsedResult: List<Status> = objectMapper.readValue(resultString, object : TypeReference<List<Status>>() {})
        parsedResult
    }

    println(
        objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(result)
    )
}