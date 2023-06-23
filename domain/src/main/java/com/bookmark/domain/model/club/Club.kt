package com.bookmark.domain.model.club

data class Club(
    var id : Int,
    var leader : Int,
    var name : String,
    var createdAt : String,
    var description : String,
    var members : List<Int>
)
