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

            val loan:Int = Integer.parseInt(editCP.text.toString()) - Integer.parseInt(editDP.text.toString())
            val interest:Int = loan * Integer.parseInt(editIR.text.toString()) * Integer.parseInt(editLP.text.toString())
            val mp:Int = (loan + interest) / Integer.parseInt(editLP.text.toString())/ 12

            val loanS:String = textViewLoan.text.toString() + loan.toString()
            val interestS:String = textViewInterest.text.toString() + interest.toString()
            val mpS:String = textViewMonthlyRepayment.text.toString() + mp.toString()

            textViewLoan.text = loanS
            textViewInterest.text = interestS
            textViewMonthlyRepayment.text = mpS
        }

        val buttonReset = findViewById(R.id.buttonReset) as Button

        buttonReset.setOnClickListener{
            editCP = findViewById(R.id.editTextCarPrice)
            editDP = findViewById(R.id.editTextDownPayment)
            editLP = findViewById(R.id.editTextLoanPeriod)
            editIR = findViewById(R.id.editTextInterestRate)
            textViewLoan = findViewById(R.id.textViewLoan)
            textViewInterest = findViewById(R.id.textViewInterest)
            textViewMonthlyRepayment = findViewById(R.id.textViewMonthlyRepayment)

            editCP.text = null
            editDP.text = null
            editLP.text = null
            editIR.text = null
            textViewLoan.text = getString(R.string.loan)
            textViewInterest.text = getString(R.string.interest)
            textViewMonthlyRepayment.text =  getString(R.string.monthly_repayment)
        }
    }
}
