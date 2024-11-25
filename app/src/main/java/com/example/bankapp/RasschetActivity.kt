package com.example.bankapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView

class RasschetActivity : AppCompatActivity() {

    lateinit var sum1: TextView
    lateinit var srok1: TextView
    lateinit var textViewResult2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rasschet)

       sum1 = findViewById(R.id.sum1)
        srok1 = findViewById(R.id.srok1)
        textViewResult2 = findViewById(R.id.textViewResult2)

        val rec1=intent.getStringExtra("amount")
        val rec2=intent.getStringExtra("monthInput")
        val rec3=intent.getStringExtra("result")

        sum1.setText("Сумма кредита:\n"+rec1.toString()+ " рублей")
        srok1.setText("срок кредита:\n"+rec2.toString() + " месяцев")
        textViewResult2.setText("Ежемесячный платеж:\n"+rec3.toString())


    }


    fun back(view: View)
    {

        val intent = Intent(this,BankActivity::class.java)
        startActivity(intent)
    }

}