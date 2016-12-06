package com.github.kurtyan.fanfou4j.request.friend

import com.github.kurtyan.fanfou4j.core.AbstractRequest
import com.github.kurtyan.fanfou4j.core.HttpMethod
import com.github.kurtyan.fanfou4j.entity.User

/**
 * List friends of specified user.
 *
 * Created by yanke on 2016/12/6.
 */
class ListFriendsRequest : AbstractRequest<Array<User>>("/statuses/friends.json", HttpMethod.GET){

    var id: String by stringDelegate        // userId
    var count: Int by intDelegate
    var page: Int by intDelegate

}