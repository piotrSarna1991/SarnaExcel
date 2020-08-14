package com.example.sarnaexcel.common

import com.example.sarnaexcel.remote.IMyAPI
import com.example.sarnaexcel.remote.RetrofitClient

object Common
{
    val BASE_URL ="http:/10.0.2.2/sarnaexcel2/"

    val api:IMyAPI
    get() = RetrofitClient.getClient(BASE_URL).create(IMyAPI::class.java)
}