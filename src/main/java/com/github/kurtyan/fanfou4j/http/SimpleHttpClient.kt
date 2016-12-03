package com.github.kurtyan.fanfou4j.http

import com.github.kurtyan.fanfou4j.core.FanfouClient
import com.github.kurtyan.fanfou4j.exception.FanfouClientException
import java.io.Reader
import java.net.HttpURLConnection
import java.net.URL

/**
 * A simple http client written in pure java, based on java.net.URLConnection.
 * At this time, http methods other than 'POST with urlencoded form' are not implemented because they are not necessary in this project.

 * Created by kurtyan on 16-2-26.
 */
class SimpleHttpClient(private val charset: String = "utf-8", private val authenticator: Authenticator? = null) {

    fun <T> get(url: String, query: Map<String, String>, responseParser: (Reader) -> T): T {
        val finalUrl = "${url}?${buildQueryString(query)}"
        val conn = URL(finalUrl).openConnection() as HttpURLConnection

        authenticator?.auth(conn)
        conn.doOutput = false
        conn.requestMethod = "GET"

        return parseResponse(conn, responseParser)
    }

    fun <T> post(url: String, form: Map<String, String>, responseParser: (Reader) -> T): T {
        val queryString = this.buildQueryString(form)

        val conn = URL(url).openConnection() as HttpURLConnection

        authenticator?.auth(conn)
        conn.doOutput = true
        conn.requestMethod = "POST"
        conn.setRequestProperty("Accept-Charset", charset)
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + charset)

        conn.outputStream.bufferedWriter(charset(charset)).use {
            it.write(queryString)
            it.flush()
        }

        return parseResponse(conn, responseParser)
    }

    private fun <T> parseResponse(conn: HttpURLConnection, parser: (Reader) -> T): T {
        try {
            val reader = conn.inputStream.bufferedReader(charset(charset))
            return parser.invoke(reader)
        } catch (e: Exception) {
            val text = conn.errorStream.bufferedReader(charset(charset)).readText()
            throw FanfouClientException()
        }
    }


    private fun buildQueryString(form: Map<String, String>): String {
        return form.entries.map { "${it.key}=${it.value}" }.joinToString(separator = "&")
    }

}
