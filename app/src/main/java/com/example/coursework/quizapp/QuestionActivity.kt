package com.example.coursework.quizapp

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.coursework.quizapp.databinding.QuizQuestionsBinding

class QuestionActivity : AppCompatActivity() {

    private lateinit var binding: QuizQuestionsBinding
    private var currentIndex = 0
    private var score = 0

    private val questions = QuestionData.questionList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = QuizQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadQuestion()

        binding.nextButton.setOnClickListener {
            val selectedRadioId = binding.optionsGroup.checkedRadioButtonId
            if (selectedRadioId == -1) {
                Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val selectedRadioButton = findViewById<RadioButton>(selectedRadioId)
            val selectedIndex = binding.optionsGroup.indexOfChild(selectedRadioButton)

            val isCorrect = selectedIndex == questions[currentIndex].correctOptionIndex
            if (isCorrect) score++


            showResultPopup(isCorrect) {
                if (currentIndex < questions.size - 1) {
                    currentIndex++
                    loadQuestion()
                } else {
                    val userName = intent.getStringExtra("USER_NAME")

                    val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra("USER_NAME", userName)
                    intent.putExtra("SCORE", score)
                    intent.putExtra("TOTAL", questions.size)
                    startActivity(intent)
                    finish()

                }
            }
        }
    }

    private fun loadQuestion() {
        val question = questions[currentIndex]
        binding.progressText.text = "Question ${question.number} of ${questions.size}"
        binding.questionText.text = question.questionText
        binding.flagImageView.setImageResource(question.flagResId)
        binding.optionsGroup.clearCheck()

        for (i in 0 until binding.optionsGroup.childCount) {
            val radioButton = binding.optionsGroup.getChildAt(i) as RadioButton
            radioButton.text = question.options[i]
        }
    }

    // Show a popup image for correct/incorrect answer
    private fun showResultPopup(isCorrect: Boolean, onDismiss: () -> Unit) {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.pop_result, null)
        val resultImage = dialogView.findViewById<ImageView>(R.id.resultImage)
        resultImage.setImageResource(if (isCorrect) R.drawable.correct else R.drawable.incorrect)
        val resultText=dialogView.findViewById<TextView>(R.id.textMsg)
        resultText.setText(if(isCorrect) "correct" else "Incorrect")

        val dialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .setCancelable(false)
            .create()

        dialog.show()

        Handler(Looper.getMainLooper()).postDelayed({
            dialog.dismiss()
            onDismiss()
        }, 1500)
    }
}
