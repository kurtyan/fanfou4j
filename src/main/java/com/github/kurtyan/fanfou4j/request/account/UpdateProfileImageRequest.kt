package com.github.kurtyan.fanfou4j.request.account

import com.github.kurtyan.fanfou4j.core.AbstractRequest
import com.github.kurtyan.fanfou4j.core.HttpMethod
import com.github.kurtyan.fanfou4j.entity.User
import com.github.kurtyan.fanfou4j.request.RequestMode

/**
 * Created by yanke on 2016/12/19.
 */
class UpdateProfileImageRequest : AbstractRequest<User>("/account/update_profile_image.json", HttpMethod.POST){

    var image: String by stringDelegate
    var mode: RequestMode by requestModeDelegate

}