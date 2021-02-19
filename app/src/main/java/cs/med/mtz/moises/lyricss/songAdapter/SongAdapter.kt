package cs.med.mtz.moises.lyricss.songAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import cs.med.mtz.moises.lyricss.databinding.ViewHolderSongBinding
import cs.med.mtz.moises.lyricss.songAdapter.domain.entity.Song

class SongAdapter(
    private val songs: List<Song>
) : RecyclerView.Adapter<SongAdapter.SongViewHolder>() {

    class SongViewHolder(
        val binding: ViewHolderSongBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val context = parent.context
        val layoutInflater = LayoutInflater.from(context)
        val binding = ViewHolderSongBinding.inflate(layoutInflater, parent, false)
        return SongViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return songs.size
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val song: Song = songs[position]
        holder.binding.tvTitle.text = song.title
        Glide.with(holder.itemView)
            .load(song.imageUrl)
            .into(holder.binding.ivCover)


    }
}