package com.example.coursework.quizapp

data class Question(
    val number: Int,
    val questionText: String,
    val flagResId: Int,
    val options: List<String>,
    val correctOptionIndex: Int
)

object QuestionData {
    val questionList = listOf(
        Question(
            number = 1,
            questionText = "Which country does this flag belong to?",
            flagResId = R.drawable.india,
            options = listOf("India", "England", "USA", "Germany"),
            correctOptionIndex = 0,
        ),
        Question(
            number = 2,
            questionText = "Which country does this flag belong to?",
            flagResId = R.drawable.newzealand,
            options = listOf("France", "Newzealand", "Italy", "Canada"),
            correctOptionIndex = 1,
        ),
        Question(
            number = 1,
            questionText = "Which country does this flag belong to?",
            flagResId = R.drawable.north_korea,
            options = listOf("India", "England", "North Korea", "Germany"),
            correctOptionIndex = 2,
        ),
        Question(
            number = 2,
            questionText = "Which country does this flag belong to?",
            flagResId = R.drawable.north_macadonia,
            options = listOf("Norway", "England", "North Macadonia", "Canada"),
            correctOptionIndex = 2,
        ),
        Question(
            number = 1,
            questionText = "Which country does this flag belong to?",
            flagResId = R.drawable.norway,
            options = listOf("India", "Norway", "USA", "Spain"),
            correctOptionIndex = 1,
        ),
        Question(
            number = 2,
            questionText = "Which country does this flag belong to?",
            flagResId = R.drawable.riodejeneiro,
            options = listOf("USA", "England", "Italy", "Rio de jeneiro"),
            correctOptionIndex = 3,
        ),
        Question(
            number = 1,
            questionText = "Which country does this flag belong to?",
            flagResId = R.drawable.spain,
            options = listOf("Spain", "Pakstian", "USA", "Germany"),
            correctOptionIndex = 0,
        ),
        Question(
            number = 2,
            questionText = "Which country does this flag belong to?",
            flagResId = R.drawable.tukey,
            options = listOf("France", "Singapore", "Turkey", "Indonasia"),
            correctOptionIndex = 2,
        ),
        Question(
            number = 1,
            questionText = "Which country does this flag belong to?",
            flagResId = R.drawable.australia,
            options = listOf("Maldives", "Australia", "USA", "Austria"),
            correctOptionIndex = 1,
        ),
        Question(
            number = 2,
            questionText = "Which country does this flag belong to?",
            flagResId = R.drawable.georgia,
            options = listOf("Georgia", "England", "Australia", "Canada"),
            correctOptionIndex = 0,
        ),




        // You can add more questions here
    )
}
