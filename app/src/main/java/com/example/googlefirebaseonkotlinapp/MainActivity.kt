package com.example.googlefirebaseonkotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val text: TextView = findViewById(R.id.textview)

        database = Firebase.database.reference

        //Writing Custom Objects to Firebase

        val user1:User = User("gacmalony","11235")
        database.child("Users").setValue(user1)


        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get Post object and use the values to update the UI
                val getvalue = dataSnapshot.getValue<User>()
                text.text = getvalue.toString()
            }

            override fun onCancelled(databaseError: DatabaseError) {
            }
        }
        database.child("Users").addValueEventListener(postListener)

    }}

        //Reference
        /*/database = Firebase.database.reference

        //Write data to Firebase
        database.child("city").setValue("Karlsruhe")

        //Read data from FireBase
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get Post object and use the values to update the UI
                val getvalue = dataSnapshot.getValue()
                text.text = getvalue.toString()
            }

            override fun onCancelled(databaseError: DatabaseError) {
            }
        }
        database.child("city").addValueEventListener(postListener)

    }
}/*/