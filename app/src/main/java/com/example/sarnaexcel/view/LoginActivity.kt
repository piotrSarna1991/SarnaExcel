package com.example.sarnaexcel.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.sarnaexcel.MenuActivity
import com.example.sarnaexcel.R
import com.example.sarnaexcel.model.TableActivity
import com.example.sarnaexcel.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*
import kotlin.math.log

class LoginActivity : AppCompatActivity(), ILoginView,View {

    override fun OnLoginResult(message: String) {
      Toast.makeText(this@LoginActivity,message,Toast.LENGTH_SHORT).show()
    }

    internal lateinit var loginPresenter: LoginPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        loginPresenter = LoginPresenter(this)
//

        loginButton.setOnClickListener {
            loginPresenter.onLogin(
                emailLoginButton.text.toString(),
                passwordLoginButton.text.toString()

            )

        } //


        backToRegistrationButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }}



    override fun navigateTo(target: Class<*>) {
        startActivity(Intent(this, target))
    }
}



