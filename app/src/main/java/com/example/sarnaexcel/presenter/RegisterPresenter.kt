package com.example.sarnaexcel.presenter

import com.example.sarnaexcel.common.Common
import com.example.sarnaexcel.model.APIResponse
import com.example.sarnaexcel.model.User
import com.example.sarnaexcel.remote.IMyAPI
import com.example.sarnaexcel.view.IRegisterView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterPresenter(internal var iRegisterView: IRegisterView) : IRegisterPresenter {

    internal lateinit var mService: IMyAPI

    override fun createUser(name: String, email: String, password: String) {
        if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
            mService = Common.api
            mService.registerUser(name, email, password)
                .enqueue(object : Callback<APIResponse> {
                    override fun onFailure(call: Call<APIResponse>, t: Throwable) {
                        iRegisterView.OnRegisterResult(t.message.toString())
                    }

                    override fun onResponse(
                        call: Call<APIResponse>,
                        response: Response<APIResponse>
                    ) {
                        if (response!!.body()?.isError!!) {

                            iRegisterView.OnRegisterResult(response.body()?.error_msg.toString())

                        } else {
                            response.body()?.uid?.let {
                                iRegisterView.OnRegisterResult(
                                    it
                                )
                            }
                        }
                    }
                })
//
        } else iRegisterView.OnRegisterResult("Enter all datas")
    }


}