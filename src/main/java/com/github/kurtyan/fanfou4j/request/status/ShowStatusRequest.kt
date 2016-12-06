package com.github.kurtyan.fanfou4j.request.status

import com.github.kurtyan.fanfou4j.core.AbstractRequest
import com.github.kurtyan.fanfou4j.core.HttpMethod
import com.github.kurtyan.fanfou4j.entity.Status

/**
 * Created by yanke on 2016/12/6.
 */
class ShowStatusRequest : AbstractRequest<Status>("/statuses/show.json", HttpMethod.GET){

    var id: String by stringDelegate

}