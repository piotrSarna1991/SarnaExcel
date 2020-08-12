package com.example.sarnaexcel.model

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.sarnaexcel.R
import kotlinx.android.synthetic.main.activity_table.*

class TableActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)
    }

    fun addRow(view: View){
        if(et1.text.isNotEmpty() && et2.text.isNotEmpty()&& et3.text.isNotEmpty()){
            val tableRow = TableRow(getApplicationContext())
            val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)
            layoutParams.setMargins(0,35,0,35)
            tableRow.setLayoutParams(layoutParams)

            var id:TextView = TextView(this)
            var name:TextView = TextView(this)
            var surname = TextView(this)
            id.setBackgroundColor(Color.parseColor("#FFFFFF"))
            id.layoutParams=layoutParams
            name.setBackgroundColor(Color.parseColor("#FFFFFF"))
            name.layoutParams=layoutParams
            surname.setBackgroundColor(Color.parseColor("#FFFFFF"))
            surname.layoutParams = layoutParams
            val tableDatas = Person(
                et1.text.toString(),
                et2.text.toString(),
                et3.text.toString()
            )
            saveDataOnFireBase(tableDatas)
            id.text = et1.text
            name.text = et2.text
            surname.text = et3.text
            tableRow.addView(id)
            tableRow.addView(name)
            tableRow.addView(surname)
            table1.addView(tableRow)
            cleanTextViews()


        }
    }
    fun cleanTextViews() {
        et1.text = null
        et2.text = null
        et3.text = null
    }

    fun saveDataOnFireBase (tableDatas: Person) {


    }
    private fun readUserFromFirebaseDatabase() {
        // TODO: 15.07.2020
    }
}

