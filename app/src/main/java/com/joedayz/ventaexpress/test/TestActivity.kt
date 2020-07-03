package com.joedayz.ventaexpress.test

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.Adapter
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore
import com.joedayz.ventaexpress.R
import com.joedayz.ventaexpress.Users
import com.joedayz.ventaexpress.test.adapter.TestAdapter
import com.joedayz.ventaexpress.test.listener.PersonaListener
import com.joedayz.ventaexpress.test.model.Persona
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_test.*
import kotlinx.android.synthetic.main.activity_test.buttonAgregar
import kotlinx.android.synthetic.main.activity_test.editTextPersonaNombre
import kotlinx.android.synthetic.main.activity_test.recicladorPersona

class TestActivity : AppCompatActivity(), PersonaListener {

    val db = FirebaseFirestore.getInstance()
    lateinit var adapter: TestAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        initMostrarLista()
        buttonAgregar.setOnClickListener {
            val nombrePersona = editTextPersonaNombre.text.toString()
            val user = Persona("", nombrePersona)

            db.collection("users")
                .add(user)
                .addOnSuccessListener { documentReference ->
                    user.idPersona = documentReference.id
                    Log.d("MainActivity", "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w("MainActivity", "Error adding document", e)
                }

        }
    }

    private fun initMostrarLista() {
        adapter = TestAdapter(this)
        recicladorPersona.adapter = adapter
        recicladorPersona.layoutManager = LinearLayoutManager(this)
        recicladorPersona.setHasFixedSize(true)
        db.collection("users")
            .addSnapshotListener { snapshots, e ->
                if (e != null) {
                    Log.w("MainActivity", "listen:error", e)
                    return@addSnapshotListener
                }
                for (dc in snapshots!!.documentChanges) {
                    val nombrePers = dc.document.data.getValue("nombrePersona") as String
                    val idPersona = dc.document.id
                    Log.d("MainActivity", "idPersonaidPersona :  " + idPersona)
                    val persona = Persona(idPersona, nombrePers)
                    when (dc.type) {
                        DocumentChange.Type.ADDED -> {
                            Log.d("MainActivity", "New city: ${dc.document.data}")
                            adapter.agregarPersona(persona)
                        }
                        DocumentChange.Type.MODIFIED -> {
                            Log.d("MainActivity", "Modified city: ${dc.document.data}")
                            adapter.actualizarPersona(persona)
                        }
                        DocumentChange.Type.REMOVED -> {
                            adapter.eliminarPersona(persona)
                            Log.d("MainActivity", "Removed city: ${dc.document.data}")
                        }
                    }
                }
            }
    }

    override fun onClickEditar(persona: Persona) {
        val dialog = Dialog(this)
        //dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.dialog_editar_persona)
        val editNombre = dialog.findViewById(R.id.editNombre) as EditText
        val editApellido = dialog.findViewById(R.id.editApellido) as EditText
        val buttonEditar = dialog.findViewById(R.id.buttonEditar) as Button
        val buttonCancelar = dialog.findViewById(R.id.buttonCancelar) as Button
        editNombre.setText(persona.nombrePersona)
        buttonEditar.setOnClickListener {
            val nombrePersona = editNombre.text.toString()
            val personaUpdate = Persona(persona.idPersona, nombrePersona)
            db.collection("users").document(persona.idPersona)
                .set(personaUpdate)
                .addOnSuccessListener {
                    Log.d(
                        "ACTUALIZAR",
                        "DocumentSnapshot successfully written!"
                    )
                }
                .addOnFailureListener { e -> Log.w("ACTUALIZAR", "Error writing document", e) }
        }
        buttonCancelar.setOnClickListener { dialog.dismiss() }
        dialog.show()
    }

    override fun onClickEliminar(persona: Persona) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Eliminar")
        builder.setMessage("¿Estas seguro que deseas eliminar?")
        builder.setIcon(android.R.drawable.ic_dialog_alert)
        builder.setPositiveButton("Yes") { dialogInterface, which ->
            db.collection("users")
                .document(persona.idPersona)
                .delete()
                .addOnSuccessListener {
                    adapter.eliminarPersona(persona)
                }
                .addOnFailureListener {
                    Toast.makeText(applicationContext, it.localizedMessage, Toast.LENGTH_SHORT)
                        .show()
                }
            Toast.makeText(applicationContext, "clicked yes", Toast.LENGTH_LONG).show()
        }
        builder.setNegativeButton("No") { dialogInterface, which ->
            Toast.makeText(applicationContext, "clicked No", Toast.LENGTH_LONG).show()
        }
        // Create the AlertDialog
        val alertDialog: AlertDialog = builder.create()
        // Set other dialog properties
        alertDialog.setCancelable(false)
        alertDialog.show()

    }


}