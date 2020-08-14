package com.example.sarnaexcel.presenter

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.example.sarnaexcel.MenuActivity
import com.example.sarnaexcel.common.Common
import com.example.sarnaexcel.model.APIResponse
import com.example.sarnaexcel.model.TableActivity
import com.example.sarnaexcel.model.User
import com.example.sarnaexcel.remote.IMyAPI
import com.example.sarnaexcel.view.ILoginView
import com.example.sarnaexcel.view.LoginActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter(internal var iLoginView: ILoginView) : ILoginPresenter {

    internal lateinit var mService: IMyAPI
    internal var loginActivity: LoginActivity? = null


    override fun onLogin(email: String, password: String) {
        if (email.isNotEmpty() && password.isNotEmpty()) {

            mService = Common.api
            mService.loginUser(email, password)
                .enqueue(object : Callback<APIResponse> {
                    override fun onFailure(call: Call<APIResponse>, t: Throwable) {
                        iLoginView.OnLoginResult(t.message.toString())

                    }

                    override fun onResponse(
                        call: Call<APIResponse>,
                        response: Response<APIResponse>
                    ) {
                        if (response!!.body()?.isError!!) {

                            iLoginView.OnLoginResult(response.body()?.error_msg.toString())

                        } else {
                            iLoginView.OnLoginResult("Login success")
                         loginActivity?.goToMenu()


                        }

                    }

                })

        } else iLoginView.OnLoginResult("Empty windows")


    }
}