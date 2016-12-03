package com.github.kurtyan.fanfou4j.core

import com.fasterxml.jackson.core.type.TypeReference
import com.github.kurtyan.fanfou4j.http.SimpleHttpClient
import java.io.Reader
import java.lang.reflect.Type

/**
 * Created by yanke on 2016/12/1.
 */
class FanfouClient(val profile: FanfouProfile) {

    val client = SimpleHttpClient(authenticator = profile.authenticator)

    private fun <T> createJsonParser(request: AbstractRequest<T>): (Reader) -> T = {
        JsonMapperFactory.jsonMapper().readValue(it, object : TypeReference<T>() {
            override fun getType(): Type {
                return request.getResponseType()
            }
        })
    }

    fun <T> execute(request: AbstractRequest<T>): T {
        val responseParser = createJsonParser(request)

        return when (request.httpMethod) {
            HttpMethod.GET -> client.get(profile.getRequestUrl(request.action), request.getParameter(), responseParser)
            HttpMethod.POST -> client.post(profile.getRequestUrl(request.action), request.getParameter(), responseParser)
            else -> throw UnsupportedOperationException("Method=${request.httpMethod} not supported")
        }
    }

}