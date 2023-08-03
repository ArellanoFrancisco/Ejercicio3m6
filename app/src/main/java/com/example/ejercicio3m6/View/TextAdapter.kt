package com.example.ejercicio3m6.View

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicio3m6.Model.Modelo.Text
import com.example.ejercicio3m6.databinding.TextListLayoutBinding

class TextAdapter : RecyclerView.Adapter<TextAdapter.ViewHolder>() {
    private var textList = listOf<Text>()

    @SuppressLint("NotifyDataSetChanged")
    fun update(list: List<Text>){
        textList = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: TextListLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(text: Text){
            binding.textViewRV.text = text.Text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextListLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int= textList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = textList[position]
        holder.bind(item)
    }
}