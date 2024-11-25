package com.example.bankapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast



class CreditcalcActivity : AppCompatActivity() {
    lateinit var seekBar:SeekBar
    lateinit var editText3: EditText
    lateinit var textViewResult:TextView
    var count:Int=0
    lateinit var text:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creditcalc)


        seekBar=findViewById(R.id.seekBar)
        editText3=findViewById(R.id.editText3)
        textViewResult=findViewById(R.id.textViewResult)
        text=findViewById(R.id.text)

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                count=seekBar.progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                text.setText(count.toString())
            }
        })


    }

    fun calculate(view: View)
    {
        val amount=seekBar.progress
        val monthInput=editText3.text.toString()

        if (monthInput.isEmpty())
        {
            Toast.makeText(this,"Введите срок кредита в месяцах", Toast.LENGTH_LONG).show()
            return
        }
        else if(monthInput.toInt()<=0){
            Toast.makeText(this,"Минимальное значение 1", Toast.LENGTH_LONG).show()
            return
        }
        val result: Double
        val ss : Int = monthInput.toInt()

        result = when {

            ss<=12 ->
                { amount/ss+(amount*0.059) }
            ss<=24 ->
                {(amount/12+(amount*0.059))+amount/ss+(amount-12*(amount/ss+(amount*0.059)))*0.051}


            else ->
                    {(amount/12+(amount*0.059))+amount/ss+(amount-12*(amount/ss+(amount*0.059)))*0.042}
        }

        textViewResult.text=String.format("ежемесячный платеж = %.2f тысяч",result/1000);

        Toast.makeText(this,"ежемесячный платеж = ${result/1000} тысяч",Toast.LENGTH_LONG).show()


        val handler = android.os.Handler()
        handler.postDelayed({
            val intent = Intent(this,RasschetActivity::class.java).putExtra("result",(result/1000).toString()).putExtra("amount",amount.toString()).putExtra("monthInput",monthInput)
            startActivity(intent)
        }, 5000)


    }

    fun back(view: View)
    {

        val intent = Intent(this,BankActivity::class.java)
        startActivity(intent)
    }

}


