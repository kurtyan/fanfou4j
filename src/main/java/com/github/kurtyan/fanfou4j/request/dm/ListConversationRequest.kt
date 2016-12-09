package com.github.kurtyan.fanfou4j.request.dm

import com.github.kurtyan.fanfou4j.core.AbstractRequest
import com.github.kurtyan.fanfou4j.core.HttpMethod
import com.github.kurtyan.fanfou4j.entity.Conversation
import com.github.kurtyan.fanfou4j.request.RequestMode

/**
 * Created by yanke on 2016/12/10.
 */
class ListConversationRequest : AbstractRequest<Conversation>("/direct_messages/conversation_list.json", HttpMethod.GET){

    var count: Int by intDelegate
    var page: Int by intDelegate
    var mode: RequestMode by requestModeDelegate

}