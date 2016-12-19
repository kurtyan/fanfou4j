package com.github.kurtyan.fanfou4j.request.account

import com.github.kurtyan.fanfou4j.core.AbstractRequest
import com.github.kurtyan.fanfou4j.core.HttpMethod
import com.github.kurtyan.fanfou4j.entity.RateLimitStatus

/**
 * Created by yanke on 2016/12/19.
 */
class ShowRateLimitStatusRequest : AbstractRequest<RateLimitStatus>("/account/rate_limit_status.json", HttpMethod.GET){
}