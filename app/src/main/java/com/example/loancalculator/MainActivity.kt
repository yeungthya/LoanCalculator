package com.example.loancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var editCP : EditText
    lateinit var editDP : EditText
    lateinit var editLP : EditText
    lateinit var editIR : EditText
    lateinit var textViewLoan : TextView
    lateinit var textViewInterest : TextView
    lateinit var textViewMonthlyRepayment : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonCalculate = findViewById(R.id.buttonCalculate) as Button

        buttonCalculate.setOnClickListener {

            editCP = findViewById(R.id.editTextCarPrice)
            editDP = findViewById(R.id.editTextDownPayment)
            editLP = findViewById(R.id.editTextLoanPeriod)
            editIR = findViewById(R.id.editTextInterestRate)
            textViewLoan = findViewById(R.id.textViewLoan)
            textViewInterest = findViewById(R.id.textViewInterest)
            textViewMonthlyRepayment = findViewById(R.id.textViewMonthlyRepayment)

            val loan:Int = Integer.parseInt(editCP.toString()) - Integer.parseInt(editDP.toString())
            val interest:Int = loan * Integer.parseInt(editIR.toString()) * Integer.parseInt(editLP.toString())
            val mp:Int = (loan + interest) / Integer.parseInt(editLP.toString())/ 12

            val loanS:String = textViewLoan.toString() + loan.toString()
            val interestS:String = textViewInterest.toString() + interest.toString()
            val mpS:String = textViewMonthlyRepayment.toString() + mp.toString()

            textViewLoan.setText(loanS)
            textViewInterest.setText(interestS)
            textViewMonthlyRepayment.setText(mpS)
        }
    }
}
