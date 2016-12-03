package com.github.kurtyan.fanfou4j.core

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.databind.module.SimpleModule
import com.github.kurtyan.fanfou4j.util.DateParser
import java.util.*

/**
 * Created by yanke on 2016/12/3.
 */
object JsonMapperFactory {

    fun jsonMapper(): ObjectMapper {
        return ObjectMapper()
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
    }

}