package cs.med.mtz.moises.lyricss.api

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("suggest/{value}")
    suspend fun getSuggestSongs(
        @Path("value") value: String
    ): GetSuggestedSong


    @GET("v1/{artist}/{song}")
    suspend fun getLyricSong(
        @Path("artist") artist: String,
        @Path("song") song: String
    ): GetLyricSong
}