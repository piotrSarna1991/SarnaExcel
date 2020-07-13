package com.example.sarnaexcel

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TableRow
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_table.*

class TableActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)
    }

    fun addRow(view: View){
        if(et1.text.isNotEmpty() && et2.text.isNotEmpty()){
            val tableRow = TableRow(getApplicationContext())
            val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)
            layoutParams.setMargins(0,35,0,35)
            tableRow.setLayoutParams(layoutParams)

            var newVersion:TextView = TextView(this)
            var newCodeName:TextView = TextView(this)
            newVersion.setBackgroundColor(Color.parseColor("#eb4034"))
            newVersion.layoutParams=layoutParams
            newCodeName.setBackgroundColor(Color.parseColor("#eb4034"))
            newCodeName.layoutParams=layoutParams
            newVersion.text = et1.text
            newCodeName.text = et2.text

            tableRow.addView(newVersion)
            tableRow.addView(newCodeName)
            table1.addView(tableRow)
            et1.text = null
            et2.text = null
        }
    }
}
