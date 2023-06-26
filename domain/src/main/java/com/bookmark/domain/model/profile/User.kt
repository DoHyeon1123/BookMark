package com.bookmark.domain.model.profile

data class User(
    val id : Int,
    val name : String = "Dummy1",
    val attr1 : String = "요소 1 테스트",
    val attr2 : String = "요소 2 테스트"

)
