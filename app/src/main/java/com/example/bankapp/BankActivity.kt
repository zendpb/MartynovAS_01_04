package com.example.bankapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class BankActivity : AppCompatActivity() {

    lateinit var editText1: EditText
    lateinit var editText2: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bank)

        editText1=findViewById(R.id.editText1)
        editText2=findViewById(R.id.editText2)


    }


    fun next(view: View)
    {
        val text1=editText1.text
        val text2=editText2.text
        if (text1.isEmpty()||text2.isEmpty())
        {
            Toast.makeText(this,"Введите логин и пароль",Toast.LENGTH_LONG).show()

        }
            else{ val intent = Intent(this,CreditcalcActivity::class.java)
                startActivity(intent)}


    }

}