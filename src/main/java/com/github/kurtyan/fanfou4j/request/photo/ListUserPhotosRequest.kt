package com.github.kurtyan.fanfou4j.request.photo

import com.github.kurtyan.fanfou4j.core.AbstractRequest
import com.github.kurtyan.fanfou4j.core.HttpMethod
import com.github.kurtyan.fanfou4j.entity.Status

/**
 * Created by yanke on 2016/12/11.
 */
class ListUserPhotosRequest : AbstractRequest<List<Status>>("/photos/user_timeline.json", HttpMethod.GET){

    var id: String by stringDelegate        // userId
    var sinceId: String by stringDelegate
    var maxId: String by stringDelegate
    var count: Int by intDelegate
    var page: Int by intDelegate

}