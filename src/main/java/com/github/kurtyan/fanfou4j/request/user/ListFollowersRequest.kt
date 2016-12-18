package com.github.kurtyan.fanfou4j.request.user

import com.github.kurtyan.fanfou4j.core.AbstractRequest
import com.github.kurtyan.fanfou4j.core.HttpMethod
import com.github.kurtyan.fanfou4j.entity.User
import com.github.kurtyan.fanfou4j.request.RequestMode

/**
 * Created by yanke on 2016/12/18.
 */
class ListFollowersRequest : AbstractRequest<Array<User>>("/users/followers.json", HttpMethod.GET){

    var id: String by stringDelegate
    var count: Int by intDelegate
    var page: Int by intDelegate
    var mode: RequestMode by requestModeDelegate

}