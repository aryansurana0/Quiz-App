package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizapp.databinding.ActivityQuestionsBinding
import com.example.quizapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    private lateinit var userName: String
    private var score: Int = 0
    private var total: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//        setContentView(R.layout.activity_result)

        userName = intent.getStringExtra(Constants.USER_NAME).toString()
        score = intent.getIntExtra(Constants.SCORE, 0)
        total = intent.getIntExtra(Constants.TOTAL, 0)

        binding.tvDisplayName.text = userName

        val resultString = "Your score is $score out of $total"
        binding.tvDisplayResult.text = resultString

        binding.btnFinish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }
}