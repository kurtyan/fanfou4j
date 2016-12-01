package com.github.kurtyan.fanfou4j.core

import java.util.*
import kotlin.reflect.KProperty

/**
 * Created by yanke on 2016/12/1.
 */
class RequestParameterDelegate<T>(val parameterMap: HashMap<String, Any?>) {

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return parameterMap.get("${property.name}") as T
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        parameterMap.put("${property.name}", value)
    }

}