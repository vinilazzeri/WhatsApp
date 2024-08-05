package com.vinilazzeri.whatsapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.squareup.picasso.Picasso
import com.vinilazzeri.whatsapp.databinding.ChatsItemBinding
import com.vinilazzeri.whatsapp.model.Chat

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone


class ChatsAdapter (
    private val onClick : (Chat) -> Unit
) : Adapter<ChatsAdapter.ChatsViewHolder>() {

    private var chatList = emptyList<Chat>()
    fun addList(list: List<Chat>){
        chatList = list
        notifyDataSetChanged()
    }

    inner class ChatsViewHolder(
        private val binding: ChatsItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(chat: Chat) {
            binding.textChatUsername.text = chat.name
            binding.textLastMessage.text = chat.lastMessage
            val chatDate = chat.date

            if (chatDate != null) {
                val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault()).apply {
                    timeZone = TimeZone.getTimeZone("GMT-4")
                }

                val dayFormat = SimpleDateFormat("EEEE", Locale.getDefault())

                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

                val currentCalendar = Calendar.getInstance().apply {
                    timeZone = TimeZone.getTimeZone("GMT-4")
                }

                val chatCalendar = Calendar.getInstance().apply {
                    time = chatDate
                    timeZone = TimeZone.getTimeZone("GMT-4")
                }

                val daysDifference = (currentCalendar.timeInMillis - chatCalendar.timeInMillis) / (1000 * 60 * 60 * 24)

                val chatTimeText = when {
                    daysDifference == 0L -> {
                        timeFormat.format(chatDate)
                    }
                    daysDifference == 1L -> {
                        "Yesterday"
                    }
                    daysDifference < 7L -> {
                        dayFormat.format(chatDate)
                    }
                    else -> {
                        dateFormat.format(chatDate)
                    }
                }

                binding.textTime.text = chatTimeText
            } else {
                binding.textTime.text = "No Date"
            }

            Picasso.get()
                .load(chat.photo)
                .into(binding.profileImgsChats)

            binding.clChatsItem.setOnClickListener {
                onClick(chat)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatsViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val itemView = ChatsItemBinding.inflate(
            inflater, parent, false
        )
        return ChatsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ChatsViewHolder, position: Int) {

        val chat = chatList[position]
        holder.bind(chat)

    }

    override fun getItemCount(): Int {
        return chatList.size
    }
}