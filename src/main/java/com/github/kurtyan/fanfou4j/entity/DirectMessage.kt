package com.github.kurtyan.fanfou4j.entity

import java.util.*

/**
 * Created by yanke on 2016/12/9.
 */
class DirectMessage {

    var id: String? = null
    var text: String? = null
    var senderId: String? = null
    var recipientId: String? = null
    var createdAt: Date? = null
    var senderScreenName: String? = null
    var recipientScreenName: String? = null

    var sender: User? = null
    var recipient: User? = null
    var inReplyTo: DirectMessage? = null

}