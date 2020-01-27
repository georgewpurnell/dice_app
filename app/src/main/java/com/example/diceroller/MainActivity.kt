package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private var die1: Int = 0
    private var die2: Int = 0
    lateinit var diceImage1 : ImageView
    lateinit var diceImage2 : ImageView
    private val dice : IntArray = intArrayOf(R.drawable.empty_dice,
        R.drawable.dice_1, R.drawable.dice_2, R.drawable.dice_3,
        R.drawable.dice_4, R.drawable.dice_5, R.drawable.dice_6)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage1 = findViewById(R.id.dice_image_1)
        diceImage2 = findViewById(R.id.dice_image_2)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            die1 = getRandomDiceImage()
            die2 = getRandomDiceImage()
            rollDice(diceImage1, die1)
            rollDice(diceImage2, die2)
        }

        val countUpButton: Button = findViewById(R.id.count_up_button)
        countUpButton.setOnClickListener {
            die1 = incrementDie(die1)
            die2 = incrementDie(die2)
            countUp(diceImage1, die1)
            countUp(diceImage2, die2)
        }
    }

    private fun getRandomDiceImage() : Int {
        return Random().nextInt(6) + 1
    }

    private fun incrementDie(die: Int) : Int {
        if (die < 6) {
            return die + 1
        }
        return die
    }

    private fun rollDice(image: ImageView, dieValue: Int) {
        //Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
        image.setImageResource(dice[dieValue])
    }

    private fun countUp(image: ImageView, die: Int ) {
        image.setImageResource(dice[die])
    }
}
