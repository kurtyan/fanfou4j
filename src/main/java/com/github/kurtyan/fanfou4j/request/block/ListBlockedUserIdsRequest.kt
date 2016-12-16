package com.github.kurtyan.fanfou4j.request.block

import com.github.kurtyan.fanfou4j.core.AbstractRequest
import com.github.kurtyan.fanfou4j.core.HttpMethod

/**
 * Created by yanke on 2016/12/16.
 */
class ListBlockedUserIdsRequest : AbstractRequest<Array<String>>("/blocks/ids.json", HttpMethod.GET){
}