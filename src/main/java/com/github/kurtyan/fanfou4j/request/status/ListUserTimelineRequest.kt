package com.github.kurtyan.fanfou4j.request.status

import com.github.kurtyan.fanfou4j.core.AbstractRequest
import com.github.kurtyan.fanfou4j.core.HttpMethod
import com.github.kurtyan.fanfou4j.entity.Status

/**
 * List timeline of specified user.
 *
 * Created by yanke on 2016/12/6.
 */
class ListUserTimelineRequest : AbstractRequest<Array<Status>>("/statuses/user_timeline.json", HttpMethod.GET){

    var id: String by stringDelegate        // userId
    var sinceId: String by stringDelegate
    var maxId: String by stringDelegate

}