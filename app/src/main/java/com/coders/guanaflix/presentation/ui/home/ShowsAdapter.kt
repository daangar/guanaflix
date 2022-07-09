package com.coders.guanaflix.presentation.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.coders.guanaflix.databinding.ItemShowBinding

class ShowsAdapter(
    private val showNames: List<String>,
    private val itemClicked: (String) -> Unit
)
    : RecyclerView.Adapter<ShowsAdapter.ShowViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowViewHolder {
        val binding = ItemShowBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) {
        holder.bind(showNames[position])
    }

    override fun getItemCount() = showNames.size

    inner class ShowViewHolder(
        private val itemBinding: ItemShowBinding
    ): RecyclerView.ViewHolder(itemBinding.root) {

        private var showName: String? = null

        init {
           itemBinding.root.setOnClickListener {
//               if (showName != null) {
//                   itemClicked(showName!!)
//               }
               showName?.let {
                   itemClicked(it)
               }
           }
        }

        fun bind(showName: String) {
            this.showName = showName
            itemBinding.txtShowName.text = showName
        }
    }
}