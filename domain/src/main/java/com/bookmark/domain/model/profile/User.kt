package com.bookmark.domain.model.profile

data class User(
    val id : Int,
    val profile_img : String?,
    val name : String,
    val level : Int ,
    val xp : Int,
    val max_xp : Int = 100,
    val style : String = ""
)
