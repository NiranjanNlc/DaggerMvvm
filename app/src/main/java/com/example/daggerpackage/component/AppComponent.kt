package com.example.daggerpackage.component

import com.example.MainActivity
import com.example.daggerpackage.module.AllModule
import com.example.modal.rep.UniRepo
import com.example.modal.reterfit.RetrofitService
import com.example.reterofitmvvm.viewmodal.ViewModalFactory
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [UniRepo::class, AllModule::class,ViewModalFactory ::class ]
)
interface AppComponent {
    fun inject(activity: MainActivity)
}