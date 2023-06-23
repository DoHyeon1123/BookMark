package com.bookmark.domain.model.book

data class Document(
    val authors : List<String> = emptyList(),
    val contents : String = "",
    val datetime : String = "",
    val isbn : String = "",
    val price : Int = -1,
    val publisher : String = "",
    val sale_price : Int = -1,
    val status : String = "",
    val thumbnail : String = "",
    val title : String = "",
    val translators : List<String> = emptyList(),
    val url : String = ""
){
}
