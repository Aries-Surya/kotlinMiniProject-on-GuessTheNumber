package com.example.guessnumbergame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_guess_page.*
import android.app.AlertDialog
import android.content.DialogInterface




class GuessPage : AppCompatActivity() {

    public var randomNumber: Int = 0
    public var numberAttempts: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guess_page)

        val intent = getIntent();
        val maximumValueSelected = intent.getStringExtra("valueBtn")

        randomNumber= (1..maximumValueSelected.toInt()).random()

        textCenter2.setText(" I am thinking of a number between 1 and " + maximumValueSelected + ".")

        val actionBar = supportActionBar
        actionBar!!.title = "Back to the main page"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)

        checkMessage.setText("")


        btnCheckValue.setOnClickListener {

            numberAttempts++

            if(valueTextView.text.toString().trim().length > 0) {

                val valueToCheck: Int = valueTextView.text.toString().toInt()

                if(valueToCheck == randomNumber)
                {
                    checkMessage.setText("Congratulations. You guessed my number from " + numberAttempts +  " attempts!")


                }else if(valueToCheck > randomNumber)
                {
                    checkMessage.setText("Your guess is too high. " + numberAttempts +  " attempts!")
                    valueTextView.setText("")
                }
                else
                {
                    checkMessage.setText("Your guess is too low. " + numberAttempts +  " attempts!")
                    valueTextView.setText("")
                }
            }else{

                val dialogBuilder = AlertDialog.Builder(this)
                dialogBuilder.setMessage("Please chosse a Number between 1 and " + maximumValueSelected)
                    .setCancelable(false)
                    .setNegativeButton("OK", DialogInterface.OnClickListener {
                            dialog, id -> dialog.cancel()
                    })
                val alert = dialogBuilder.create()
                alert.setTitle("Message")
                alert.show()
            }
        }

        generateNewNumber.setOnClickListener {
            randomNumber = (1..maximumValueSelected.toInt()).random()
            numberAttempts = 0
            checkMessage.setText("")
            valueTextView.setText("")

            val dialogBuilder = AlertDialog.Builder(this)
            dialogBuilder.setMessage("A new random number has been generated")
                .setCancelable(false)
                .setNegativeButton("OK", DialogInterface.OnClickListener {
                        dialog, id -> dialog.cancel()
                })
            val alert = dialogBuilder.create()
            alert.setTitle("Message")
            alert.show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}
