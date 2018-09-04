package com.ibnoelampard.ibnu.artinrijks.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.ibnoelampard.ibnu.artinrijks.R
import com.ibnoelampard.ibnu.artinrijks.model.RijksMuseumModel
import com.squareup.picasso.Picasso

open class HomeAdapter(val dataList: List<RijksMuseumModel>, val onClickListener: OnClickListerner) : RecyclerView.Adapter<HomeAdapter.ViewHolder>(){

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data : RijksMuseumModel = dataList[position]
        holder.tvTitle.text = data.title
        Picasso.get().load(data.url)
                .placeholder(R.drawable.ic_art_in_rijks_big)
                .error(R.drawable.ic_art_in_rijks_big)
                .fit()
                .centerCrop()
                .into(holder.imgArt)
        holder.itemView.setOnClickListener { onClickListener.onRecyclerViewClick(position) }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false)
        return ViewHolder(v)
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        val imgArt = itemView.findViewById<ImageView>(R.id.imgArt)
    }

    interface OnClickListerner {
        fun onRecyclerViewClick(position: Int)
    }

}