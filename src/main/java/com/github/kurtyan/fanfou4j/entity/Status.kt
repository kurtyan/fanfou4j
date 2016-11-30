package com.github.kurtyan.fanfou4j.entity

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import java.util.*

/**
 * Created by yanke on 2016/11/29.
 */
class Status {

    var createdAt: Date? = null
    var id: String? = null
    var rawid: Long? = null
    var text: String? = null
    var source: String? = null
    var truncated: Boolean? = null
    var inReplyToStatusId: String? = null
    var inReplyToUserId: String? = null
    var inReplyToScreenName: String? = null
    var repostStatusId: String? = null
    var repostStatus: Status? = null
    var repostUserId: String? = null
    var repostScreenName: String? = null
    var favorited: Boolean? = null
    @JsonProperty("is_self")
    var isSelf: Boolean? = null
    var location: String? = null

    var user: User? = null
    var photo: Photo? = null

}