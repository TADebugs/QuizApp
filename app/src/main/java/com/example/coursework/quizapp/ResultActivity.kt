package com.example.coursework.quizapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.coursework.quizapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("USER_NAME")
        val score = intent.getIntExtra("SCORE", 0)
        val total = intent.getIntExtra("TOTAL", 0)
        val time = intent.getLongExtra("TIME", 0)



        binding.timeText.text = "Completed in $time seconds"


        binding.playerNameText.text = name
        binding.scoreText.text = "Your Score: $score / $total"

        binding.restartButton.setOnClickListener{
            val intent = Intent(this, QuestionActivity::class.java)
            intent.putExtra("USER_NAME", binding.playerNameText.text.toString())
            startActivity(intent)
            finish()
        }
        binding.QuitButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
//        binding.restartButton.setOnClickListener {
//            val intent = Intent(this, QuestionActivity::class.java)
//            intent.putExtra("USER_NAME", binding.playerNameText.text.toString()) // pass the same name again
//            startActivity(intent)
//
//        }


    }
}
