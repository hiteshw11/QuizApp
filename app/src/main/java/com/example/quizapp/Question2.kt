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

class Question2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()



        setContentView(R.layout.activity_question2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val btn2=findViewById<Button>(R.id.button2)

        val btn2ques=findViewById<Button>(R.id.button2)
        val rbutton1=findViewById<RadioButton>(R.id.q2radiobutonOne)
        val rbutton2=findViewById<RadioButton>(R.id.q2radiobuttonTwo)
        val rbutton3=findViewById<RadioButton>(R.id.q2radiobuttonThree)
        val rbutton4=findViewById<RadioButton>(R.id.q2radiobuttonFour)


        val radiog = findViewById<RadioGroup>(R.id.radioGroup6)

        val scoreboard2=findViewById<TextView>(R.id.score_question2)


        val extras = intent.extras
        val totalScore = extras?.getInt("TOTAL_SCORE") ?: 0 // Default to 0 if no score is passed
        scoreboard2.text="Score: $totalScore"

        btn2.setOnClickListener{

            val selectedOptionId = radiog.checkedRadioButtonId
            var currentScore = 0 // Initialize score for this question

            // Check if the answer is correct for this question
            if (selectedOptionId == R.id.q2radiobuttonFour) { // Replace with the correct RadioButton ID
                currentScore = 1 // Award 1 point for the correct answer
            }

            // Add the current score to the total score
            val updatedScore = totalScore + currentScore

            scoreboard2.text="Score: $updatedScore"
            val intent= Intent(this@Question2,Question3::class.java)
            intent.putExtra("TOTAL_SCORE", updatedScore)

            startActivity(intent)
        }



    }
}