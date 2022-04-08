package com.example.jectpack.viewmodel

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.databinding.ObservableField
import com.example.jectpack.MainActivity
import com.example.jectpack.data.BaseConstant

/**
 * 登录的viewModel，负责登录逻辑和输入框内容改变的数据更新处理
 */
class LoginModel constructor(name:String,pwd:String,context:Context){

    //包装给定对象并创建一个可观察对象
    val name = ObservableField(name)
    val pwd = ObservableField(pwd)
    var context:Context = context

    /**
     * 用户名改变时
     */
    fun onNameChange(s:CharSequence){
        name.set(s.toString())
    }

    /**
     * 密码改变时
     */
    fun onPwdChange(s:CharSequence){
        pwd.set(s.toString())
    }

    /**
     * 登录逻辑处理
     */
    fun login(){
        if(name.get().equals(BaseConstant.USER_NAME) && pwd.get().equals(BaseConstant.USER_PWD)){
            Toast.makeText(context,"用户密码正确",Toast.LENGTH_SHORT).show()
            val intent = Intent(context,MainActivity::class.java)
            context.startActivity(intent)
        }
    }
}