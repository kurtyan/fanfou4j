package com.github.kurtyan.fanfou4j.request.dm

import com.github.kurtyan.fanfou4j.core.AbstractRequest
import com.github.kurtyan.fanfou4j.core.HttpMethod
import com.github.kurtyan.fanfou4j.entity.DirectMessage
import com.github.kurtyan.fanfou4j.request.RequestMode

/**
 * Created by yanke on 2016/12/10.
 */
class ShowConversationRequest : AbstractRequest<List<DirectMessage>>("/direct_messages/conversation.json", HttpMethod.GET){

    var id: String by stringDelegate        // userId
    var sinceId: String by stringDelegate
    var maxId: String by stringDelegate
    var count: Int by intDelegate
    var page: Int by intDelegate
    var mode: RequestMode by requestModeDelegate

}