package com.example.modal.reterfit

import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import javax.inject.Singleton

public interface RetrofitService {


    @GET("search?country=Nepal")
    fun getAllUniversity(): retrofit2.Call<List<Map<String,Any>>>

    companion object {

        var retrofitService: RetrofitService? = null

        @Singleton
        public fun getInstance() : RetrofitService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("http://universities.hipolabs.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }

//    @Inject
//    public  fun methodInjet()
//    {
//        println("Methods injected ........................")
//    }
}