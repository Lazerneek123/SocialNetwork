package com.example.socialnetworkteo.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class User (name: String, post: String, age: Int, online: String, email: String, photo: Int, hobby: String, description: String) {

    private val _name = MutableLiveData<String>().apply {
        value = name
    }
    val name: LiveData<String> = _name

    private val _post = MutableLiveData<String>().apply {
        value = post
    }
    val post: LiveData<String> = _post

    private val _age = MutableLiveData<Int>().apply {
        value = age
    }
    val age: LiveData<Int> = _age

    private val _online = MutableLiveData<String>().apply {
        value = online
    }
    val online: LiveData<String> = _online

    private val _email = MutableLiveData<String>().apply {
        value = email
    }
    val email: LiveData<String> = _email

    private val _photo = MutableLiveData<Int>().apply {
        value = photo
    }
    val photo: LiveData<Int> = _photo

    private val _hobby = MutableLiveData<String>().apply {
        value = hobby
    }
    val hobby: LiveData<String> = _hobby

    private val _description = MutableLiveData<String>().apply {
        value = description
    }
    val description: LiveData<String> = _description
}
