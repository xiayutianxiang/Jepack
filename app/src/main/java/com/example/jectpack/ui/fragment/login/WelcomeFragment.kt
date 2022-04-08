package com.example.jectpack.ui.fragment.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.jectpack.R
import com.example.jectpack.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    private lateinit var welcomeBinding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        welcomeBinding = FragmentWelcomeBinding.inflate(layoutInflater)
        return welcomeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        welcomeBinding.btnLogin.setOnClickListener {
            //设置动画参数
            val navOption = navOptions {
                anim {
                    enter = R.anim.slide_in_right
                    exit = R.anim.slide_out_left
                    popEnter = R.anim.slide_in_left
                    popExit = R.anim.slide_out_right
                }
            }

            //添加参数
            val bundle = Bundle()
            bundle.putString("name","ergou")
            //利用id，跳转到loginFragment
            findNavController().navigate(R.id.loginFragment,bundle,navOption)
        }

        //利用action跳转
        welcomeBinding.btnRegister.setOnClickListener {
            val action = WelcomeFragmentDirections.actionWelcomeToRegister()
                .setEMAIL("shanshan@20220408icu.com")
            findNavController().navigate(action)
        }
    }
}