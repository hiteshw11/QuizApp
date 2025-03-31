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

class Question3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_question3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn3 = findViewById<Button>(R.id.buttonQuestion3)

        val rbutton1 = findViewById<RadioButton>(R.id.q3radioButtonOne)
        val rbutton2 = findViewById<RadioButton>(R.id.q3radioButtonTwo)
        val rbutton3 = findViewById<RadioButton>(R.id.q3radioButtonThree)
        val rbutton4 = findViewById<RadioButton>(R.id.q3radioButtonFour)


        val radiog = findViewById<RadioGroup>(R.id.radioGroup4)

        val scoreboard3=findViewById<TextView>(R.id.score_question3)

        // Retrieve the total score from the previous activity
        val extras = intent.extras
        val totalScore =
            extras?.getInt("TOTAL_SCORE") ?: 0 // Default to 0 if no score is passed
        scoreboard3.text="Score: $totalScore"

        btn3.setOnClickListener {




                val selectedOptionId = radiog.checkedRadioButtonId
                var currentScore = 0 // Initialize score for this question

                // Check if the answer is correct for Question3
                if (selectedOptionId == R.id.q3radioButtonThree) { // Replace with correct RadioButton ID
                    currentScore = 1 // Award 1 point for the correct answer
                }

                // Add the current score to the total score
                val updatedScore = totalScore + currentScore

                scoreboard3.text="Score: $updatedScore"
                val intent = Intent(this@Question3, Question4::class.java)
                intent.putExtra("TOTAL_SCORE", updatedScore)

                startActivity(intent)
            }

        }
    }
