package com.example.sarnaexcel.presenter

import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import com.example.sarnaexcel.MenuActivity
import com.example.sarnaexcel.common.Common
import com.example.sarnaexcel.model.APIResponse
import com.example.sarnaexcel.remote.IMyAPI
import com.example.sarnaexcel.view.ILoginView
import com.example.sarnaexcel.view.LoginActivity
import com.example.sarnaexcel.view.NavigationFinish
import com.example.sarnaexcel.view.View
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter(internal var iLoginView: ILoginView) : ILoginPresenter,NavigationFinish {

    internal lateinit var mService: IMyAPI
    internal lateinit var loginActivity: LoginActivity







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
      loginActivity = LoginActivity()
       loginActivity.navigateTo(MenuActivity::class.java)    }


}