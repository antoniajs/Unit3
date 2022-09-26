package com.example.project3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

const val MOVIE_EXTRA = "MOVIE_EXTRA"
class MovieAdapter(private val context: Context, private val movies: MutableList<Movie>): RecyclerView.Adapter<MovieAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val ivPoster = itemView.findViewById<ImageView>(R.id.imageView)
        private val tvTitle = itemView.findViewById<TextView>(R.id.textView)
        private val tvOverview = itemView.findViewById<TextView>(R.id.textView2)

        fun bind(movie: Movie){
            tvTitle.text = movie.title
            tvOverview.text = movie.overview
            Glide.with(context).load(movie.posterImageURL).into(ivPoster)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.movie_layout, parent, false)
        return ViewHolder(contactView)

    }

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        val movies = movies.get(position)
        holder.bind(movies)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

}