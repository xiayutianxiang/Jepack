package com.example.jectpack.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jectpack.databinding.ActivityLoginBinding

class LoginActivity:AppCompatActivity() {

    private lateinit var loginBinding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(loginBinding.root)
    }
}