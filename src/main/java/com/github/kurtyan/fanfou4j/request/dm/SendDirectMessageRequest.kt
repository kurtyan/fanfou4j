package com.github.kurtyan.fanfou4j.request.dm

import com.github.kurtyan.fanfou4j.core.AbstractRequest
import com.github.kurtyan.fanfou4j.core.HttpMethod
import com.github.kurtyan.fanfou4j.entity.DirectMessage
import com.github.kurtyan.fanfou4j.request.RequestMode

/**
 * Created by yanke on 2016/12/10.
 */
class SendDirectMessageRequest : AbstractRequest<DirectMessage>("/direct_messages/new.json", HttpMethod.POST){

    var user: String by stringDelegate
    var text: String by stringDelegate
    var inReplyToId: String by stringDelegate
    var mode: RequestMode by requestModeDelegate

}