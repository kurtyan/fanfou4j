package com.github.kurtyan.fanfou4j.core

/**
 * Created by yanke on 2016/12/4.
 */
abstract class AbstractRestfulRequest<T>(action: String, httpMethod: HttpMethod) : AbstractRequest<T>(action, httpMethod) {

    override val action: String
        get() {
            val rawAction = super.action
            val parameters = super.getParameter()

            var action = rawAction
            parameters.forEach {
                action = action.replace(":${it.key}", it.value)
            }

            return action
        }

    override fun getParameter(): Map<String, String> {
        return mapOf()
    }

}