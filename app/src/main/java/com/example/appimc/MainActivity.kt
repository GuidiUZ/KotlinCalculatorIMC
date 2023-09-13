package com.example.appimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import org.w3c.dom.Text
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    //Create and init the variables
    private var isMaleSelected:Boolean = true
    private var isFemaleSelected:Boolean = false
    private var currentWeight:Int = 50
    private var currentAge:Int = 20
    private var currentHeight:Int = 120

    private lateinit var viewMale:CardView
    private lateinit var viewFemale:CardView
    private lateinit var textViewHeight:TextView
    private lateinit var rangeSliderHeight:RangeSlider
    private lateinit var btnSubstractWeight:FloatingActionButton
    private lateinit var btnPlusWeight:FloatingActionButton
    private lateinit var textViewWeight:TextView
    private lateinit var btnSubstractAge:FloatingActionButton
    private lateinit var btnPlusAge:FloatingActionButton
    private lateinit var textViewAge:TextView
    private lateinit var btnCalculate: AppCompatButton

    companion object {
        const val IMC_KEY = "IMC_RESULT"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Call the fuctions for init all
        initComponent()
        initListeners()
        initUI()
    }



    fun initComponent() {

        //Here use the variables and asign ID
        viewMale = findViewById(R.id.genreMale)
        viewFemale = findViewById(R.id.genreFem)
        textViewHeight = findViewById(R.id.textViewHeight)
        rangeSliderHeight = findViewById(R.id.rangeSliderHeight)

        btnSubstractWeight = findViewById(R.id.btnSubstractWeight)
        btnPlusWeight = findViewById(R.id.btnPlusWeight)
        textViewWeight = findViewById(R.id.textViewWeight)

        btnSubstractAge = findViewById(R.id.btnSubstractAge)
        btnPlusAge = findViewById(R.id.btnPlusAge)
        textViewAge = findViewById(R.id.textViewAge)

        btnCalculate = findViewById(R.id.btnCalculate)

    }

    private fun initListeners() {

        //Set listeners in the variables, and call 2 functions
        viewMale.setOnClickListener {
            changeGender()
            setGenderBackground()
        }
        viewFemale.setOnClickListener {
            changeGender()
            setGenderBackground()
        }


        btnSubstractWeight.setOnClickListener {

            currentWeight -= 1
            setWeight()
        }

        btnPlusWeight.setOnClickListener {
            currentWeight += 1
            setWeight()
        }

        btnSubstractAge.setOnClickListener {
            currentAge -= 1
            setAge()
        }

        btnPlusAge.setOnClickListener {
            currentAge += 1
            setAge()
        }

        btnCalculate.setOnClickListener {
            val result = calculateImc()
            navigateToResult(result)
        }


        //If only need "value", the others are replace for "_"
        //And replace the value get in "RangeSlider" in "TextViewHeight"
        rangeSliderHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            currentHeight = df.format(value).toInt()
            textViewHeight.text = "$currentHeight cm"
        }
    }

    private fun navigateToResult(result: Double) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra(IMC_KEY, result)
        startActivity(intent)
    }


    private fun calculateImc(): Double {
        val df = DecimalFormat("#.##")
        val imc = currentWeight.toDouble() / ((currentHeight.toDouble() / 100) * (currentHeight.toDouble() / 100))
        Log.i("guidiuz", "El peso que se manda es $imc")
        return df.format(imc).toDouble()

    }


    private fun setWeight() {
        textViewWeight.text = currentWeight.toString()
    }

    private fun setAge() {
        textViewAge.text = currentAge.toString()
    }


    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }


    private fun setGenderBackground() {

        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isSelectedComponent:Boolean) : Int {
        val colorReference = if(isSelectedComponent) {
            R.color.green
        } else {
            R.color.greenSemiBlack
        }

        return ContextCompat.getColor(this, colorReference)
    }

    private fun initUI() {
        setGenderBackground()
        setWeight()
        setAge()
    }


}