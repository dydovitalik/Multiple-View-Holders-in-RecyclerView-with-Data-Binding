package com.example.multipleviewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.multipleviewholders.Database.TYPE_HEADER
import com.example.multipleviewholders.Database.TYPE_ITEM
import com.example.multipleviewholders.databinding.HeaderDesignBinding
import com.example.multipleviewholders.databinding.ItemDesignBinding
import java.lang.IllegalArgumentException

class Adapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class ItemViewHolder(val itemBinding: ItemDesignBinding): RecyclerView.ViewHolder(itemBinding.root){
        fun bind(item:DataItem.Item){
            itemBinding.item = item
        }
    }

    inner class HeaderViewHolder(val headerBinding: HeaderDesignBinding): RecyclerView.ViewHolder(headerBinding.root){
        fun bind(header: DataItem.Header){
            headerBinding.header = header.text
        }
    }

    private val itemList = arrayListOf<Any>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
          return when(viewType){
              TYPE_ITEM -> ItemViewHolder(ItemDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false))
              TYPE_HEADER -> HeaderViewHolder(HeaderDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false))
              else -> throw     IllegalArgumentException("Invalid ViewType")
          }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
             when(holder) {
                 is ItemViewHolder -> holder.bind(itemList[position] as DataItem.Item)
                 is HeaderViewHolder -> holder.bind(itemList[position] as DataItem.Header)
             }
    }

    override fun getItemCount(): Int = itemList.size

    override fun getItemViewType(position: Int): Int {
        return when(itemList[position]){
            is DataItem.Item -> TYPE_ITEM
            is DataItem.Header -> TYPE_HEADER
            else -> throw IllegalArgumentException("Invalid Item")
        }
    }

    fun updateList(updatedList: List<Any>) {
        itemList.clear()
        itemList.addAll(updatedList)
        notifyDataSetChanged()
    }
}