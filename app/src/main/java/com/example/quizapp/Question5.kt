package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Question5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_question5)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val rbutton1 = findViewById<RadioButton>(R.id.q5radiobuttonOne)
        val rbutton2 = findViewById<RadioButton>(R.id.q5radiobuttonTwo)
        val rbutton3 = findViewById<RadioButton>(R.id.q5radiobuttonThree)
        val rbutton4 = findViewById<RadioButton>(R.id.q5radiobuttonFour)

        val radiog = findViewById<RadioGroup>(R.id.radioGroup3)

        val scoreboard5=findViewById<TextView>(R.id.score_question5)

        val btn5=findViewById<Button>(R.id.q5questionSubmit)

        val extras = intent.extras
        val totalScore =
            extras?.getInt("TOTAL_SCORE") ?: 0 // Default to 0 if no score is passed

        scoreboard5.text="Score: $totalScore"

        btn5.setOnClickListener{


            val selectedOptionId = radiog.checkedRadioButtonId
            var currentScore = 0 // Initialize score for this question

            // Check if the answer is correct for Question5
            if (selectedOptionId == R.id.q5radiobuttonThree) { // Replace with correct RadioButton ID
                currentScore = 1 // Award 1 point for the correct answer
            }

            // Add the current score to the total score
            val updatedScore = totalScore + currentScore
            scoreboard5.text="Score: $updatedScore"
            val intent= Intent(this@Question5,Result::class.java)
            intent.putExtra("TOTAL_SCORE", updatedScore)

            startActivity(intent)
        }


    }
}