package com.joedayz.ventaexpress.chat

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore
import com.joedayz.ventaexpress.R
import com.joedayz.ventaexpress.chat.adapter.ChatAdapter
import com.joedayz.ventaexpress.chat.model.Chat
import kotlinx.android.synthetic.main.activity_chat.*

class ChatActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()
    lateinit var adapter: ChatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        adapter = ChatAdapter()
        recicladorChat.adapter = adapter
        recicladorChat.layoutManager = LinearLayoutManager(this)
        recicladorChat.setHasFixedSize(true)
        initListaMensaje()
        buttonEnviarMensaje.setOnClickListener {
            initValidarEnvioMensaje()
        }
    }

    private fun initListaMensaje() {
        db.collection("Chat")
            .addSnapshotListener { snapshots, e ->
                if (e != null) {
                    Log.w("MainActivity", "listen:error", e)
                    return@addSnapshotListener
                }
                for (dc in snapshots!!.documentChanges) {
                    val nombrePersona = dc.document.data.getValue("nombrePersona") as String
                    val mensajePersona = dc.document.data.getValue("mensaje") as String
                    val chat = Chat( nombrePersona, mensajePersona)
                    when (dc.type) {
                        DocumentChange.Type.ADDED -> {
                            Log.d("MainActivity", "New city: ${dc.document.data}")
                            adapter.agregarChat(chat)

                        }
                    }
                }
                adapter.setRecycler(recicladorChat)
            }
    }

    private fun initValidarEnvioMensaje() {
        val nombrePersona = editNombre.text.toString()
        if (nombrePersona.length == 0 || nombrePersona.isEmpty()) {
            mostrarMensaje("Ingrese el nombre de la persona")
            return
        }
        val mensajePersona = editMensaje.text.toString()
        if (mensajePersona.length == 0 || nombrePersona.isEmpty()) {
            mostrarMensaje("Ingrese el mensaje")
            return
        }
        val chat = Chat( nombrePersona, mensajePersona)
        db.collection("Chat")
            .add(chat)
            .addOnSuccessListener { documentReference ->
                editMensaje.setText(null)
                mostrarMensaje( "DocumentSnapshot written with ID "+ documentReference.id)
            }
            .addOnFailureListener { e ->
                mostrarMensaje( "Error adding document "+ e)
            }
    }

    private fun mostrarMensaje(mensaje: String) {
        Toast.makeText(applicationContext, mensaje, Toast.LENGTH_SHORT).show()
    }
}