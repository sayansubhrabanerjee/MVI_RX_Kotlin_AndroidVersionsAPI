package com.example.mvi_rx_kotlin_androidversionsapi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvi_rx_kotlin_androidversionsapi.R
import com.example.mvi_rx_kotlin_androidversionsapi.api.AndroidVersions
import kotlinx.android.synthetic.main.recycler_row.view.*

class AndroidVersionsAdapter(
    private val androidVersions: List<AndroidVersions>,
    private val listener: Listener
) : RecyclerView.Adapter<AndroidVersionsAdapter.VersionsViewHolder>() {

    interface Listener {
        fun onItemClick(androidVersion: AndroidVersions)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VersionsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row, parent, false)
        return VersionsViewHolder(view)
    }

    override fun onBindViewHolder(holder: VersionsViewHolder, position: Int) {
        holder.bind(androidVersions[position], listener)
    }

    override fun getItemCount(): Int {
        return androidVersions.count()
    }

    class VersionsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(androidVersion: AndroidVersions, listener: Listener) {
            itemView.tv_version.text = androidVersion.ver
            itemView.tv_name.text = androidVersion.name
            itemView.tv_api_level.text = androidVersion.api

            itemView.setOnClickListener { listener.onItemClick(androidVersion) }
        }
    }
}