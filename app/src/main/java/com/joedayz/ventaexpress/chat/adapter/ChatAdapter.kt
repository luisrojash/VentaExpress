package com.joedayz.ventaexpress.chat.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.joedayz.ventaexpress.R
import com.joedayz.ventaexpress.chat.adapter.holder.ChatHolder
import com.joedayz.ventaexpress.chat.model.Chat

class ChatAdapter : RecyclerView.Adapter<ChatHolder>() {
    private var listaMensaje = mutableListOf<Chat>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false)
        return ChatHolder(view)
    }

    override fun getItemCount(): Int {
        return listaMensaje.size
    }

    override fun onBindViewHolder(holder: ChatHolder, position: Int) {
        val mensaje = listaMensaje.get(position)
        holder.bind(mensaje)
    }

    fun agregarChat(chat: Chat) {
        this.listaMensaje.add(chat)
        notifyDataSetChanged()
    }

    fun setRecycler(recicladorChat: RecyclerView?) {
        recicladorChat?.scrollToPosition(listaMensaje.size - 1)
    }

}