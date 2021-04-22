package uz.pdp.reqres

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class SecondActivity : AppCompatActivity() {

    var okHttpClient: OkHttpClient = OkHttpClient()
    val URL = "https://api.icndb.com/jokes/random"

    private val TAG = "SecondActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val request = Request.Builder().url(URL).build()


        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {

            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val str = response.body?.string()

                    val txt = (JSONObject(str).getJSONObject("value").get("joke")).toString()
                    Log.d(TAG, "onResponse: ${txt}")

                }
            }
        })
    }
}