package com.example.playlistmaker

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class TracksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val source = itemView.findViewById<View>(R.id.track_layout)
    val trackName = source.findViewById<TextView>(R.id.track_name)
    val artistName = source.findViewById<TextView>(R.id.artist_name)
    val trackTime = source.findViewById<TextView>(R.id.track_time)
    val artworkUrl100 = source.findViewById<ImageView>(R.id.album_image)

    fun bind(track: Track) {
        trackName.setText(track.trackName)
        artistName.setText(track.artistName)
        trackTime.setText(track.trackTime)
        Glide.with(itemView)
            .load(track.artworkUrl100)
            .placeholder(R.drawable.no_image_album)
            .into(artworkUrl100)
    }
}