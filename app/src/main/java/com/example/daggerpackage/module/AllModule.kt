package com.example.daggerpackage.module

import com.example.modal.reterfit.RetrofitService
import dagger.Module
import dagger.Provides
import retrofit2.Call
import javax.inject.Singleton

@Module
class AllModule
{
    @Provides
    @Singleton
    fun getdata(): Call<List<Map<String, Any>>> {
        return RetrofitService.getInstance().getAllUniversity()
    }

}