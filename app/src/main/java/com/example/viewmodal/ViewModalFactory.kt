package com.example.reterofitmvvm.viewmodal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.modal.rep.UniRepo
import dagger.Module
import dagger.Provides
import javax.inject.Inject


@Module
class ViewModalFactory @Inject constructor(private val repository: UniRepo): ViewModelProvider.Factory {

    @Provides
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        println(" Inn view odal factory")
        if (modelClass.isAssignableFrom(UniversityViewModal::class.java)) {
            println("Assighnabke class")
            @Suppress("UNCHECKED_CAST")
            return  UniversityViewModal(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
