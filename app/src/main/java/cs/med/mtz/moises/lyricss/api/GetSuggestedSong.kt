package cs.med.mtz.moises.lyricss.api

import cs.med.mtz.moises.lyricss.api.dto.SongDTO


data class GetSuggestedSong(
    val data: List<SongDTO>
)