package com.github.kurtyan.fanfou4j.request.account

import com.github.kurtyan.fanfou4j.core.AbstractRequest
import com.github.kurtyan.fanfou4j.core.HttpMethod
import com.github.kurtyan.fanfou4j.entity.User
import com.github.kurtyan.fanfou4j.request.RequestMode

/**
 * Created by yanke on 2016/12/19.
 */
class UpdateProfileRequest : AbstractRequest<User>("/account/update_profile.json", HttpMethod.POST){

    var url: String by stringDelegate
    var location: String by stringDelegate
    var description: String by stringDelegate
    var name : String by stringDelegate
    var email: String by stringDelegate

    var mode: RequestMode by requestModeDelegate

}