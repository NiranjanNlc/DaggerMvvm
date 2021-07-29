package com.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.daggermvvm.R
import com.example.daggermvvm.databinding.ActivityMainBinding
import com.example.modal.rep.UniRepo
import com.example.reterofitmvvm.ui.Adapter
import com.example.reterofitmvvm.viewmodal.UniversityViewModal
import com.example.reterofitmvvm.viewmodal.ViewModalFactory
import androidx.lifecycle.Observer
import com.example.daggerpackage.component.DaggerAppComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var repository: UniRepo
    private lateinit var binding: ActivityMainBinding
    private lateinit var sampleViewModal: UniversityViewModal
    private val adapter: Adapter = Adapter()
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    private fun initRecyclerView()
    {
        print(" recycler view initiated")
        binding.uniRecycler.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
        binding.uniRecycler.setHasFixedSize(true)
        binding.uniRecycler.adapter=   adapter
        adapter.submitList(sampleViewModal.university.value)
    }

    private fun observeChange()
    {
        sampleViewModal.university.observe(this, Observer
        {
            adapter.submitList(it)
        })
    }

    private fun bindData()
    { initialiseSampleViewModal()
        println(" Sample ViewModal  views "+ sampleViewModal.university)
        binding.lifecycleOwner=this
    }

    private fun initialiseSampleViewModal()
    {
        // val component =DaggerViewModalComponent.create();
        // val repository =UniRepo(RetrofitService.getInstance())
        // val repository= component.getRepo()
        var component =  DaggerAppComponent.create()
        component.inject(this)
        //build()
        println("Reterofit instance " + repository)
    }

}
