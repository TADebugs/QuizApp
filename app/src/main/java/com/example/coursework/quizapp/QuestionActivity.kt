package com.example.coursework.quizapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.coursework.quizapp.databinding.QuizQuestionsBinding
import com.google.android.material.button.MaterialButton

class QuestionActivity : AppCompatActivity() {

    private lateinit var binding: QuizQuestionsBinding
    private var currentIndex = 0
    private var score = 0
    private var quizStartTime: Long = 0L
    private lateinit var optionButtons: List<MaterialButton>
    private lateinit var userName: String
    private lateinit var questions: List<Question> // CHANGED from `val` to `lateinit var`

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = QuizQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userName = intent.getStringExtra("USER_NAME") ?: "Player"

        val category = intent.getStringExtra("CATEGORY") ?: "Flag"
        val difficulty = intent.getStringExtra("DIFFICULTY") ?: "Easy"

        questions = QuestionData.getFilteredQuestions(category, difficulty)

        if (questions.isEmpty()) {
            Toast.makeText(this, "No questions found for $category - $difficulty", Toast.LENGTH_LONG).show()
            finish()
            return
        }

        optionButtons = listOf(binding.option1, binding.option2, binding.option3, binding.option4)
        quizStartTime = System.currentTimeMillis()
        loadQuestion()

        optionButtons.forEachIndexed { index, button ->
            button.setOnClickListener {
                handleAnswerSelection(index, button)
            }
        }
    }


    private fun loadQuestion() {


        val category = intent.getStringExtra("CATEGORY") ?: "Flag"
        val difficulty = intent.getStringExtra("DIFFICULTY") ?: "Easy"


        val questions = QuestionData.getFilteredQuestions(category, difficulty)

        val question = questions[currentIndex]
        binding.progressText.text = "Question ${question.number} of ${questions.size}"
        binding.questionText.text = question.questionText
        binding.flagImageView.setImageResource(question.flagResId)

        optionButtons.forEachIndexed { i, btn ->
            btn.text = question.options[i]
            btn.setBackgroundColor(Color.WHITE)
            btn.setTextColor(Color.BLACK)
            btn.isEnabled = true
        }

        // ProgressBar update
        binding.quizProgressBar.max = questions.size
        binding.quizProgressBar.progress = currentIndex
    }

    private fun handleAnswerSelection(selectedIndex: Int, selectedButton: MaterialButton) {
        val correctIndex = questions[currentIndex].correctOptionIndex

        // Disable all buttons
        optionButtons.forEach { it.isEnabled = false }

        if (selectedIndex == correctIndex) {
            selectedButton.setBackgroundColor(Color.parseColor("#4CAF50")) // green
            selectedButton.setTextColor(Color.WHITE)
            score++
        } else {
            selectedButton.setBackgroundColor(Color.parseColor("#F44336")) // red
            selectedButton.setTextColor(Color.WHITE)
            optionButtons[correctIndex].setBackgroundColor(Color.parseColor("#4CAF50"))
            optionButtons[correctIndex].setTextColor(Color.WHITE)
        }

        Handler(Looper.getMainLooper()).postDelayed({
            if (currentIndex < questions.size - 1) {
                currentIndex++
                loadQuestion()
            } else {
                val totalTimeMillis = System.currentTimeMillis() - quizStartTime
                val totalTimeSecs = totalTimeMillis / 1000
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("SCORE", score)
                intent.putExtra("TOTAL", questions.size)
                intent.putExtra("USER_NAME", userName)
                intent.putExtra("TIME", totalTimeSecs)
                startActivity(intent)
                finish()
            }
        }, 1500)
    }
}
