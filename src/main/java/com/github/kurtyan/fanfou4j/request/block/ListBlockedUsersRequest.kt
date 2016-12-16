package com.github.kurtyan.fanfou4j.request.block

import com.github.kurtyan.fanfou4j.core.AbstractRequest
import com.github.kurtyan.fanfou4j.core.HttpMethod
import com.github.kurtyan.fanfou4j.entity.User
import com.github.kurtyan.fanfou4j.request.RequestMode

/**
 * Created by yanke on 2016/12/16.
 */
class ListBlockedUsersRequest : AbstractRequest<Array<User>>("/blocks/blocking.json", HttpMethod.GET){

    var count: Int by intDelegate
    var page: Int by intDelegate
    var mode: RequestMode by requestModeDelegate

}