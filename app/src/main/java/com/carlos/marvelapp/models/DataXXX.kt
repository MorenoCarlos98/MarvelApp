package com.carlos.marvelapp.models

data class DataXXX(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<ResultXXX>,
    val total: Int
)