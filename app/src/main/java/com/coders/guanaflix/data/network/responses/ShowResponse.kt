package com.coders.guanaflix.data.network.responses

import com.coders.guanaflix.domain.model.Image
import com.coders.guanaflix.domain.model.Show

data class ShowResponse(
    val id: Long? = 0L,
    val name: String? = "",
    val image: ImageResponse? = ImageResponse()
) {
    fun convertToShow(): Show {
        return Show(
            id = this.id ?: 0L,
            name = this.name ?: "",
            image = this.image?.convertToImage() ?: Image()
        )
    }
}

data class ImageResponse(
    val medium: String? = "",
    val original: String? = ""
) {
    fun convertToImage(): Image {
        return Image(
            medium = this.medium ?: "",
            original = this.original ?: ""
        )
    }
}
