package com.c24.jenkinied.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Login Fragment"
    }
    val text: LiveData<String> = _text
}