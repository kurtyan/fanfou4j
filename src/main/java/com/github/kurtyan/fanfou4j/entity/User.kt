package com.github.kurtyan.fanfou4j.entity

import java.util.*

/**
 * Created by yanke on 2016/4/24.
 */
class User {
    var id: String? = null
    var name: String? = null
    var screenName: String? = null
    var uniqueId: String? = null
    var location: String? = null
    var gender: String? = null
    var birthday: String? = null
    var description: String? = null
    var profileImageUrl: String?  = null
    var profileImageUrlLarge: String? = null
    var url: String? = null
    var protected: Boolean? = null
    val followersCount: Long? = null
    var friendsCount: Long? = null
    var favouritesCount: Long? = null
    var statusesCount: Long? = null
    var photoCount: Long? = null
    var following: Boolean? = null
    var notifications: Boolean? = null
    var createdAt: Date? = null
    var utcOffset: Long? = null
    var profileBackgroundColor: String? = null
    var profileTextColor: String? = null
    var profileLinkColor: String? = null
    var profileSidebarFillColor: String? = null
    var profileSidebarBorderColor: String? = null
    var profileBackgroundImageUrl: String? = null
    var profileBackgroundTile: Boolean? = null

}
