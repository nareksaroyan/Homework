package com.example.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editText)
        var text = editText.text
        val value = text.toString().toInt()
        intToWords(value)

    }

    fun intToWords(num: Int): String {
        val oneToNineteenDigits = arrayOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen")
        val tensWords = arrayOf("twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety")
        val biggersWords = arrayOf("hundred", "thousand", "million")

        return when {
            num < 20 -> oneToNineteenDigits[num]
            num < 100 -> tensWords[num / 10 - 2] + (if (num % 10 != 0) " " + oneToNineteenDigits[num % 10] else "")
            num < 1000 -> oneToNineteenDigits[num / 100] + " " + biggersWords[0] + (if (num % 100 != 0) " and " + intToWords(num % 100) else "")
            num < 1000000 -> intToWords(num / 1000) + " " + biggersWords[1] + (if (num % 1000 != 0) " " + intToWords(num % 1000) else "")
            else -> intToWords(num / 1000000) + " " + biggersWords[2] + (if (num % 1000000 != 0) " " + intToWords(num % 1000000) else "")
        }
    }
}