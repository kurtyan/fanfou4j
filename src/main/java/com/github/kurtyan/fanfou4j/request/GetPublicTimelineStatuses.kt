package com.github.kurtyan.fanfou4j.request

import com.github.kurtyan.fanfou4j.core.AbstractRequest
import com.github.kurtyan.fanfou4j.core.HttpMethod
import com.github.kurtyan.fanfou4j.entity.Status

/**
 * Created by yanke on 2016/12/1.
 */
class GetPublicTimelineStatuses : AbstractRequest<List<Status>>() {

    var count: Long by longDelegate
    var sinceId: String by stringDelegate
    var maxId: String by stringDelegate

    override fun getMethod(): HttpMethod {
        return HttpMethod.GET
    }

    override fun getUrl(): String {
        return "http://api.fanfou.com/statuses/public_timeline.json"
    }

}