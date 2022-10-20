package com.example.calculator

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var isFirstOperator = true
        var lastOperator = "" ;
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn0.setOnClickListener {
            val txt = binding.textDisplay.text.toString() ;
            binding.textDisplay.text = txt + "0" ;
        }
        binding.btn1.setOnClickListener {
            val txt = binding.textDisplay.text.toString() ;
            binding.textDisplay.text = txt + "1" ;
        }
        binding.btn2.setOnClickListener {
            val txt = binding.textDisplay.text.toString() ;
            binding.textDisplay.text = txt + "2" ;
        }
        binding.btn3.setOnClickListener {
            val txt = binding.textDisplay.text.toString() ;
            binding.textDisplay.text = txt + "3" ;
        }
        binding.btn4.setOnClickListener {
            val txt = binding.textDisplay.text.toString() ;
            binding.textDisplay.text = txt + "4" ;
        }
        binding.btn5.setOnClickListener {
            val txt = binding.textDisplay.text.toString() ;
            binding.textDisplay.text = txt + "5" ;
        }
        binding.btn6.setOnClickListener {
            val txt = binding.textDisplay.text.toString() ;
            binding.textDisplay.text = txt + "6" ;
        }
        binding.btnSeven.setOnClickListener {
            val txt = binding.textDisplay.text.toString() ;
            binding.textDisplay.text = txt + "7" ;
        }
        binding.btn8.setOnClickListener {
            val txt = binding.textDisplay.text.toString() ;
            binding.textDisplay.text = txt + "8" ;
        }
        binding.btn9.setOnClickListener {
            val txt = binding.textDisplay.text.toString() ;
            binding.textDisplay.text = txt + "9" ;
        }
        binding.btnAdd.setOnClickListener {
            val txt = binding.textDisplay.text.toString() ;
            if (isFirstOperator ){
                if (txt.isEmpty()){
                    Toast.makeText(this, "ERROR", Toast.LENGTH_LONG)
                }
                else{
                    lastOperator = "+"
                    binding.textDisplay.text = txt + "+" ;
                    isFirstOperator = false
                }

            }
            else{
                binding.btnEqu.performClick()
                val txt = binding.textDisplay.text.toString() ;
                binding.textDisplay.text = txt + "+"
                lastOperator = "+"
                isFirstOperator = false
            }
        }
        binding.btnMul.setOnClickListener {
            var txt = binding.textDisplay.text.toString() ;
            if (isFirstOperator){
                if (txt.isEmpty()){
                    Toast.makeText(this, "ERROR", Toast.LENGTH_LONG)
                }
                else{
                    lastOperator = "x"
                    binding.textDisplay.text = txt + "x" ;
                    isFirstOperator = false
                }
            }
            else{
                binding.btnEqu.performClick()

                val txt = binding.textDisplay.text.toString() ;
                binding.textDisplay.text = txt + "x"
                lastOperator = "x"
                isFirstOperator = false
            }
        }
        binding.btnSub.setOnClickListener {
            var txt = binding.textDisplay.text.toString() ;
            if (isFirstOperator){
                if (txt.isEmpty()){
                    Toast.makeText(this, "ERROR", Toast.LENGTH_LONG)
                }
                else{
                    lastOperator = "-"
                    binding.textDisplay.text = txt + "-" ;
                    isFirstOperator = false
                }
            }
            else{
                binding.btnEqu.performClick()

                val txt = binding.textDisplay.text.toString() ;
                binding.textDisplay.text = txt + "-"
                lastOperator = "-"
                isFirstOperator = false
            }
        }
        binding.btnDiv.setOnClickListener {
            var txt = binding.textDisplay.text.toString() ;
            if (isFirstOperator){
                if (txt.isEmpty()){
                    Toast.makeText(this, "ERROR", Toast.LENGTH_LONG)
                }
                else{
                    lastOperator = "/"
                    binding.textDisplay.text = txt + "/" ;
                    isFirstOperator = false
                }
            }
            else{
                binding.btnEqu.performClick()

                val txt = binding.textDisplay.text.toString() ;
                binding.textDisplay.text = txt + "/"
                lastOperator = "/"
                isFirstOperator = false
            }
        }
        binding.btnPercent.setOnClickListener {
            var txt = binding.textDisplay.text.toString() ;
            if (isFirstOperator){
                if (txt.isEmpty()){
                    Toast.makeText(this, "ERROR", Toast.LENGTH_LONG)
                }
                else{
                    lastOperator = "%"
                    binding.textDisplay.text = txt + "%" ;
                    isFirstOperator = false
                }
            }
            else{
                binding.btnEqu.performClick()

                val txt = binding.textDisplay.text.toString() ;
                binding.textDisplay.text = txt + "%"
                lastOperator = "%"
                isFirstOperator = false
            }
        }
        binding.btnEqu.setOnClickListener {
            var txt = binding.textDisplay.text.toString() ;
            if (isFirstOperator || txt.endsWith(lastOperator)){
                Toast.makeText(this, "ERROR", Toast.LENGTH_LONG)
            }
            else{
                val opes = txt.split(lastOperator)
                if (lastOperator == "+"){
                    txt = (opes[0].toInt() + opes[1].toInt()).toString()
                }
                else if (lastOperator == "-"){
                    txt = (opes[0].toInt() - opes[1].toInt()).toString()
                }
                else if (lastOperator == "x"){
                    txt = (opes[0].toInt() * opes[1].toInt()).toString()
                }
                else if (lastOperator == "/"){
                    txt = (opes[0].toInt() / opes[1].toInt()).toString()
                }
                else if (lastOperator == "%"){
                    txt = (opes[0].toInt() % opes[1].toInt()).toString()
                }
                binding.textDisplay.text = txt
                lastOperator = ""
                isFirstOperator = true
            }
        }
        binding.btnAC.setOnClickListener {
            lastOperator = "" ;
            isFirstOperator = true ;
            binding.textDisplay.text = ""
        }

    }
}