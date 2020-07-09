package com.example.sarnaexcel

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        loginButton.setOnClickListener {
            loginActivity()


        }
        backToRegistrationButton.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }


    }

    private fun loginActivity() {
        val email = emailLoginButton.text.toString()
        val password = passwordLoginButton.text.toString()
        if (checkEmailAndPassword(this, email, password)) return

        Log.d("LoginActivity", "Your email is $email")

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if (!it.isSuccessful) return@addOnCompleteListener

                // else if successful
                Log.d("LoginActivity", "Successfully log in")
                val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
            }.addOnFailureListener {
                Log.d("LoginActivity", "Wrong email or password: ${it.message}")
                Toast.makeText(this, "Wrong email or password: ${it.message}", Toast.LENGTH_SHORT)
                    .show()
            }
    }

    public fun checkEmailAndPassword(context: Context, email: String, password: String): Boolean {
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(context, "Please enter text in email/pw", Toast.LENGTH_SHORT).show()
            return true
        }
        return false
    }
}


