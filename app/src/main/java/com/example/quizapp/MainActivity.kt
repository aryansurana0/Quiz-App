package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//        setContentView(R.layout.activity_main)

        binding.btnStart.setOnClickListener {
            if (binding.tiEtName.text?.isBlank() == true) {
                Toast.makeText(
                    this, "Please enter your name", Toast.LENGTH_SHORT
                ).show()
            }
            else {
                val intent = Intent(this, QuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME, binding.tiEtName.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}