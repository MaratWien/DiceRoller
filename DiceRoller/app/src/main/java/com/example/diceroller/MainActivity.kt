package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


var diceRollValue: Int = 0

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener {
            rollDice(R.id.imageView)
            rollDice(R.id.imageView2)
//            Toast.makeText(this, "Dice Roll value is $diceRollValue", Toast.LENGTH_SHORT).show()
        }
        rollDice(R.id.imageView)
        rollDice(R.id.imageView2)
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice(imageId: Int) {
        val dice = Dice(6)
        diceRollValue = dice.roll()

        val diceImage: ImageView = findViewById(imageId)

        val drawableResource = when(diceRollValue) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.contentDescription = diceRollValue.toString()
        diceImage.setImageResource(drawableResource)

    }
}


class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}

