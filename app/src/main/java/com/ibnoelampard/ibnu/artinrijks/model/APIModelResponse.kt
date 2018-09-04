package com.ibnoelampard.ibnu.artinrijks.model
object APIModelResponse {
    data class RijksMuseumResponse(val artObjects:List<artObjects>)
    data class artObjects(val title: String, val webImage: webImage)
    data class webImage(val url: String)
}