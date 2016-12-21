package com.github.kurtyan.fanfou4j.request.account

import com.github.kurtyan.fanfou4j.core.AbstractRequest
import com.github.kurtyan.fanfou4j.core.HttpMethod
import com.github.kurtyan.fanfou4j.entity.Notification

/**
 * Created by yanke on 2016/12/20.
 */
class ShowNotificationRequest : AbstractRequest<Notification>("/account/notification.json", HttpMethod.GET){
}