package com.carlos.marvelapp.models

data class Data(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<ResultCharacter>,
    val total: Int
)