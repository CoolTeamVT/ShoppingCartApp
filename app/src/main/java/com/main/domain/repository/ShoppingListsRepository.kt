package com.main.domain.repository

import com.main.data.ShoppingLists.ShoppingListEntity
import kotlinx.coroutines.flow.Flow

interface ShoppingListsRepository {
    suspend fun getShoppingLists(): Flow<List<ShoppingListEntity>>
    suspend fun addShoppingList(shoppingList: ShoppingListEntity)

    //TODO:
    //suspend fun deleteSoppingList(id: Int)
    //suspend fun getShoppingListById(id: Int): ShoppingListEntity?
}