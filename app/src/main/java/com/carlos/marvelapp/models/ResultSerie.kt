package com.carlos.marvelapp.models

data class ResultSerie(
    val characters: CharactersX,
    val comics: ComicsX,
    val creators: CreatorsX,
    val description: Any,
    val endYear: Int,
    val events: EventsXX,
    val id: Int,
    val modified: String,
    val next: Any,
    val previous: Any,
    val rating: String,
    val resourceURI: String,
    val startYear: Int,
    val stories: StoriesXX,
    val thumbnail: ThumbnailXX,
    val title: String,
    val type: String,
    val urls: List<UrlXX>
)