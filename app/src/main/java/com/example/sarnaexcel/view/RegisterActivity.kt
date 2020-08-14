package com.example.sarnaexcel.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.sarnaexcel.MenuActivity
import com.example.sarnaexcel.R
import com.example.sarnaexcel.presenter.RegisterPresenter
import kotlinx.android.synthetic.main.activity_main.*

class RegisterActivity : AppCompatActivity(),IRegisterView {

    override fun OnRegisterResult(message: String) {
        Toast.makeText(this@RegisterActivity,message,Toast.LENGTH_SHORT).show()    }

    internal lateinit var registerPresenter:RegisterPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerPresenter = RegisterPresenter(this)

        registerButton.setOnClickListener {
            registerPresenter.createUser(
                userNameButtonRegister.text.toString(),
                emailButtonRegister.text.toString(),
                passwordButtonRegister.text.toString())


        }
//
        alreadyHaveAnAccountButton.setOnClickListener {
            Log.d("MainActivity", "Try to show login activity")

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

}}


