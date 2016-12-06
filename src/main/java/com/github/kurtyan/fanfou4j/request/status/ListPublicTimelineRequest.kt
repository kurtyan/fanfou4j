package com.github.kurtyan.fanfou4j.request.status

import com.github.kurtyan.fanfou4j.core.AbstractRequest
import com.github.kurtyan.fanfou4j.core.HttpMethod
import com.github.kurtyan.fanfou4j.entity.Status

/**
 * Created by yanke on 2016/12/1.
 */
class ListPublicTimelineRequest : AbstractRequest<Array<Status>>(This.action, This.method) {

    object This {
        val action = "/statuses/public_timeline.json"
        val method = HttpMethod.GET
    }

    var count: Long by longDelegate
    var sinceId: String by stringDelegate
    var maxId: String by stringDelegate

}