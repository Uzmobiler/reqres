package uz.pdp.reqres.retrofit

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*
import uz.pdp.reqres.models.create.ReqUser
import uz.pdp.reqres.models.create.ResUser
import uz.pdp.reqres.models.list_users.UserResponce
import uz.pdp.reqres.models.single_user.SingleUserResponce
import uz.pdp.reqres.models.update.ResUpdateUser


interface RetrofitService {

    @GET("users")
    fun getUsers(@Query("delay") delay: Int): Call<UserResponce>

    @GET("users/{id}")
    fun getSingleUser(@Path("id") id: Int): Call<SingleUserResponce>

    @POST("users")
    fun createUser(@Body reqUser: ReqUser): Call<ResUser>

    @PUT("users/{id}")
    fun updateUser(@Path("id") id: Int, @Body reqUser: ReqUser): Call<ResUpdateUser>

    @DELETE("users/{id}")
    fun deleteUser(@Path("id") id: Int): Call<ResponseBody>
}