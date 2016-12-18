package com.github.kurtyan.fanfou4j

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.databind.module.SimpleModule
import com.github.kurtyan.fanfou4j.core.FanfouClient
import com.github.kurtyan.fanfou4j.core.FanfouProfile
import com.github.kurtyan.fanfou4j.core.UsernamePasswordAuthenticator
import com.github.kurtyan.fanfou4j.request.favorite.CreateFavoriteRequest
import com.github.kurtyan.fanfou4j.request.favorite.DeleteFavoriteRequest
import com.github.kurtyan.fanfou4j.request.status.CreateStatusRequest
import com.github.kurtyan.fanfou4j.request.status.DeleteStatusRequest
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by yanke on 2016/11/30.
 */

fun main(args: Array<String>) {
    val objectMapper = ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES)
            .registerModule(
                    SimpleModule().addSerializer(Date::class.java, object : JsonSerializer<Date>() {
                        val dateFormatterFactory = object : ThreadLocal<SimpleDateFormat>() {
                            override fun initialValue(): SimpleDateFormat {
                                return SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH)
                            }
                        }

                        override fun serialize(p0: Date?, p1: JsonGenerator?, p2: SerializerProvider?) {
                            p1?.writeString(dateFormatterFactory.get().format(p0))
                        }
                    })
            )

    val username = System.getenv("username")
    val password = System.getenv("password")
    val fanfouProfile = FanfouProfile(authenticator = UsernamePasswordAuthenticator(username, password))
    val fanfouClient = FanfouClient(fanfouProfile)
//    val request = ListPublicTimelineRequest()
//    request.count = 5L
//    request.sinceId = "123"
//    request.maxId = "124"
//
//    val response = fanfouClient.execute(request)

    val request = CreateStatusRequest()
    request.status = "虽然不会写客户端，但是我会写SDK。这是一条来自fanfou4j SDK半成品的测试。Java/Android狗请关注：http://github.com/kurtyan/fanfou4j"
//    request.source = "fanfou4j"

    val response = fanfouClient.execute(request)

    println(
        objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(response)
    )

}