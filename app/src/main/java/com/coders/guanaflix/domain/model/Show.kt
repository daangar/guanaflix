package com.coders.guanaflix.domain.model

data class Response(
    val score: Double? = 0.0,
    val show: Show? = Show()
)

data class Show(
    val id: Long? = 0L,
    val name: String? = "",
    val image: Image? = Image()
)

data class Image(
    val medium: String? = "",
    val original: String? = ""
)
