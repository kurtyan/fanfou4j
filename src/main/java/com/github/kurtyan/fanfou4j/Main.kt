package com.github.kurtyan.fanfou4j

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.databind.module.SimpleModule
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


    val objectMapper = ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES)
            .registerModule(
                SimpleModule().addDeserializer(Date::class.java, object : JsonDeserializer<Date>() {
                    override fun deserialize(p0: JsonParser?, p1: DeserializationContext?): Date? {
                        return p0?.valueAsString?.let {
                            return@let Date()
                        }
                    }
                })
            )

    val result = httpClient.get("http://api.fanfou.com/statuses/public_timeline.json", mapOf(Pair("count", "10"))) {
        val resultString = it.bufferedReader(charset("utf-8")).readLine()
        val parsedResult: List<Status> = objectMapper.readValue(resultString, object : TypeReference<List<Status>>() {})
        parsedResult
    }

    println(
        objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(result)
    )
}