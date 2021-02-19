package cs.med.mtz.moises.lyricss.api.dto

import cs.med.mtz.moises.lyricss.songAdapter.domain.entity.Song

data class SongDTO(
    val title: String,
    val artist: ArtistDTO,
    val album: AlbumDTO
) {
    fun toSong(): Song {
        return Song(
            title = title,
            artist = artist.name,
            imageUrl = album.cover_medium
        )
    }
}