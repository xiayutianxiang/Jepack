package com.example.jectpack.db.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * @Entity    声明这是一个表（实体），主要参数：tableName-表名、foreignKeys-外键、indices-索引。
@ColumnInfo	主要用来修改在数据库中的字段名。
@PrimaryKey	声明该字段主键并可以声明是否自动创建。
@Ignore	声明某个字段只是临时用，不存储在数据库中。
@Embedded	用于嵌套，里面的字段同样会存储在数据库中。
 */


/**
 * 用户表
 */

@Entity(tableName = "user")
data class User(
    @ColumnInfo(name = "user_account") val account: String,
    @ColumnInfo(name = "user_pwd") val pwd: String,
    @ColumnInfo(name = "user_name") val name: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0
}