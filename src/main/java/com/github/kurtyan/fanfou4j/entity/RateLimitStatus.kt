package com.github.kurtyan.fanfou4j.entity

import java.util.*

/**
 * Created by yanke on 2016/12/19.
 */
class RateLimitStatus {

    var resetTime: Date? = null
    var remaingHits: Long? = null
    var hourlyLimit: Long? = null
    var resetTimeInSeconds: Long? = null
}