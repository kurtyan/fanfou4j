package com.github.kurtyan.fanfou4j.util

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by yanke on 2016/12/1.
 */
object DateParser {

    val dateFormatterFactory = object : ThreadLocal<SimpleDateFormat>() {
        override fun initialValue(): SimpleDateFormat {
            return SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH)
        }
    }

    public fun parse(text: String): Date {
        return dateFormatterFactory.get().parse(text)
    }

}