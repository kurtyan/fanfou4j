package com.github.kurtyan.fanfou4j.http

import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import java.util.*

/**
 * A simple http client written in pure java, based on java.net.URLConnection.
 * At this time, http methods other than 'POST with urlencoded form' are not implemented because they are not necessary in this project.

 * Created by kurtyan on 16-2-26.
 */
class SimpleHttpClient(private val charset: String = "utf-8", private val authenticator: Authenticator? = null) {

    fun post(url: String, form: Map<String, String>): String? {
        return this.post(url, form, { inputStream: InputStream ->
            readFromStream(inputStream, charset)
        })
    }

    fun <T> get(url: String, form: Map<String, String>, responseParser: (InputStream) -> T): T {
        val finalUrl = "${url}?${buildQueryString(form)}"
        val conn = URL(finalUrl).openConnection() as HttpURLConnection

        authenticator?.auth(conn)
        conn.doOutput = false
        conn.requestMethod = "GET"
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=${charset}")

        return responseParser.invoke(conn.inputStream)
    }

    fun <T> post(url: String, form: Map<String, String>, responseParser: (InputStream) -> T): T {
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

        return responseParser.invoke(conn.inputStream)
    }

    private fun buildQueryString(form: Map<String, String>): String {
        return form.entries.map { "${it.key}=${it.value}" }.joinToString(separator = "&")
    }

    private fun readFromStream(`is`: InputStream, charset: String): String? {
        val sc = Scanner(`is`, charset).useDelimiter("\\A")
        return if (sc.hasNext()) sc.next() else null
    }

}
