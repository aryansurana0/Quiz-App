package com.example.quizapp

data class Question(
    val id: Int,
    val question: String,
    val img: Int,
    val options: ArrayList<String>,
    val correctAnswer: Int
)
