package com.example.datasharingmvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InputViewModel : ViewModel() {

    val message = MutableLiveData<String>()

    fun setMessage(str: String){
        message.value = str
    }

}
