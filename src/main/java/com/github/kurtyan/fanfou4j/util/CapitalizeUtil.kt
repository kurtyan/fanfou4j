package com.github.kurtyan.fanfou4j.util

/**
 * Created by yanke on 2016/12/1.
 */
object CapitalizeUtil {

    fun toUnderScore(text: String): String {
        return text
                .toCharArray()
                .map { if (it.isUpperCase()) "_${it.toLowerCase()}" else it.toString() }
                .joinToString("")
    }

    fun toCamelCase(text: String): String {
        return text
                .split('_')
                .mapIndexed { i, s -> if (i == 0) s else s.capitalize() }
                .joinToString("")
    }

}