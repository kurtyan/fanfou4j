package com.github.kurtyan.fanfou4j.request.dm

import com.github.kurtyan.fanfou4j.core.AbstractRequest
import com.github.kurtyan.fanfou4j.core.HttpMethod
import com.github.kurtyan.fanfou4j.entity.DirectMessage

/**
 * Created by yanke on 2016/12/9.
 */
class DeleteDirectMessageRequest : AbstractRequest<DirectMessage>("/direct_messages/destroy.json", HttpMethod.POST){

    var id: String by stringDelegate

}