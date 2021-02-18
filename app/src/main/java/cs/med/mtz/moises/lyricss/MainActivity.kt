package cs.med.mtz.moises.lyricss

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import cs.med.mtz.moises.lyricss.databinding.ActivityMainBinding
import cs.med.mtz.moises.lyricss.songAdapter.SongAdapter
import cs.med.mtz.moises.lyricss.songAdapter.domain.entity.Song

class MainActivity : AppCompatActivity() {

    val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val songs: List<Song> = listOf(
        Song("Song 1")
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupSongsRecyclerView()

    }

    private fun setupSongsRecyclerView() {
        val songAdapter = SongAdapter(songs)
        binding.rvSong.adapter = songAdapter
        binding.rvSong.layoutManager = LinearLayoutManager(this)
    }
}