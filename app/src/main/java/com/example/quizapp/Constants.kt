package com.example.quizapp

object Constants {
    const val USER_NAME = "user_name"
    const val SCORE = "score"
    const val TOTAL = "total"

    fun getQuestions(): ArrayList<Question> {
        return arrayListOf(
            Question(
                0,
                "What country does this flag belong to?",
                R.drawable.flag_of_argentina,
                arrayListOf("India", "Argentina", "Fiji", "Kuwait"),
                1
            ),
            Question(
                1,
                "What country does this flag belong to?",
                R.drawable.flag_of_australia,
                arrayListOf("Belgium", "Australia", "Fiji", "Kuwait"),
                1
            ),
            Question(
                2,
                "What country does this flag belong to?",
                R.drawable.flag_of_belgium,
                arrayListOf("India", "Australia", "Brazil", "Belgium"),
                3
            ),
            Question(
                3,
                "What country does this flag belong to?",
                R.drawable.flag_of_brazil,
                arrayListOf("Brazil", "Australia", "Fiji", "Kuwait"),
                0
            ),
            Question(
                4,
                "What country does this flag belong to?",
                R.drawable.flag_of_denmark,
                arrayListOf("India", "New Zealand", "Denmark", "Kuwait"),
                2
            ),
            Question(
                5,
                "What country does this flag belong to?",
                R.drawable.flag_of_fiji,
                arrayListOf("Germany", "Australia", "Fiji", "Kuwait"),
                2
            ),
            Question(
                6,
                "What country does this flag belong to?",
                R.drawable.flag_of_germany,
                arrayListOf("Germany", "Australia", "Fiji", "Kuwait"),
                0
            ),
            Question(
                7,
                "What country does this flag belong to?",
                R.drawable.flag_of_india,
                arrayListOf("Kuwait", "Australia", "Fiji", "India"),
                3
            ),
            Question(
                8,
                "What country does this flag belong to?",
                R.drawable.flag_of_kuwait,
                arrayListOf("Saudi Arabia", "Australia", "Fiji", "Kuwait"),
                3
            ),
            Question(
                9,
                "What country does this flag belong to?",
                R.drawable.flag_of_new_zealand,
                arrayListOf("Belgium", "Australia", "New Zealand", "Germany"),
                2
            ),

            )
    }
}