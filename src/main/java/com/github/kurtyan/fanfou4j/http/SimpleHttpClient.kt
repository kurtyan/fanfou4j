package com.github.kurtyan.fanfou4j.http

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

        val os = conn.outputStream
        os.write(queryString.toByteArray(charset(charset)))
        os.flush()
        os.close()

        return parseResponse(conn, responseParser)
    }

    private fun <T> parseResponse(conn: HttpURLConnection, parser: (Reader) -> T): T {
        val reader = conn.inputStream.bufferedReader(kotlin.text.charset(charset))
        return parser.invoke(reader)
    }


    private fun buildQueryString(form: Map<String, String>): String {
        return form.entries.map { "${it.key}=${it.value}" }.joinToString(separator = "&")
    }

}
