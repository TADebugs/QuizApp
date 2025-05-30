package com.example.coursework.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class CategoryPickerActivity : AppCompatActivity() {

    private lateinit var categoryButtons: List<Button>
    private lateinit var difficultyButtons: List<Button>

    private lateinit var startQuizBtn: Button

    private var selectedCategory: String? = null
    private var selectedDifficulty: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_quiz)


        // Link category buttons
        val categoryFlag = findViewById<Button>(R.id.categoryFlag)
        val categoryScience = findViewById<Button>(R.id.categoryScience)
        val categoryGeneral = findViewById<Button>(R.id.categoryGeneral)

        categoryButtons = listOf(categoryFlag, categoryScience, categoryGeneral)

        // Link difficulty buttons
        val diffEasy = findViewById<Button>(R.id.diffEasy)
        val diffMedium = findViewById<Button>(R.id.diffMedium)
        val diffHard = findViewById<Button>(R.id.diffHard)

        difficultyButtons = listOf(diffEasy, diffMedium, diffHard)

        startQuizBtn = findViewById(R.id.startQuizBtn)

        setupCategoryButtons()
        setupDifficultyButtons()
        setupStartQuizButton()
    }

    private fun setupCategoryButtons() {
        categoryButtons.forEach { button ->
            button.setOnClickListener {
                selectedCategory = button.text.toString()
                resetButtons(categoryButtons, R.color.colorLightPrimary)
                button.setBackgroundColor(ContextCompat.getColor(this, R.color.categoryBrown))
            }
        }
    }

    private fun setupDifficultyButtons() {
        difficultyButtons.forEach { button ->
            button.setOnClickListener {
                selectedDifficulty = button.text.toString()
                resetButtons(difficultyButtons, R.color.colorLightPrimary)

                val colorRes = when (selectedDifficulty) {
                    "Easy" -> R.color.easyGreen
                    "Medium" -> R.color.mediumYellow
                    "Hard" -> R.color.hardRed
                    else -> R.color.colorLightPrimary
                }

                button.setBackgroundColor(ContextCompat.getColor(this, colorRes))
            }
        }
    }

    private fun setupStartQuizButton() {
        startQuizBtn.setOnClickListener {
            if (selectedCategory != null && selectedDifficulty != null) {
                val intent = Intent(this, QuestionActivity::class.java).apply {
                    putExtra("CATEGORY", selectedCategory)
                    putExtra("DIFFICULTY", selectedDifficulty)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please select both category and difficulty!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun resetButtons(buttons: List<Button>, defaultColorRes: Int) {
        buttons.forEach {
            it.setBackgroundColor(ContextCompat.getColor(this, defaultColorRes))
        }
    }
}
