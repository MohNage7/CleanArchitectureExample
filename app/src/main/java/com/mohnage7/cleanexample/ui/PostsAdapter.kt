package com.mohnage7.cleanexample.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mohnage7.cleanexample.R
import com.mohnage7.cleanexample.ui.model.Post
import kotlinx.android.synthetic.main.item_post.view.*

class PostsAdapter(private val postsList: List<Post>) :
    RecyclerView.Adapter<PostsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return postsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViews(position)
    }

    inner class ViewHolder internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun bindViews(position: Int) {
            val post = postsList[position]
            itemView.titleTxtView.text = post.title
            itemView.contentTxtView.text = post.body
        }
    }
}