package com.github.kurtyan.fanfou4j.core

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.databind.module.SimpleModule
import com.github.kurtyan.fanfou4j.http.Authenticator
import com.github.kurtyan.fanfou4j.http.SimpleHttpClient
import com.github.kurtyan.fanfou4j.util.DateParser
import java.io.Reader
import java.lang.reflect.Type
import java.util.*

/**
 * Created by yanke on 2016/12/1.
 */
class FanfouClient(profile: Authenticator) {

    val client = SimpleHttpClient(authenticator = profile)
    val objectMapper: ObjectMapper = ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES)
            .registerModule(
                    SimpleModule().addDeserializer(Date::class.java, object : JsonDeserializer<Date>() {
                        override fun deserialize(p0: JsonParser?, p1: DeserializationContext?): Date? {
                            return p0?.valueAsString?.let {
                                return DateParser.parse(it)
                            }
                        }
                    })
            )

    private fun <T> createJsonParser(request: AbstractRequest<T>): (Reader) -> T = {
        objectMapper.readValue(it, object : TypeReference<T>() {
            override fun getType(): Type {
                return request.getResponseType()
            }
        })
    }

    fun <T> execute(request: AbstractRequest<T>): T {
        val responseParser = createJsonParser(request)

        return when (request.getMethod()) {
            HttpMethod.GET -> client.get(request.getUrl(), request.getParameter(), responseParser)
            HttpMethod.POST -> client.post(request.getUrl(), request.getParameter(), responseParser)
            else -> throw UnsupportedOperationException("Method=${request.getMethod()} not supported")
        }
    }

}