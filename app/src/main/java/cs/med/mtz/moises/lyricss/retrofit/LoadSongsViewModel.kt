package cs.med.mtz.moises.lyricss.retrofit

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cs.med.mtz.moises.lyricss.api.ApiService
import cs.med.mtz.moises.lyricss.api.dto.SongDTO
import cs.med.mtz.moises.lyricss.songAdapter.domain.entity.Song
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoadSongsViewModel : ViewModel() {
    /**
     *
     */
    private val service: ApiService = retrofit.create<ApiService>(ApiService::class.java)

    /**
     *
     */
    private val songsMutableLiveData: MutableLiveData<List<Song>> = MutableLiveData()
    val songsLiveData: LiveData<List<Song>> get() = songsMutableLiveData

    /**
     *
     */
    fun executeLoadSongs(valueSong: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val getSongs = service.getSuggestSongs(valueSong)
            val songsDto: List<SongDTO> = getSongs.data
            val songs: List<Song> = songsDto.map { it.toSong() }
            songsMutableLiveData.postValue(songs)
        }
    }

}