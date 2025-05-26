package com.example.coursework.quizapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.button.MaterialButton
import android.content.Intent
import android.widget.Button

class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val toolbar = findViewById<MaterialToolbar>(R.id.topAppBar)
//        setSupportActionBar(toolbar)
//
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  // Your main layout XML with the name input

        val nameInput = findViewById<TextInputEditText>(R.id.nameEditText)
        val startQuizButton = findViewById<Button>(R.id.button1)

        startQuizButton.setOnClickListener {
            val userName = nameInput.text?.toString()?.trim()

            if (userName.isNullOrEmpty()) {
                nameInput.error = "Please enter your name"
            } else {
                val intent = Intent(this, QuestionActivity::class.java)
                intent.putExtra("USER_NAME", userName)
                startActivity(intent)

            }
        }
    }
}
