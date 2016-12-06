package com.github.kurtyan.fanfou4j.request.status

import com.github.kurtyan.fanfou4j.core.AbstractRequest
import com.github.kurtyan.fanfou4j.core.HttpMethod
import com.github.kurtyan.fanfou4j.entity.Status

/**
 * Created by yanke on 2016/12/4.
 */
class DeleteStatusRequest : AbstractRequest<Status>("/statuses/destroy.json", HttpMethod.POST){

    var id: String by stringDelegate

}