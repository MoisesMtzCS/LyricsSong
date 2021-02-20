package cs.med.mtz.moises.lyricss.retrofit

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cs.med.mtz.moises.lyricss.api.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoadLyricViewModel: ViewModel(){
    /**
     *
     */
    private val service: ApiService = retrofit.create<ApiService>(ApiService::class.java)

    /**
     *
     */

    private val nameMutableLiveData: MutableLiveData<String> = MutableLiveData()
    val nameLiveData: MutableLiveData<String> get() = nameMutableLiveData

    /**
     *
     */
    fun executeLyricsSongs(artist: String, songName: String) {
        viewModelScope.launch(Dispatchers.IO) {

                val getLyric = service.getLyricSong(artist, songName)
                val lyrics: String = getLyric.lyrics
                nameMutableLiveData.postValue(lyrics)

        }


    }


}