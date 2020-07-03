package com.joedayz.ventaexpress.test.adapter.holder

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.joedayz.ventaexpress.test.listener.PersonaListener
import com.joedayz.ventaexpress.test.model.Persona
import kotlinx.android.synthetic.main.item_persona.view.*

class TestHolder(var listener: PersonaListener, itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    fun bind(persona: Persona) {
        itemView.textViewNombrePersona.setText(persona.nombrePersona)
        itemView.setOnClickListener {
            Toast.makeText(
                itemView.context,
                "nombrePersona" + persona.idPersona,
                Toast.LENGTH_SHORT
            ).show()
        }
        itemView.btnEditar.setOnClickListener {
            listener.onClickEditar(persona)
        }
        itemView.btnEliminar.setOnClickListener {
            listener.onClickEliminar(persona)
        }

    }

}