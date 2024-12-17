package com.example.currency_counter

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Declare variables for EditText fields and total TextView
    private lateinit var inputOneCent: EditText
    private lateinit var inputFiveCents: EditText
    private lateinit var inputTenCents: EditText
    private lateinit var inputTwentyFiveCents: EditText
    private lateinit var inputOneDollar: EditText
    private lateinit var inputFiveDollar: EditText
    private lateinit var inputTenDollar: EditText
    private lateinit var inputTwentyDollar: EditText
    private lateinit var inputFiftyDollar: EditText
    private lateinit var inputHundredDollar: EditText
    private lateinit var totalTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize EditText fields and TextView
        inputOneCent = findViewById(R.id.input_one_cent)
        inputFiveCents = findViewById(R.id.input_five_cents)
        inputTenCents = findViewById(R.id.input_ten_cents)
        inputTwentyFiveCents = findViewById(R.id.input_twentyfive_cents)
        inputOneDollar = findViewById(R.id.input_one_dollar)
        inputFiveDollar = findViewById(R.id.input_five_dollar)
        inputTenDollar = findViewById(R.id.input_ten_dollar)
        inputTwentyDollar = findViewById(R.id.input_twenty_dollar)
        inputFiftyDollar = findViewById(R.id.input_fifty_dollar)
        inputHundredDollar = findViewById(R.id.input_hundred_dollar)
        totalTextView = findViewById(R.id.total_text)

        // Add text watchers to all input fields
        addTextWatcher(inputOneCent)
        addTextWatcher(inputFiveCents)
        addTextWatcher(inputTenCents)
        addTextWatcher(inputTwentyFiveCents)
        addTextWatcher(inputOneDollar)
        addTextWatcher(inputFiveDollar)
        addTextWatcher(inputTenDollar)
        addTextWatcher(inputTwentyDollar)
        addTextWatcher(inputFiftyDollar)
        addTextWatcher(inputHundredDollar)
    }

    private fun addTextWatcher(editText: EditText) {
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                calculateTotal()
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun calculateTotal() {
        // Parse input fields and calculate total
        val total = (getInputValue(inputOneCent) * 0.01) +
                (getInputValue(inputFiveCents) * 0.05) +
                (getInputValue(inputTenCents) * 0.10) +
                (getInputValue(inputTwentyFiveCents) * 0.25) +
                (getInputValue(inputOneDollar) * 1.0) +
                (getInputValue(inputFiveDollar) * 5.0) +
                (getInputValue(inputTenDollar) * 10.0) +
                (getInputValue(inputTwentyDollar) * 20.0) +
                (getInputValue(inputFiftyDollar) * 50.0) +
                (getInputValue(inputHundredDollar) * 100.0)

        // Update the total TextView
        totalTextView.text = String.format("Total: $%.2f", total)
    }

    private fun getInputValue(editText: EditText): Double {
        return try {
            editText.text.toString().toDouble()
        } catch (e: NumberFormatException) {
            0.0
        }
    }
}
