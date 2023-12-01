package com.example.finalproject_itapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class EmailFabActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_fab)

        val emailFab: FloatingActionButton = findViewById(R.id.emailFab)

        emailFab.setOnClickListener {
            sendEmailToHOD()
        }
    }

    private fun sendEmailToHOD() {
        val emailIntent = Intent(Intent.ACTION_SENDTO)
        emailIntent.data = Uri.parse("mailto:")
        emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("ithod@ucc.edu.jm"))
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Regarding IT Department")
        if (emailIntent.resolveActivity(packageManager) != null) {
            startActivity(emailIntent)
        }
    }
}