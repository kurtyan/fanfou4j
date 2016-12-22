package com.github.kurtyan.fanfou4j.request.search

import com.github.kurtyan.fanfou4j.core.AbstractRequest
import com.github.kurtyan.fanfou4j.core.HttpMethod
import com.github.kurtyan.fanfou4j.entity.Search

/**
 * Created by yanke on 2016/12/22.
 */
class CreateSavedSearchRequest : AbstractRequest<Search>("/saved_searches/create.json", HttpMethod.POST){

    var query: String by stringDelegate

}