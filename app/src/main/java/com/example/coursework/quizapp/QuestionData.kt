package com.example.coursework.quizapp

import androidx.core.view.ContentInfoCompat.Flags

data class Question(
    val number: Int,
    val questionText: String,
    val flagResId: Int,
    val options: List<String>,
    val correctOptionIndex: Int,
    val difficulty: String,
    val category: String
)

object QuestionData {
    val questionList = listOf(
        Question(
            number = 1,
            questionText = "Which country does this flag belong to?",
            flagResId = R.drawable.india,
            options = listOf("India", "England", "USA", "Germany"),
            correctOptionIndex = 0,"Easy","Flags"
        ),
        Question(
            number = 2,
            questionText = "Which country does this flag belong to?",
            flagResId = R.drawable.newzealand,
            options = listOf("France", "Newzealand", "Italy", "Canada"),
            correctOptionIndex = 1,"Easy","Flags"
        ),
        Question(
            number = 3,
            questionText = "Which country does this flag belong to?",
            flagResId = R.drawable.north_korea,
            options = listOf("India", "England", "North Korea", "Germany"),
            correctOptionIndex = 2,"Easy","Flags"
        ),
        Question(
            number = 4,
            questionText = "Which country does this flag belong to?",
            flagResId = R.drawable.north_macadonia,
            options = listOf("Norway", "England", "North Macadonia", "Canada"),
            correctOptionIndex = 2,"Easy","Flags"
        ),
        Question(
            number = 5,
            questionText = "Which country does this flag belong to?",
            flagResId = R.drawable.norway,
            options = listOf("India", "Norway", "USA", "Spain"),
            correctOptionIndex = 1,"Easy","Flags"
        ),
        Question(
            number = 6,
            questionText = "Which country does this flag belong to?",
            flagResId = R.drawable.riodejeneiro,
            options = listOf("USA", "England", "Italy", "Rio de jeneiro"),
            correctOptionIndex = 3,"Easy","Flags"
        ),
        Question(
            number = 7,
            questionText = "Which country does this flag belong to?",
            flagResId = R.drawable.spain,
            options = listOf("Spain", "Pakstian", "USA", "Germany"),
            correctOptionIndex = 0,"Easy","Flags"
        ),
        Question(
            number = 8,
            questionText = "Which country does this flag belong to?",
            flagResId = R.drawable.tukey,
            options = listOf("France", "Singapore", "Turkey", "Indonasia"),
            correctOptionIndex = 2,"Easy","Flags"
        ),
        Question(
            number = 9,
            questionText = "Which country does this flag belong to?",
            flagResId = R.drawable.australia,
            options = listOf("Maldives", "Australia", "USA", "Austria"),
            correctOptionIndex = 1,"medium","Flags"
        ),
        Question(
            number = 10,
            questionText = "Which country does this flag belong to?",
            flagResId = R.drawable.georgia,
            options = listOf("Georgia", "England", "Australia", "Canada"),
            correctOptionIndex = 0,"hard","Flags"
        ),
        Question(
            number = 8,
            questionText = "What is the capital of France?",
            flagResId = 0,
            options = listOf("Paris", "London", "Berlin", "Madrid"),
            correctOptionIndex = 0,"Easy","General"
        ),
        Question(
            number = 9,
            questionText = "Which animal is known as the 'King of the Jungle'?",
            flagResId = 0,
            options = listOf("Elephant", "Lion", "Tiger", "Giraffe"),
            correctOptionIndex = 1,"Easy","General"
        ),
        Question(
            number = 10,
            questionText = "What is the boiling point of water in Celsius?",
            flagResId = 0,
            options = listOf("90°C", "100°C", "120°C", "80°C"),
            correctOptionIndex = 1,"Medium","Science"
        ),
        Question(
            number = 11,
            questionText = "What is the chemical symbol for Gold?",
            flagResId = 0,
            options = listOf("Gd", "Au", "Ag", "Go"),
            correctOptionIndex = 1,"Medium","Science"
        ),
        Question(
            number = 12,
            questionText = "What is H2O more commonly known as?",
            flagResId = 0,
            options = listOf("Salt", "Water", "Oxygen", "Hydrogen"),
            correctOptionIndex = 1,"Easy","Science"
        ),
        Question(
            number = 13,
            questionText = "Which part of the cell contains DNA?",
            flagResId = 0,
            options = listOf("Nucleus", "Cytoplasm", "Ribosome", "Membrane"),
            correctOptionIndex = 0,"Medium","Science"
        ),
        Question(
            number = 14,
            questionText = "What is the pH of pure water?",
            flagResId = 0,
            options = listOf("6", "7", "8", "5"),
            correctOptionIndex = 1,"Hard","Science"
        ),
        Question(
            number = 15,
            questionText = "What is the capital of Iceland?",
            flagResId = 0,
            options = listOf("Oslo", "Reykjavik", "Helsinki", "Copenhagen"),
            correctOptionIndex = 1,"Hard","General"
        ),
        Question(
            number = 16,
            questionText = "What is the unit of electrical resistance?",
            flagResId = 0,
            options = listOf("Volt", "Watt", "Ohm", "Ampere"),
            correctOptionIndex = 2,"Hard","Science"
        )





        // You can add more questions here
    )
    fun getFilteredQuestions(category: String, difficulty: String): List<Question> {
        return questionList.filter {
            it.category.equals(category, ignoreCase = true) &&
                    it.difficulty.equals(difficulty, ignoreCase = true)
        }
    }


}
