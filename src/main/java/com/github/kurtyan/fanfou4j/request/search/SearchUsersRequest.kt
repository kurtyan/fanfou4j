package com.github.kurtyan.fanfou4j.request.search

import com.github.kurtyan.fanfou4j.core.AbstractRequest
import com.github.kurtyan.fanfou4j.core.HttpMethod
import com.github.kurtyan.fanfou4j.entity.UserList
import com.github.kurtyan.fanfou4j.request.RequestMode

/**
 * Created by yanke on 2016/12/15.
 */
class SearchUsersRequest : AbstractRequest<UserList>("/search/users.json", HttpMethod.GET) {

    var q: String by stringDelegate     //TODO: multiple query can be seperated with |. should introduce a queryDelegate to handle this
    var count: Long by longDelegate
    var page: Long by longDelegate
    var mode: RequestMode by requestModeDelegate

}