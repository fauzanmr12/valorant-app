package com.example.valorantagentapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.valorantagentapp.databinding.ItemRowAgentsBinding


class ListAgentsAdapter(
    private val listAgent: ArrayList<ValorantAgents>,
) : RecyclerView.Adapter<ListAgentsAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding = ItemRowAgentsBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listAgent.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, role, description, photo) = listAgent[position]
        holder.binding.tvItemName.text = name
        holder.binding.tvItemRole.text = role
        holder.binding.tvItemDescription.text = description
        holder.binding.imgItemPhoto.setImageResource(photo)
        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("EXTRA_AGENT", listAgent[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    class ListViewHolder(var binding: ItemRowAgentsBinding) : RecyclerView.ViewHolder(binding.root)


}