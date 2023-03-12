package com.example.app

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.OscarMovieLayoutBinding
import layout.OscarMovie

class OscarMovieAdapter(private val context: Context, private val oscarMovieList:MutableList<OscarMovie>)
    : RecyclerView.Adapter<OscarMovieAdapter.OscarMovieViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OscarMovieViewHolder {
        val binding = OscarMovieLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return OscarMovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OscarMovieViewHolder, position: Int) {
        val oscarMovieItem = oscarMovieList[position]
        holder.bind(oscarMovieItem)
    }

    override fun getItemCount(): Int {
        return oscarMovieList.size
    }


    class OscarMovieViewHolder(oscarMovieLayoutBinding: OscarMovieLayoutBinding)
        : RecyclerView.ViewHolder(oscarMovieLayoutBinding.root){

        private val binding = oscarMovieLayoutBinding

        fun bind(oscarMovieItem: OscarMovie){
            binding.movieName.text = oscarMovieItem.name
            binding.movieDirector.text = "Director: ${oscarMovieItem.director}"
        }

    }
}