package com.github.kurtyan.fanfou4j.request.photo

import com.github.kurtyan.fanfou4j.core.AbstractRequest
import com.github.kurtyan.fanfou4j.core.HttpMethod
import com.github.kurtyan.fanfou4j.entity.Status
import com.github.kurtyan.fanfou4j.request.RequestMode

/**
 * Created by yanke on 2016/12/11.
 */
class UploadPhotoRequest : AbstractRequest<Status>("/photos/upload.json", HttpMethod.POST){

    var photo: String by stringDelegate
    var status: String by stringDelegate
    var source: String by stringDelegate
    var location: String by stringDelegate
    var mode: RequestMode by requestModeDelegate

}