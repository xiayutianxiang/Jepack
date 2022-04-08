package com.example.jectpack.ui.fragment.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.jectpack.databinding.FragmentRegisterBinding

class RegisterFragment:Fragment() {
    private lateinit var registerBinding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        registerBinding = FragmentRegisterBinding.inflate(layoutInflater)
        return registerBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerBinding.txtCancel.setOnClickListener {
            activity?.onBackPressed()
        }

        registerBinding.btnRegister.setOnClickListener {
            Toast.makeText(context,"Register",Toast.LENGTH_SHORT).show()
        }

        val safeArgs:RegisterFragmentArgs by navArgs()
        val email = safeArgs.email

        registerBinding.etEmail.setText(email)
    }
}