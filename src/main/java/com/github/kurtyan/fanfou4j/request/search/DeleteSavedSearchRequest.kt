package com.github.kurtyan.fanfou4j.request.search

import com.github.kurtyan.fanfou4j.core.AbstractRequest
import com.github.kurtyan.fanfou4j.core.HttpMethod
import com.github.kurtyan.fanfou4j.entity.Search

/**
 * Created by yanke on 2016/12/23.
 */
class DeleteSavedSearchRequest : AbstractRequest<Search>("/saved_searches/destroy.json", HttpMethod.POST){

    var id: String by stringDelegate

}