package com.example.alfa_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.alfa_calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn0.setOnClickListener { actionForViewInput("0") }
        binding.btn1.setOnClickListener { actionForViewInput("1") }
        binding.btn2.setOnClickListener { actionForViewInput("2") }
        binding.btn3.setOnClickListener { actionForViewInput("3") }
        binding.btn4.setOnClickListener { actionForViewInput("4") }
        binding.btn5.setOnClickListener { actionForViewInput("5") }
        binding.btn6.setOnClickListener { actionForViewInput("6") }
        binding.btn7.setOnClickListener { actionForViewInput("7") }
        binding.btn8.setOnClickListener { actionForViewInput("8") }
        binding.btn9.setOnClickListener { actionForViewInput("9") }
        binding.btnDot.setOnClickListener { actionForViewInput(",") }

        binding.btnOpenBracket.setOnClickListener { actionForViewInput("(") }
        binding.btnCloseBracket.setOnClickListener { actionForViewInput(")") }
        binding.btnDivide.setOnClickListener { actionForViewInput("/") }
        binding.btnMultiply.setOnClickListener { actionForViewInput("*") }
        binding.btnMinus.setOnClickListener { actionForViewInput("-") }
        binding.btnPlus.setOnClickListener { actionForViewInput("+") }

        binding.btnHistory.setOnClickListener { showHistory() }
        binding.btnPlusMinus.setOnClickListener { changeSing() }
        binding.btnEqual.setOnClickListener { countResult() }
        binding.btnDelete.setOnClickListener { dropLast() }
        binding.btnClear.setOnClickListener {
            binding.textViewInput.text = ""
            binding.textViewResult.text = ""
        }

    }

    private fun actionForViewInput(str: String) {
        binding.textViewInput.append(str)
    }

    private fun dropLast() {
        binding.textViewInput.text = binding.textViewInput.text.dropLast(1)
    }

    private fun countResult() {
        if (binding.textViewInput.text == "")
            binding.textViewResult.text = "you put nothing"
        else binding.textViewResult.text = "will be answer"
    }

    private fun changeSing() {
        binding.textViewResult.text = "I don`t know how to do it"
    }

    private fun showHistory() {
        binding.textViewResult.text = "I don`t know what to do"
    }
}