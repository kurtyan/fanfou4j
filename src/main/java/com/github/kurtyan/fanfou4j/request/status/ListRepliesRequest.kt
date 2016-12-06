package com.github.kurtyan.fanfou4j.request.status

import com.github.kurtyan.fanfou4j.core.AbstractRequest
import com.github.kurtyan.fanfou4j.core.HttpMethod
import com.github.kurtyan.fanfou4j.entity.Status

/**
 * List replies of current user.
 *
 * Created by yanke on 2016/12/6.
 */
class ListRepliesRequest : AbstractRequest<Array<Status>>("/statuses/replies.json", HttpMethod.GET){

    var sinceId: String by stringDelegate
    var maxId: String by stringDelegate
    var count: Int by intDelegate
    var page: Int by intDelegate

}