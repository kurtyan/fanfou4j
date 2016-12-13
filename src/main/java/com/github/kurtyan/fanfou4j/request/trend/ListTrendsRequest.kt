package com.github.kurtyan.fanfou4j.request.trend

import com.github.kurtyan.fanfou4j.core.AbstractRequest
import com.github.kurtyan.fanfou4j.core.HttpMethod
import com.github.kurtyan.fanfou4j.entity.TrendList

/**
 * Created by yanke on 2016/12/11.
 */
class ListTrendsRequest : AbstractRequest<TrendList>("/trends/list.json", HttpMethod.GET){
}