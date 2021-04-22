package uz.pdp.reqres

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.pdp.reqres.databinding.ActivityMainBinding
import uz.pdp.reqres.models.create.ReqUser
import uz.pdp.reqres.models.create.ResUser
import uz.pdp.reqres.models.list_users.UserResponce
import uz.pdp.reqres.models.single_user.SingleUserResponce
import uz.pdp.reqres.models.update.ResUpdateUser
import uz.pdp.reqres.retrofit.RetrofitService
import uz.pdp.retrofit.retrofit.Common

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var retrofitService: RetrofitService

    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        retrofitService = Common.retrofitService

//        val reqUser = ReqUser("developer", "Sanjar")
        retrofitService.deleteUser(1).enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    Log.d(TAG, "onResponse: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

            }

        })
    }
}