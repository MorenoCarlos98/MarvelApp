package com.carlos.marvelapp.models

data class DataXXXX(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<ResultEvent>,
    val total: Int
)