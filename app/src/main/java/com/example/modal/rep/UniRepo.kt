package com.example.modal.rep

import androidx.lifecycle.MutableLiveData
import com.example.modal.data.University
import com.example.modal.reterfit.RetrofitService
import dagger.Module
import dagger.Provides
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@Module
public class UniRepo  @Inject constructor(private  val service: RetrofitService)
{
    var universities = MutableLiveData<List<University>>()
    val allUniversity  = service.getAllUniversity()

    @Provides
    fun getUniversities()
    {
        allUniversity.enqueue(object : Callback<List<Map<String, Any>>>
        {


            private fun getListOfUniversity(body: List<Map<String,Any>>?) : List<University>?
            {
                println(" rterofit instance "+ service.toString())
                val universities: MutableList<University> = mutableListOf()
                body?.forEach {
                    universities.add(University(it?.get("name").toString()))
                }
                return universities;
            }

            override fun onResponse(
                call: Call<List<Map<String, Any>>>,
                response: Response<List<Map<String, Any>>>
            ) {
                universities.value=getListOfUniversity(response.body())
            }

            override fun onFailure(call: Call<List<Map<String, Any>>>, t: Throwable) {
                TODO("Not yet implemented")
                println(" Failure implementes ..................")
            }


        })


    }

}
