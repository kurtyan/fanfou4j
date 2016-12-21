package com.github.kurtyan.fanfou4j.request.account

import com.github.kurtyan.fanfou4j.core.AbstractRequest
import com.github.kurtyan.fanfou4j.core.HttpMethod
import com.github.kurtyan.fanfou4j.entity.AppNotifyNum

/**
 * Created by yanke on 2016/12/21.
 */
class UpdateAppNotifyNumRequest : AbstractRequest<AppNotifyNum>("/account/update_notify_num.json", HttpMethod.POST){

    var notifyNum: Long by longDelegate

}