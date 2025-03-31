package com.example.quizapp

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.collection.emptyLongSet
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Questions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_questions)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tv2=findViewById<TextView>(R.id.textViewQuestions1)
        val btn1ques=findViewById<Button>(R.id.ques1next)
        val rbutton1=findViewById<RadioButton>(R.id.q1radioButtonOne)
        val rbutton2=findViewById<RadioButton>(R.id.q1radioButtonTwo)
        val rbutton3=findViewById<RadioButton>(R.id.q1radioButtonThree)
        val rbutton4=findViewById<RadioButton>(R.id.q1radioButtonFour)
//        val radioButton = findViewById<RadioButton>(R.id.q1radioButtonOne)
//        radioButton.buttonTintList = ColorStateList.valueOf(Color.parseColor("#B8860B"))


        val radiog = findViewById<RadioGroup>(R.id.radioGroup)


        // Retrieve the total score passed from MainActivity
        val extras = intent.extras
        val totalScore = extras?.getInt("SCORE") ?: 0 // Default to 0 if no score is passed
        val scoreboard=findViewById<TextView>(R.id.score_question1)

        scoreboard.text="Score: 0"

        btn1ques.setOnClickListener {
            val selectedOptionId = radiog.checkedRadioButtonId
            var currentscore: Int = 0 // Initialize the score for this question

            // Check if the selected option matches the correct answer ID
            if (selectedOptionId == R.id.q1radioButtonThree) { // Replace with correct RadioButton ID
                currentscore = 1 // Correct answer gives 1 point
            }


            // Add current score to the total score
            val updatedScore = totalScore + currentscore

            scoreboard.text="Score: $updatedScore"

            // Pass the updated score to Question2 activity
            val intent = Intent(this@Questions, Question2::class.java)
            intent.putExtra("TOTAL_SCORE", updatedScore) // Pass the cumulative score
            startActivity(intent)
        }




    }
}