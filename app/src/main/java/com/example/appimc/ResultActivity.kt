package com.example.appimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.example.appimc.MainActivity.Companion.IMC_KEY

class ResultActivity : AppCompatActivity() {

    private lateinit var tvResult:TextView
    private lateinit var tvImc:TextView
    private lateinit var tvDescription:TextView
    private lateinit var btnReCalculate:AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.extras?.getDouble(IMC_KEY) ?: -1.0
        initComponents()
        initUI(result)
        initListeners()
    }

    private fun initListeners() {
        btnReCalculate.setOnClickListener {
            onBackPressed()
        }
    }

    private fun initUI(result: Double) {

        tvImc.text = result.toString()

        when(result) {
            in 0.00..18.50 -> { //BAJO PESO
                tvResult.text = getString(R.string.titleBajoPeso)
                tvResult.setTextColor(getColor(R.color.peso_bajo))
                tvDescription.text = getString(R.string.DescriptionBajoPeso)
            }
        }
        when(result) {
            in 18.51..24.99 -> { //PESO NORMAL
                tvResult.text = getString(R.string.titleNormalPeso)
                tvResult.setTextColor(getColor(R.color.peso_normal))
                tvDescription.text = getString(R.string.DescriptionNormalPeso)
            }
        }
        when(result) {
            in 25.00..29.99 -> { //Sobre Peso
                tvResult.text = getString(R.string.titleSobrePeso)
                tvResult.setTextColor(getColor(R.color.sobrePeso))
                tvDescription.text = getString(R.string.DescriptionSobrePeso)
            }
        }
        when(result) {
            in 30.00..250.00 -> { //Obesidad
                tvResult.text = getString(R.string.titleObesidad)
                tvResult.setTextColor(getColor(R.color.obesidad))
                tvDescription.text = getString(R.string.DescriptionObesidad)
            }
        }

    }

    private fun initComponents() {
        tvResult = findViewById(R.id.tvResult)
        tvImc = findViewById(R.id.tvImc)
        tvDescription = findViewById(R.id.tvDescription)
        btnReCalculate = findViewById(R.id.btnRecalculate)
    }
}