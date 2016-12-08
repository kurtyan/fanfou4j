package com.github.kurtyan.fanfou4j.request.friend

import com.github.kurtyan.fanfou4j.core.AbstractRequest
import com.github.kurtyan.fanfou4j.core.HttpMethod
import com.github.kurtyan.fanfou4j.entity.User

/**
 * Created by yanke on 2016/12/8.
 */
class AcceptFollowRequestRequest : AbstractRequest<User>("/friendships/accept.json", HttpMethod.POST){

    var id: String by stringDelegate

}