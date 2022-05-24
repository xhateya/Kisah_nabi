package com.xhateya.idn.kisahnabiapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.xhateya.idn.kisahnabiapp.model.ResponseMain
import com.xhateya.idn.kisahnabiapp.repo.RepositoryMain

class ViewModelMain : ViewModel() {

    val repository = RepositoryMain()

    var responGetData = MutableLiveData<List<ResponseMain>>()
    var isError = MutableLiveData<Throwable>()
    val isLoading = MutableLiveData<Boolean>()

    fun getDataView(){
        isLoading.value = true

        repository.getData({
            isLoading.value = false
            responGetData.value = it

        },{

            isLoading.value= false
            isError.value = it

        })
    }
}