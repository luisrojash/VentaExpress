package com.joedayz.ventaexpress.test.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.joedayz.ventaexpress.R
import com.joedayz.ventaexpress.test.adapter.holder.TestHolder
import com.joedayz.ventaexpress.test.listener.PersonaListener
import com.joedayz.ventaexpress.test.model.Persona

class TestAdapter(val listener: PersonaListener) : RecyclerView.Adapter<TestHolder>() {
    private var listaPersonas = mutableListOf<Persona>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_persona, parent, false)
        return TestHolder(listener, view)
    }

    override fun getItemCount(): Int {
        return listaPersonas.size
    }

    override fun onBindViewHolder(holder: TestHolder, position: Int) {
        val nombrePersona = listaPersonas.get(position)
        holder.bind(nombrePersona)
    }

    fun actualizarLista(listaPersona: MutableList<Persona>) {
        this.listaPersonas.clear()
        this.listaPersonas.addAll(listaPersona)
        notifyDataSetChanged()
    }

    fun actualizarAdapter() {
        notifyDataSetChanged()
    }

    fun agregarPersona(persona: Persona) {
        this.listaPersonas.add(persona)
        notifyDataSetChanged()
    }

    fun actualizarPersona(personaActual: Persona) {
        for (personaAntigua in listaPersonas) {
            if (personaActual.idPersona.equals(personaAntigua.idPersona)) {
                val obtenerPosicion = listaPersonas.indexOf(personaAntigua)
                listaPersonas.set(obtenerPosicion, personaActual)
                notifyDataSetChanged()
                return
            }
        }
    }

    fun eliminarPersona(personaActual: Persona) {
        for (personaAntigua in listaPersonas) {
            if (personaActual.idPersona.equals(personaAntigua.idPersona)) {
                listaPersonas.remove(personaActual)
                notifyDataSetChanged()
                return
            }
        }
    }

}