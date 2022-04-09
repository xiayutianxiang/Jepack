package com.example.jectpack.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.jectpack.db.dao.FavouriteShoeDao
import com.example.jectpack.db.dao.ShoeDao
import com.example.jectpack.db.dao.UserDao
import com.example.jectpack.db.data.FavoriteShoe
import com.example.jectpack.db.data.Shoe
import com.example.jectpack.db.data.User
import com.example.jectpack.db.utils.ShoeWorker

/**
 * 数据库文件
 *
 *      当room.schemaLocation设置时，Room 将检查这个变量，如果它设置为true ，数据库模式将被导出到给定的文件夹中。
        exportSchema的值默认为true ，但当您不想保留版本历史记录时，您可以为数据库禁用它（例如仅在内存中的数据库）。
    回报：
        设置room.schemaLocation参数时是否应将架构导出到给定文件夹。默认为tru
 */
@Database(entities = [User::class,Shoe::class,FavoriteShoe::class],version = 1,exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    // 得到UserDao
    abstract fun userDao(): UserDao
    // 得到ShoeDao
    abstract fun shoeDao(): ShoeDao
    // 得到FavouriteShoeDao
    abstract fun favouriteShoeDao(): FavouriteShoeDao

    companion object{
        @Volatile
        private var instance:AppDataBase? = null

        fun getInstance(context:Context):AppDataBase{
            return Room.databaseBuilder(context,AppDataBase::class.java,"jetPack-dataBase")
                .addCallback(object :RoomDatabase.Callback(){
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        // 读取鞋的集合
                        val request = OneTimeWorkRequestBuilder<ShoeWorker>().build()
                        WorkManager.getInstance(context).enqueue(request)
                    }
                }).build()
        }
    }
}