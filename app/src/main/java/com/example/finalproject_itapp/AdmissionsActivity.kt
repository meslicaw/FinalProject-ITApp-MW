package com.example.finalproject_itapp

import android.content.Intent

import android.net.Uri

import android.os.Bundle

import android.widget.Button

import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity

class AdmissionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_admissions)

        val admissionsInfoTextView: TextView = findViewById(R.id.admissionsInfoTextView)

        val applicationLinkButton: Button = findViewById(R.id.applicationLinkButton)

        admissionsInfoTextView.text = "Admission Requirements:\n\n" +

                "Bachelor's degree in a related field\n" +

                "Minimum GPA of 3.0\n" +

                "Letters of recommendation\n" +

                "Statement of purpose, etc."

        applicationLinkButton.setOnClickListener {

            val applicationUri = Uri.parse("https://ucc.edu.jm/apply/undergraduate")

            val intent = Intent(Intent.ACTION_VIEW, applicationUri)

            startActivity(intent)

        }

    }

}