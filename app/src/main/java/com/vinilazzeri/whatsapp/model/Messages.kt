package com.vinilazzeri.whatsapp.model

import com.google.firebase.firestore.ServerTimestamp
import java.util.Date

data class Messages(
    val userId: String = "",
    val messageContent: String = "",
    @ServerTimestamp
    val date: Date? = null
)
