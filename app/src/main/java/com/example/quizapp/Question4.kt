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

class Question4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_question4)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val rbutton1 = findViewById<RadioButton>(R.id.q4radiobuttonOne)
        val rbutton2 = findViewById<RadioButton>(R.id.q4radiobuttonTwo)
        val rbutton3 = findViewById<RadioButton>(R.id.q4radiobuttonThree)
        val rbutton4 = findViewById<RadioButton>(R.id.q4radiobuttonFour)

        val radiog = findViewById<RadioGroup>(R.id.radioGroup2)

        val btn4=findViewById<Button>(R.id.button4)

        val scoreboard4=findViewById<TextView>(R.id.score_question4)

        val extras = intent.extras
        val totalScore =
            extras?.getInt("TOTAL_SCORE") ?: 0 // Default to 0 if no score is passed

        scoreboard4.text="Score: $totalScore"
        btn4.setOnClickListener{


            val selectedOptionId = radiog.checkedRadioButtonId
            var currentScore = 0 // Initialize score for this question

            // Check if the answer is correct for Question3
            if (selectedOptionId == R.id.q4radiobuttonOne) { // Replace with correct RadioButton ID
                currentScore = 1 // Award 1 point for the correct answer
            }

            // Add the current score to the total score
            val updatedScore = totalScore + currentScore
            scoreboard4.text="Score: $updatedScore"
            val intent= Intent(this@Question4,Question5::class.java)
            intent.putExtra("TOTAL_SCORE", updatedScore)
            startActivity(intent)
        }


    }
}