package com.vinilazzeri.whatsapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.firebase.auth.FirebaseAuth
import com.vinilazzeri.whatsapp.databinding.CurrentUserItemMessagesBinding
import com.vinilazzeri.whatsapp.databinding.RecipientUserItemMessagesBinding
import com.vinilazzeri.whatsapp.model.Messages
import com.vinilazzeri.whatsapp.utils.Constants

import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

class MessagesAdapter : Adapter<ViewHolder>(){

    private var chatMessagesList = emptyList<Messages>()
    fun addList(list: List<Messages>){
        chatMessagesList = list
        notifyDataSetChanged()
    }

    class CurrentUserChatViewHolder(
        private val binding: CurrentUserItemMessagesBinding
    ) : ViewHolder(binding.root) {

        fun bind(message: Messages) {
            binding.textCurrentUserChat.text = message.messageContent

            // Verifique se a data não é nula antes de formatá-la
            val timestamp = message.date
            if (timestamp != null) {
                val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault()).apply {
                    timeZone = TimeZone.getTimeZone("GMT-4")
                }
                binding.textCurrentUserTime.text = timeFormat.format(timestamp)
            } else {
                binding.textCurrentUserTime.text = "No Time"
            }
        }

        companion object {
            fun layoutInflater(parent: ViewGroup): CurrentUserChatViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val itemView = CurrentUserItemMessagesBinding.inflate(
                    inflater, parent, false
                )
                return CurrentUserChatViewHolder(itemView)
            }
        }
    }

    class RecipientUserChatViewHolder(
        private val binding: RecipientUserItemMessagesBinding
    ) : ViewHolder(binding.root) {

        fun bind(message: Messages) {
            binding.textRecipientUserChat.text = message.messageContent

            // Verifique se a data não é nula antes de formatá-la
            val timestamp = message.date
            if (timestamp != null) {
                val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault()).apply {
                    timeZone = TimeZone.getTimeZone("GMT-4")
                }
                binding.textRecipientUserTime.text = timeFormat.format(timestamp)
            } else {
                binding.textRecipientUserTime.text = "No Time"
            }
        }

        companion object {
            fun layoutInflater(parent: ViewGroup): RecipientUserChatViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val itemView = RecipientUserItemMessagesBinding.inflate(
                    inflater, parent, false
                )
                return RecipientUserChatViewHolder(itemView)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {

        val message = chatMessagesList[position]
        val loggedUserId = FirebaseAuth.getInstance().currentUser?.uid.toString()

        return if (loggedUserId == message.userId){
            Constants.CURRENT_USER
        }else{
            Constants.RECIPIENT_USER
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        if (viewType == Constants.CURRENT_USER)
            return CurrentUserChatViewHolder.layoutInflater(parent)
        return RecipientUserChatViewHolder.layoutInflater(parent)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val message = chatMessagesList[position]

        when (holder){
            is CurrentUserChatViewHolder -> holder.bind(message)
            is RecipientUserChatViewHolder -> holder.bind(message)
        }

        /*val CurrentUserViewHolderMessages = holder as CurrentUserChatViewHolder
        CurrentUserViewHolderMessages.bind()*/
    }

    override fun getItemCount(): Int {
        return chatMessagesList.size
    }


}