package com.github.kurtyan.fanfou4j.request.search

import com.github.kurtyan.fanfou4j.core.AbstractRequest
import com.github.kurtyan.fanfou4j.core.HttpMethod
import com.github.kurtyan.fanfou4j.entity.Search

/**
 * Created by yanke on 2016/12/23.
 */
class ListSavedSearchRequest : AbstractRequest<Array<Search>>("/saved_searches/list.json", HttpMethod.GET){
}