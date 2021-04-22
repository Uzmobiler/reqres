package uz.pdp.retrofit.retrofit

import uz.pdp.reqres.retrofit.RetrofitClient
import uz.pdp.reqres.retrofit.RetrofitService

object Common {

    var BASE_URL = "https://reqres.in/api/"

    val retrofitService: RetrofitService
        get() = RetrofitClient.getRetrofit(BASE_URL).create(RetrofitService::class.java)
}