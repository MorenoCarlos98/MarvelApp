package com.carlos.marvelapp.models

data class DataX(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<ResultComic>,
    val total: Int
)