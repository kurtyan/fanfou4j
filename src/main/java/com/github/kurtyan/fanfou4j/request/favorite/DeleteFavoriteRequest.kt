package com.github.kurtyan.fanfou4j.request.favorite

import com.github.kurtyan.fanfou4j.core.AbstractRestfulRequest
import com.github.kurtyan.fanfou4j.core.HttpMethod
import com.github.kurtyan.fanfou4j.entity.Status

/**
 * Created by yanke on 2016/12/5.
 */
class DeleteFavoriteRequest : AbstractRestfulRequest<Status>("/favorites/destroy/:id.json", HttpMethod.POST){

    var id : String by stringDelegate

}