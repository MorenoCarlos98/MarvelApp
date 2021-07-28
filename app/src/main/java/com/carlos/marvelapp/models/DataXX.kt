package com.carlos.marvelapp.models

data class DataXX(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<ResultXX>,
    val total: Int
)