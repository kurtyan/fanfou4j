package com.github.kurtyan.fanfou4j.request.friend

import com.github.kurtyan.fanfou4j.core.AbstractRequest
import com.github.kurtyan.fanfou4j.core.HttpMethod
import com.github.kurtyan.fanfou4j.entity.User

/**
 * Created by yanke on 2016/12/7.
 */
class ListFollowRequestsRequest  : AbstractRequest<Array<User>>("/friendships/requests.json", HttpMethod.POST){

    var count: Int by intDelegate
    var page: Int by intDelegate

}
