package com.example.jectpack.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.jectpack.db.data.FavoriteShoe

/**
 * 喜欢的鞋子的Dao
 */
@Dao
interface FavouriteShoeDao {

    // 查询用户下面的FavouriteShoe
    @Query("SELECT * From fav_shoe WHERE user_id = :userId")
    fun findFavouriteShoesByUserId(userId: String): LiveData<List<FavoriteShoe>>

    // 查询单个FavouriteShoe
    @Query("SELECT * FROM fav_shoe WHERE user_id = :userId AND shoe_id =:shoeId")
    fun findFavouriteShoeByUserIdAndShoeId(userId: String, shoeId: String)

    // 插入单个FavouriteShoe
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavouriteShoe(favouriteShoe: FavoriteShoe)

    // 删除单个FavouriteShoe
    @Delete
    fun deleteFavouriteShoe(favouriteShoe: FavoriteShoe)

    // 删除多个FavouriteShoe
    @Delete
    fun deleteFavouriteShoes(favouriteShoes: List<FavoriteShoe>)
}