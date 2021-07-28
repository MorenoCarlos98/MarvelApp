package com.carlos.marvelapp.models

data class ResultEvent(
    val characters: CharactersXXX,
    val comics: ComicsXXX,
    val creators: CreatorsXXX,
    val description: String,
    val end: String,
    val id: Int,
    val modified: String,
    val next: Next,
    val previous: Previous,
    val resourceURI: String,
    val series: SeriesXXX,
    val start: String,
    val stories: StoriesXXX,
    val thumbnail: ThumbnailXXX,
    val title: String,
    val urls: List<UrlXXX>
)