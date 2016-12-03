package com.github.kurtyan.fanfou4j.core

import com.github.kurtyan.fanfou4j.util.CapitalizeUtil
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.util.*
import kotlin.reflect.KProperty

/**
 * Created by yanke on 2016/12/1.
 */
abstract class AbstractRequest<T>(val action: String, val httpMethod: HttpMethod) {

    protected val parameterMap: HashMap<String, Any?> = HashMap<String, Any?>()
    val longDelegate = RequestParameterDelegate<Long>(parameterMap)
    val intDelegate = RequestParameterDelegate<Int>(parameterMap)
    val booleanDelegate = RequestParameterDelegate<Boolean>(parameterMap)
    val stringDelegate = RequestParameterDelegate<String>(parameterMap)

    public fun getResponseType(): Type {
        val superClass = javaClass.genericSuperclass
        if (superClass is Class<*>) { // sanity check, should never happen
            throw IllegalArgumentException("Internal error: TypeReference constructed without actual type information")
        }
        return (superClass as ParameterizedType).actualTypeArguments[0]
    }

    public fun getParameter(): Map<String, String> {
        return parameterMap
                .filter { it.value != null }
                .mapKeys { CapitalizeUtil.toUnderScore(it.key) }
                .mapValues { it.value.toString() }
    }

}