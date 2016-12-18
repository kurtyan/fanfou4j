package com.github.kurtyan.fanfou4j.request.user

import com.github.kurtyan.fanfou4j.core.AbstractRequest
import com.github.kurtyan.fanfou4j.core.HttpMethod
import com.github.kurtyan.fanfou4j.entity.User
import com.github.kurtyan.fanfou4j.request.RequestMode

/**
 * Created by yanke on 2016/12/18.
 */
class ListTaggedUsersRequest : AbstractRequest<Array<User>>("/users/tagged.json", HttpMethod.GET){

    var tag: String by stringDelegate
    var count: Int by intDelegate
    var page: Int by intDelegate
    var mode: RequestMode by requestModeDelegate

}