package com.xhateya.idn.kisahnabiapp

import AdapterMain
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.xhateya.idn.kisahnabiapp.R
import com.xhateya.idn.kisahnabiapp.model.ResponseMain
import com.xhateya.idn.kisahnabiapp.viewModel.ViewModelMain

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ViewModelMain


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Kisah 25 Nabi"

        initView()
        AttachObserve()
    }

    private fun AttachObserve() {
        viewModel.responGetData.observe(this,{showData(it) })
        viewModel.isError.observe(this,{showError(it) })
        viewModel.isLoading.observe(this,{showLoading(it) })
    }

    private fun showLoading(it: Boolean?) {
        if (it = true){
            progress_main.visibility = View
        }
    }

    private fun showError(it: Throwable?) {
        TODO("Not yet implemented")
    }

    private fun showData(it: List<ResponseMain>?) {
        val adapter = AdapterMain(it, object : AdapterMain.OnClickListener{
            override fun detail(item: ResponseMain) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("data, item")
                startActivity(intent)
            }
        })

    }

    private fun initView() {
        TODO("Not yet implemented")
    }
}