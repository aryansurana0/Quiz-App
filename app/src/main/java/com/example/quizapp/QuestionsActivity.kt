package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.quizapp.databinding.ActivityQuestionsBinding

class QuestionsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuestionsBinding
    private lateinit var questionsList: ArrayList<Question>
    private lateinit var optionTVs: ArrayList<TextView>
    private var currPosition = -1
    private var selectedOption = -1

    private var score = 0
    private var goToNextQ = false

    private lateinit var userName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        code to use fragments
//        if (savedInstanceState == null) {
//            val bundle = bundleOf()
//            supportFragmentManager.commit {
//                setReorderingAllowed(true)
//                add<QuestionFragment>(R.id.fragment_container_view_question)
//            }
//        }

        binding = ActivityQuestionsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//        setContentView(R.layout.activity_questions)

        userName = intent.getStringExtra(Constants.USER_NAME).toString()


        questionsList = Constants.getQuestions()
        Log.i("questionsList size is", "${questionsList.size}")

        binding.progressBar.max = questionsList.size

        optionTVs = arrayListOf<TextView>(
            binding.tvOption0,
            binding.tvOption1,
            binding.tvOption2,
            binding.tvOption3
        )

        for (tv in optionTVs) {
            tv.setOnClickListener { optionTvSelected(it) }
        }
        binding.btnSubmitAns.setOnClickListener { onSubmit(it) }

        setupLayoutOrSubmit()
    }

    private fun setupLayoutOrSubmit() {
        selectedOption = -1
        currPosition++
        goToNextQ = false
        if (currPosition < questionsList.size) {
            val currQ = questionsList[currPosition]

            binding.tvQuestion.text = currQ.question

            val correctAns = currQ.options.elementAt(currQ.correctAnswer).replace(' ', '_')
            val imgSrc = "flag_of_${correctAns.lowercase()}"
            val resID = resources.getIdentifier(imgSrc, "drawable", packageName)
            binding.imgvFlag.setImageResource(resID)

            binding.progressBar.progress = currPosition + 1
            val progressText = "${currPosition + 1}/${questionsList.size}"
            binding.tvProgress.text = progressText

            for (i in 0..3) {
                optionTVs[i].text = currQ.options[i]
                optionTVs[i].setBackgroundResource(R.drawable.options_tv_bg)
            }

            if (currPosition == questionsList.size - 1) {
                binding.btnSubmitAns.text = "FINISH"
            } else {
                binding.btnSubmitAns.text = "SUBMIT"
            }
        }
        else {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra(Constants.USER_NAME, userName)
            intent.putExtra(Constants.SCORE, score)
            intent.putExtra(Constants.TOTAL, questionsList.size)
            startActivity(intent)
            finish()
        }
    }

    private fun optionTvSelected(view: View) {
        if (!goToNextQ) {
            view.setBackgroundResource(R.drawable.selected_option_tv_bg)
            for (i in 0..3) {
                if (view == optionTVs[i]) {
                    selectedOption = i
                    continue
                }
                optionTVs[i].setBackgroundResource(R.drawable.options_tv_bg)
            }
        }
    }

    private fun onSubmit(view: View) {
        if (selectedOption == -1) {
            Toast.makeText(this, "Select an option", Toast.LENGTH_SHORT).show()
            return
        }
        if (goToNextQ) setupLayoutOrSubmit()
        else {
            if (currPosition < questionsList.size) {
                val currQ = questionsList[currPosition]
                if (selectedOption == currQ.correctAnswer)
                    score++
                optionTVs[selectedOption].setBackgroundResource(R.drawable.wrong_option_tv_bg)
                optionTVs[currQ.correctAnswer].setBackgroundResource(R.drawable.correct_option_tv_bg)

                if (currPosition < questionsList.size - 1) binding.btnSubmitAns.text = "Next Question"
                goToNextQ = true
            }
        }
    }

}