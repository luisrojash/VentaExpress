package com.joedayz.ventaexpress.test.listener

import com.joedayz.ventaexpress.test.model.Persona

interface PersonaListener {

    fun onClickEditar(persona: Persona)

    fun onClickEliminar(persona: Persona)
}