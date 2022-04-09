package com.example.jectpack.ui.fragment.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.jectpack.MainActivity
import com.example.jectpack.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    //private var loginBinding: FragmentLoginBinding? = null
    //lateinit 定义变量时不需要初始化，但是在使用变量时要保证初始化
    private lateinit var loginBinding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        loginBinding = FragmentLoginBinding.inflate(layoutInflater)
        return loginBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginBinding.btnLogin.setOnClickListener {
            val intent = Intent(context,MainActivity::class.java)
            context?.startActivity(intent)
        }

        loginBinding.txtCancel.setOnClickListener {
            activity?.onBackPressed()
        }

        val name = arguments?.getString("name")
        loginBinding.txtTitle.setText(name)
    }
}