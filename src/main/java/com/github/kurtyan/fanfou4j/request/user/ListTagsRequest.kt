package com.github.kurtyan.fanfou4j.request.user

import com.github.kurtyan.fanfou4j.core.AbstractRequest
import com.github.kurtyan.fanfou4j.core.HttpMethod

/**
 * Created by yanke on 2016/12/18.
 */
class ListTagsRequest : AbstractRequest<Array<String>>("/users/tag_list.json", HttpMethod.GET){

    var id: String by stringDelegate

}