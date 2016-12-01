package com.github.kurtyan.fanfou4j.util

import org.junit.Test

import org.junit.Assert.*

/**
 * Created by yanke on 2016/12/1.
 */
class CapitalizeUtilTest {

    @Test
    fun toUnderScore() {
        assertEquals("capitalize_util_test", CapitalizeUtil.toUnderScore("capitalizeUtilTest"))
        assertEquals("capitalize1_util_test", CapitalizeUtil.toUnderScore("capitalize1UtilTest"))
        assertEquals("capitalize1util_test", CapitalizeUtil.toUnderScore("capitalize1utilTest"))
        assertEquals("capitalizeutiltest", CapitalizeUtil.toUnderScore("capitalizeutiltest"))
    }

    @Test
    fun toCamelCase() {
        assertEquals("capitalizeUtilTest", CapitalizeUtil.toCamelCase("capitalize_util_test"))
        assertEquals("capitalize1utilTest", CapitalizeUtil.toCamelCase("capitalize_1util_test"))
        assertEquals("capitalize1UtilTest", CapitalizeUtil.toCamelCase("capitalize1_util_test"))
        assertEquals("capitalizeutiltest", CapitalizeUtil.toCamelCase("capitalizeutiltest"))
    }

}