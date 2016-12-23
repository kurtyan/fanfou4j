package com.github.kurtyan.fanfou4j.request.search

import com.github.kurtyan.fanfou4j.core.AbstractRequest
import com.github.kurtyan.fanfou4j.core.HttpMethod
import com.github.kurtyan.fanfou4j.entity.Search

/**
 * Created by yanke on 2016/12/23.
 */
class ShowSavedSearchRequest : AbstractRequest<Search>("/saved_searches/show.json", HttpMethod.GET){

    var id: String by stringDelegate

}