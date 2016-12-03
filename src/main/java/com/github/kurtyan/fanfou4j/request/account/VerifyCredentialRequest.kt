package com.github.kurtyan.fanfou4j.request.account

import com.github.kurtyan.fanfou4j.core.AbstractRequest
import com.github.kurtyan.fanfou4j.core.HttpMethod
import com.github.kurtyan.fanfou4j.entity.User

/**
 * Created by yanke on 2016/12/4.
 */
class VerifyCredentialRequest : AbstractRequest<User>("/account/verify_credentials.json", HttpMethod.POST) {
}