package com.joedayz.ventaexpress.chat.adapter.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.joedayz.ventaexpress.chat.model.Chat
import kotlinx.android.synthetic.main.item_chat.view.*

class ChatHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    fun bind(mensaje: Chat) {
        itemView.textViewNombrePersona.setText(mensaje.nombrePersona + ": " + mensaje.mensaje)
    }


}