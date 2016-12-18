package com.github.kurtyan.fanfou4j.request.user

import com.github.kurtyan.fanfou4j.core.AbstractRequest
import com.github.kurtyan.fanfou4j.core.HttpMethod
import com.github.kurtyan.fanfou4j.entity.User
import com.github.kurtyan.fanfou4j.request.RequestMode

/**
 * Created by yanke on 2016/12/18.
 */
class ShowUserRequest : AbstractRequest<User>("/users/show.json", HttpMethod.GET){

    var id: String by stringDelegate
    var mode: RequestMode by requestModeDelegate

}