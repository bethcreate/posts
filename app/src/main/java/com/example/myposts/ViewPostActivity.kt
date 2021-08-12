package com.example.myposts

import android.os.Bundle
import android.telecom.Call
import androidx.appcompat.app.AppCompatActivity
import javax.security.auth.callback.Callback

class ViewPostActivity {
    class ViewPostActivity : AppCompatActivity() {
        lateinit var binding:ActivityViewPostBinding
        var postId=0
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding= ActivityViewPostBinding.inflate(layoutInflater)
            setContentView(binding.root)
            postId=intent.getIntExtra("POST_ID",0)
            setSupportActionBar(binding.toolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowTitleEnabled(false)
            getPost()

        }
        fun getPost(){
            var retrofit=Apiclient.buildService(ApiInterface::class.java)
            var request=retrofit.getPostById(postId)
            request.enqueue(object : Callback<Post> {
                override fun onResponse(call: Call<Post>, response: Response<Post>) {
                    if(response.isSuccessful){
                        binding.tvtitlLbl.text=response.body()?.title
                        binding.tvBodyLbl.text=response.body()?.body

                    }

                }

                override fun onFailure(call: Call<Post>, t: Throwable) {


                }

            }
            )
        }
    }
}