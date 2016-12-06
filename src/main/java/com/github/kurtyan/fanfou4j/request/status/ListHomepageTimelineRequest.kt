package com.github.kurtyan.fanfou4j.request.status

import com.github.kurtyan.fanfou4j.core.AbstractRequest
import com.github.kurtyan.fanfou4j.core.HttpMethod
import com.github.kurtyan.fanfou4j.entity.Status

/**
 * List homepage timeline of specified user.
 *
 * Created by yanke on 2016/12/6.
 */
class ListHomepageTimelineRequest : AbstractRequest<Array<Status>>("/statuses/home_timeline.json", HttpMethod.GET){

    var id: String by stringDelegate        // userId
    var sinceId: String by stringDelegate
    var maxId: String by stringDelegate
    var count: Int by intDelegate
    var page: Int by intDelegate

}