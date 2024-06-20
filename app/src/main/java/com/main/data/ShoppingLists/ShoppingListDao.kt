package com.main.data.ShoppingLists

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
@Dao
interface ShoppingListDao {

    @Insert(entity = ShoppingListEntity::class, onConflict = OnConflictStrategy.REPLACE)
    fun insertShoppingList(shoppingListEntity: ShoppingListEntity)

    @Query("SELECT * FROM shoppingLists_db")
    fun getShoppingList() : Flow<List<ShoppingListEntity>>
}