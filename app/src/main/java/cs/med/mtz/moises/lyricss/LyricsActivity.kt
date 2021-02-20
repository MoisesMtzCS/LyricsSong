package cs.med.mtz.moises.lyricss

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import cs.med.mtz.moises.lyricss.databinding.ActivityLyricsBinding
import cs.med.mtz.moises.lyricss.retrofit.LoadLyricViewModel

class LyricsActivity : AppCompatActivity() {
    /**
     *
     */

    private lateinit var loadLyricViewModel: LoadLyricViewModel

    /**
     *
     */
    private val binding: ActivityLyricsBinding by lazy {
        ActivityLyricsBinding.inflate(
            layoutInflater
        )
    }

    /**
     *
     */


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        loadLyricViewModel = LoadLyricViewModel()
        observeViewModel()
        execute()

        val title = intent.extras?.getString("SONG_NAME")
        val album = intent.extras?.getString("ALBUM")

        binding.tvNameSong.text = title
        Glide.with(this)
            .load(album)
            .into(binding.ivAlbum)
    }

    /**
     *
     */

    private fun observeViewModel() {
        loadLyricViewModel.nameLiveData.observe(this, Observer<String> {
            binding.tvLyrics.text = it
        })
    }

    /**
     *
     */

    private fun execute() {
        val artist = intent.extras?.getString("ARTIST")
        val songName = intent.extras?.getString("SONG_NAME")
        loadLyricViewModel.executeLyricsSongs(artist!!, songName!!)

    }
}