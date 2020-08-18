package com.example.sarnaexcel.presenter

import android.content.Intent
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.sarnaexcel.MenuActivity
import com.example.sarnaexcel.common.Common
import com.example.sarnaexcel.model.APIResponse
import com.example.sarnaexcel.remote.IMyAPI
import com.example.sarnaexcel.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter(internal var iLoginView: ILoginView) : ILoginPresenter, NavigationFinish,AppCompatActivity() {

    internal lateinit var mService: IMyAPI
    internal lateinit var menuActivity: MenuActivity



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
                         onAnimationFinished()
                        }

                    }

                })

        } else iLoginView.OnLoginResult("Empty windows")


    }

    override fun onAnimationFinished() {
        menuActivity.navigateTo(MenuActivity::class.java)
    }


}