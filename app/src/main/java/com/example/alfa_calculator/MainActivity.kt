package com.example.alfa_calculator

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.alfa_calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var inputView: TextView
    lateinit var resultView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        inputView = binding.textViewInput
        resultView = binding.textViewResult

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
        binding.btnDot.setOnClickListener { actionForViewInput(".") }

        binding.btnOpenBracket.setOnClickListener { actionForViewInput("(") }
        binding.btnCloseBracket.setOnClickListener { actionForViewInput(")") }
        binding.btnDivide.setOnClickListener { actionForViewInput("/") }
        binding.btnMultiply.setOnClickListener { actionForViewInput("*") }
        binding.btnMinus.setOnClickListener { actionForViewInput("-") }
        binding.btnPlus.setOnClickListener { actionForViewInput("+") }

        binding.btnHistory.setOnClickListener { showHistory() }
        binding.btnPlusMinus.setOnClickListener { changeSign() }
        binding.btnEqual.setOnClickListener { sendAnswer() }
        binding.btnDelete.setOnClickListener { dropLast() }
        binding.btnClear.setOnClickListener {
            inputView.text = ""
            resultView.text = ""
        }

    }

    private fun actionForViewInput(str: String) {
        inputView.append(str)
        countResult()
    }

    private fun dropLast() {
        if (inputView.text.toString().isNotEmpty()) {
            inputView.text = inputView.text.dropLast(1)
            countResult()
        }
    }

    private fun countResult() {
        if (inputView.text.toString().isEmpty())
            resultView.text = ""
        else {
            try {
                val expression = ExpressionBuilder(inputView.text.toString()).build()
                val result = expression.evaluate()
                val resultInLong = result.toLong()

                if (result == resultInLong.toDouble())
                    resultView.text = resultInLong.toString()
                else
                    resultView.text = result.toString()
            } catch (e:Exception) {
                Log.d("ERROR", "ERROR IS: ${e.message}")
                resultView.text = ""
            }
        }
    }

    private fun sendAnswer() {
        if (inputView.text.toString().isNotEmpty()) {
            inputView.text = resultView.text
            resultView.text = ""
        }
    }

    private fun changeSign() {
        resultView.text = "in developing..."
    }

    private fun showHistory() {
        resultView.text = "in developing..."
    }
}