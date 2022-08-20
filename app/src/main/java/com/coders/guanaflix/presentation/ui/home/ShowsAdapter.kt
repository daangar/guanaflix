package com.coders.guanaflix.presentation.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.coders.guanaflix.databinding.ItemShowBinding
import com.coders.guanaflix.domain.model.Show

class ShowsAdapter(
    private val itemClicked: (String) -> Unit
)
    : RecyclerView.Adapter<ShowsAdapter.ShowViewHolder>() {

    private val shows = mutableListOf<Show>()

    fun addShows(shows: List<Show>) {
        this.shows.clear()
        this.shows.addAll(shows)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowViewHolder {
        val binding = ItemShowBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) {
        holder.bind(shows[position])
    }

    override fun getItemCount() = shows.size

    inner class ShowViewHolder(
        private val itemBinding: ItemShowBinding
    ): RecyclerView.ViewHolder(itemBinding.root) {

        private var show: Show? = null

        init {
           itemBinding.root.setOnClickListener {
               show?.let {
                   itemClicked(it.name.orEmpty())
               }
           }
        }

        fun bind(show: Show) {
            this.show = show
            itemBinding.textName.text = show.name
            Glide.with(itemBinding.root)
                .load(show.image?.medium)
                .into(itemBinding.imgPoster)

        }
    }
}