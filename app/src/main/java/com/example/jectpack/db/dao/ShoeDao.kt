package com.example.jectpack.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.jectpack.db.data.Shoe
import io.reactivex.Flowable

/**
 * 使用@Dao注解，建立数据库增删改查
 */

@Dao
interface ShoeDao {

    //@Insert注解声明当前的方法为新增的方法，并且可以设置当新增冲突的时候处理的方法。
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShoe(shoe: Shoe)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShoes(shoes: List<Shoe>)

    //@Insert注解声明当前的方法为新增的方法，并且可以设置当新增冲突的时候处理的方法。
    @Delete
    fun deleteShoe(shoe: Shoe)

    fun deleteShoes(shoes: List<Shoe>)

    //@Update注解声明当前方法是一个更新方法
    @Update
    fun unDateShoe(shoe: Shoe)

    @Update
    fun unDateShoes(shoes: Array<Shoe>)

    //@Query注解不仅可以声明这是一个查询语句，也可以用来删除和修改，不可以用来新增。

    // 查询一个
    @Query("SELECT * FROM shoe WHERE id=:id")
    fun findShoeById(id: Long): Shoe?

    // 查询多个 通过品牌查询多款鞋
    @Query("SELECT * FROM shoe WHERE shoe_brand=:brand")
    fun findShoesByBrand(brand: String): List<Shoe>

    // 模糊查询 排序 同名鞋名查询鞋
    @Query("SELECT * FROM shoe WHERE shoe_name LIKE :name ORDER BY shoe_brand ASC")
    fun findShoesByName(name:String):List<Shoe>

    // 配合LiveData 返回所有的鞋子
    @Query("SELECT * FROM shoe")
    fun getAllShoesLD(): LiveData<List<Shoe>>

    // 配合LiveData 通过Id查询单款鞋子
    @Query("SELECT * FROM shoe WHERE id=:id")
    fun findShoeByIdLD(id: Long): LiveData<Shoe>

    // 配合RxJava 通过Id查询单款鞋子
    @Query("SELECT * FROM shoe WHERE id=:id")
    fun findShoeByIdRx(id: Long): Flowable<Shoe>

    // 根据收藏结合 查询用户喜欢的鞋的集合 内联查询
    @Query(
        "SELECT shoe.id,shoe.shoe_name,shoe.shoe_description,shoe.shoe_price,shoe.shoe_brand,shoe.shoe_imgUrl " +
                "FROM shoe " +
                "INNER JOIN fav_shoe ON fav_shoe.shoe_id = shoe.id " +
                "WHERE fav_shoe.user_id = :userId"
    )
    fun findShoesByUserId(userId: Long): LiveData<List<Shoe>>

    /**
     * 通过品牌查询鞋子
     */
    @Query("SELECT * FROM shoe WHERE shoe_brand=:brand")
    fun findShoesByBrandLD(brand: String): LiveData<List<Shoe>>
}