package com.github.kurtyan.fanfou4j.request.user

import com.github.kurtyan.fanfou4j.core.AbstractRequest
import com.github.kurtyan.fanfou4j.core.HttpMethod
import com.github.kurtyan.fanfou4j.entity.User
import com.github.kurtyan.fanfou4j.request.RequestMode

/**
 * Created by yanke on 2016/12/18.
 */
class IgnoreRecommendationRequest : AbstractRequest<User>("2/users/cancel_recommendation.json", HttpMethod.POST){

    var id: String by stringDelegate
    var mode: RequestMode by requestModeDelegate

}