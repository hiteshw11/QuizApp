package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.collection.emptyLongSet
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text
import java.util.Calendar

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val playagain=findViewById<Button>(R.id.play_again)
        val result_heading=findViewById<TextView>(R.id.textViewResult)
        val footerTextView = findViewById<TextView>(R.id.footer_result)
        footerTextView.text = "Powered by Hitesh Wadhwa Apps © ${Calendar.getInstance().get(Calendar.YEAR)}"

        // Reference to UI elements
        val finalScoreTextView = findViewById<TextView>(R.id.finalScore)
       // val restartButton = findViewById<Button>(R.id.restartQuiz)
        //val exitButton = findViewById<Button>(R.id.exitApp)

        // Retrieve the final score passed from the last activity
        val extras = intent.extras
        val finalScore = extras?.getInt("TOTAL_SCORE") ?: 0 // Default to 0 if no score is passed

        if(finalScore>=3)
        {
            result_heading.text="Congratulations You Did Well"
            finalScoreTextView.text = "Great Score: $finalScore Points"
        }
        else{
            result_heading.text="Would You Like To Play Again?"
            finalScoreTextView.text = "You Only Scored $finalScore Points"
        }

        // Display the final score


        playagain.setOnClickListener {
            val intent= Intent(this@Result,MainActivity::class.java)
            startActivity(intent)
        }

    }
}