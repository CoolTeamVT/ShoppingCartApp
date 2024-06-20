package com.main.data.ShoppingLists

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

interface ShoppingListDao {

    @Insert(entity = ShoppingListEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShoppingList(shoppingListEntity: ShoppingListEntity)

    @Query("SELECT * FROM shoppingLists_db")
    suspend fun getShoppingListById(id: Int) : Flow<List<ShoppingListEntity>>?
}