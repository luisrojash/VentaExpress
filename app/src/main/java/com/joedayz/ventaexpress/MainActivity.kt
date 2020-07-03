package com.joedayz.ventaexpress

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        buttonAgregar.setOnClickListener {
            val nombrePersona = editTextPersonaNombre.text.toString()
            val user = Users(nombrePersona)

            db.collection("users")
                .add(user)
                .addOnSuccessListener { documentReference ->
                    Log.d("MainActivity", "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w("MainActivity", "Error adding document", e)
                }

        }

        db.collection("users")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("MainActivity", "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("MainActivity", "Error getting documents: ", exception)
            }

        db.collection("users")
            .addSnapshotListener { snapshots, e ->
                if (e != null) {
                    Log.w("MainActivity", "listen:error", e)
                    return@addSnapshotListener
                }

                for (dc in snapshots!!.documentChanges) {
                    when (dc.type) {
                        DocumentChange.Type.ADDED -> Log.d("MainActivity", "New city: ${dc.document.data}")
                        DocumentChange.Type.MODIFIED -> Log.d("MainActivity", "Modified city: ${dc.document.data}")
                        DocumentChange.Type.REMOVED -> Log.d("MainActivity", "Removed city: ${dc.document.data}")
                    }
                }
            }




    }

}

data class Users(var nombrePersona: String)