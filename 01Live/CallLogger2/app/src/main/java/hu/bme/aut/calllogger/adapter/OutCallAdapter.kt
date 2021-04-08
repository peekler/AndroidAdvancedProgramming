package hu.bme.aut.calllogger.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import hu.bme.aut.calllogger.R
import hu.bme.aut.calllogger.data.OutCallEntity
import hu.bme.aut.calllogger.databinding.RowCallBinding


class OutCallAdapter(var context: Context) : ListAdapter<OutCallEntity, OutCallAdapter.ViewHolder>(CallDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RowCallBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val call = getItem(position)

        holder.tvDate.text = call.callDate
        holder.tvPhone.text = call.phonenumber

        holder.btnCall.setOnClickListener {
            // tel:3033131
            // Implicit intent..
        }
    }

    inner class ViewHolder(val binding: RowCallBinding) : RecyclerView.ViewHolder(binding.root) {
        val tvDate = binding.tvDate
        val tvPhone = binding.tvPhone
        val btnCall = binding.btnCall
    }

}


class CallDiffCallback : DiffUtil.ItemCallback<OutCallEntity>() {
    override fun areItemsTheSame(oldItem: OutCallEntity, newItem: OutCallEntity): Boolean {
        return oldItem.callId == newItem.callId
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: OutCallEntity, newItem: OutCallEntity): Boolean {
        return oldItem == newItem
    }
}
