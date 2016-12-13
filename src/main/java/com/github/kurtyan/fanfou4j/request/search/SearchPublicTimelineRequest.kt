package com.github.kurtyan.fanfou4j.request.search

import com.github.kurtyan.fanfou4j.core.AbstractRequest
import com.github.kurtyan.fanfou4j.core.HttpMethod
import com.github.kurtyan.fanfou4j.request.RequestMode
import com.sun.xml.internal.ws.api.message.Packet

/**
 * Created by yanke on 2016/12/13.
 */
class SearchPublicTimelineRequest : AbstractRequest<List<Packet.Status>>("/search/public_timeline.json", HttpMethod.GET){

    var q: String by stringDelegate     //TODO: multiple query can be seperated with |. should introduce a queryDelegate to handle this
    var count: Long by longDelegate
    var sinceId: String by stringDelegate
    var maxId: String by stringDelegate
    var mode: RequestMode by requestModeDelegate

}