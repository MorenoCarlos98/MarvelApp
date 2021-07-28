package com.carlos.marvelapp.models

data class Comic(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val `data`: DataX,
    val etag: String,
    val status: String
)