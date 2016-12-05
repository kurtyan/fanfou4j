package com.github.kurtyan.fanfou4j.request.status

import com.github.kurtyan.fanfou4j.core.AbstractRequest
import com.github.kurtyan.fanfou4j.core.HttpMethod
import com.github.kurtyan.fanfou4j.entity.Status

/**
 * Created by yanke on 2016/12/4.
 */
class CreateStatusRequest : AbstractRequest<Status>("/statuses/update.json", HttpMethod.POST) {

    var status: String by stringDelegate
    var source: String by stringDelegate

}
