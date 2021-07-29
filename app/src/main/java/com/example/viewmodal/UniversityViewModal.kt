package com.example.reterofitmvvm.viewmodal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.modal.data.University
import com.example.modal.rep.UniRepo
import javax.inject.Inject

class UniversityViewModal @Inject constructor(repository: UniRepo) :ViewModel()
{

    val university : LiveData<List<University>> = repository.universities
    init {
        repository.getUniversities()
    }
}