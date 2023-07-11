package com.example.guessnumbergame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.R.attr.button
import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnValue10.setOnClickListener{
            val activityGuess = Intent(this,GuessPage::class.java)
            activityGuess.putExtra("valueBtn", "10")
            startActivity(activityGuess);
        }

        btnValue50.setOnClickListener{
            val activityGuess = Intent(this,GuessPage::class.java)
            activityGuess.putExtra("valueBtn", "50")
            startActivity(activityGuess);
        }

        btnValue100.setOnClickListener{
            val activityGuess = Intent(this,GuessPage::class.java)
            activityGuess.putExtra("valueBtn", "100")
            startActivity(activityGuess);
        }


    }
}
