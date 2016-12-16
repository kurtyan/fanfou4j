package com.github.kurtyan.fanfou4j.request.block

import com.github.kurtyan.fanfou4j.core.AbstractRequest
import com.github.kurtyan.fanfou4j.core.HttpMethod
import com.github.kurtyan.fanfou4j.entity.User
import com.github.kurtyan.fanfou4j.request.RequestMode

/**
 * Created by yanke on 2016/12/16.
 */
class VerifyBlockedRequest : AbstractRequest<User>("/blocks/exists.json", HttpMethod.GET) {

    var id: String by stringDelegate
    var mode: RequestMode by requestModeDelegate

}