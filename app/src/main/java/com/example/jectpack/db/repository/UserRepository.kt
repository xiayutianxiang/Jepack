package com.joe.jetpackdemo.db.repository

import androidx.lifecycle.LiveData
import com.example.jectpack.db.dao.UserDao
import com.example.jectpack.db.data.User
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

/**
 * 用户处理仓库
 */
class UserRepository private constructor(private val userDao: UserDao) {

    /**
     * 获取所有的用户
     */
    fun getAllUsers() = userDao.getAllUsers()

    /**
     * 根据id选择用户
     */
    fun findUserById(id:Long):LiveData<User>
            = userDao.findUserById(id)

    /**
     * 登录用户
     */
    fun login(account: String, pwd: String):LiveData<User?>
            = userDao.login(account,pwd)

    /**
     * 注册一个用户
     */
    suspend fun register(email: String, account: String, pwd: String):Long {
        return withContext(IO) {
             userDao.insertUser(User(account, pwd, email))
        }
    }

    companion object {
        @Volatile
        private var instance: UserRepository? = null

        fun getInstance(userDao: UserDao): UserRepository =
            instance ?: synchronized(this) {
                instance
                    ?: UserRepository(userDao).also {
                    instance = it
                }
            }

    }
}