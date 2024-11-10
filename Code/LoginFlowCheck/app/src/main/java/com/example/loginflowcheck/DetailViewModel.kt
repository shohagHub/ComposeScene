package com.example.loginflowcheck

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor() : ViewModel() {
    // Observable variable to represent a condition
    private val _loginStatus = mutableStateOf(false)
    val conditionMet: State<Boolean> = _loginStatus

    // Another example observable variable
    private val _message = mutableStateOf("Welcome to Detail Screen")
    val message: State<String> = _message

    // Method to update conditionMet
    fun meetCondition() {
        _loginStatus.value = true
    }

    // Method to update message
    fun updateMessage(newMessage: String) {
        _message.value = newMessage
    }

    fun launchActivity() {

    }
}