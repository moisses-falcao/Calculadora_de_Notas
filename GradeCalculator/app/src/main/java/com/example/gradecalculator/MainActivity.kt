package com.example.gradecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gradecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btCalculate.setOnClickListener{
            calc()
        }
    }

    private fun calc(){

        val grade1 = Integer.parseInt(binding.field1.text.toString())
        val grade2 = Integer.parseInt(binding.field2.text.toString())
        val grade3 = Integer.parseInt(binding.field3.text.toString())
        val grade4 = Integer.parseInt(binding.field4.text.toString())
        val falts = Integer.parseInt(binding.absences.text.toString())

        val average = (grade1 + grade2 + grade3 + grade4)/4

        if(average >= 5 && falts <= 20){
            binding.Result.setText("Aluno foi aprovado.\nMédia final: $average")
            binding.Result.setTextColor(getColor(R.color.green))
        }
        else if(falts > 20) {
            binding.Result.setText("Aluno foi reprovado por faltas.\nMédia final: $average")
            binding.Result.setTextColor(getColor(R.color.red))
        }
        else if(average < 5) {
            binding.Result.setText("Aluno foi reprovado por nota.\nMédia filnal: $average")
            binding.Result.setTextColor(getColor(R.color.red))
        }
    }
}