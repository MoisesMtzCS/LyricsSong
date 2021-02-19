package cs.med.mtz.moises.lyricss

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import cs.med.mtz.moises.lyricss.databinding.ActivityMainBinding
import cs.med.mtz.moises.lyricss.retrofit.LoadSongsViewModel
import cs.med.mtz.moises.lyricss.songAdapter.SongAdapter
import cs.med.mtz.moises.lyricss.songAdapter.domain.entity.Song

class MainActivity : AppCompatActivity() {
    /**
     *
     */

    private lateinit var mainViewModel: LoadSongsViewModel
    /* */

    val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val value: String
        get() = binding.valueText.text.toString()


    private val songs: ArrayList<Song> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        mainViewModel = LoadSongsViewModel()
        setupSongsRecyclerView()
        observeViewModel()
        searchOnClick()

    }

    /**
     *
     */

    private fun setupSongsRecyclerView() {
        val songAdapter = SongAdapter(songs)
        binding.rvSong.adapter = songAdapter
        binding.rvSong.layoutManager = LinearLayoutManager(this)
    }

    /**
     *
     */

    private fun observeViewModel() {

        mainViewModel.songsLiveData.observe(this, Observer<List<Song>> {
            songs.clear()
            songs.addAll(it)
            binding.rvSong.adapter?.notifyDataSetChanged()
        })
    }

    /**
     *
     */

    private fun searchOnClick() {
        binding.searchButton.setOnClickListener {
            if (value.isNotBlank()) {
                mainViewModel.executeLoadSongs(value)
            }
        }
    }
}
