package com.github.kurtyan.fanfou4j

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.databind.module.SimpleModule
import com.github.kurtyan.fanfou4j.core.FanfouClient
import com.github.kurtyan.fanfou4j.core.UsernamePasswordProfile
import com.github.kurtyan.fanfou4j.request.GetPublicTimelineStatuses
import java.util.*

/**
 * Created by yanke on 2016/11/30.
 */

fun main(args: Array<String>) {
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

    val username = System.getenv("username")
    val password = System.getenv("password")
    val fanfouClient = FanfouClient(UsernamePasswordProfile(username, password))
    val request = GetPublicTimelineStatuses()
    request.count = 5L
    request.sinceId = "123"

    val response = fanfouClient.execute(request)

    println(
        objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(response)
    )

}