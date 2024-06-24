package com.main.domain.repositories

import com.main.domain.models.ShoppingListModel
import kotlinx.coroutines.flow.Flow

interface ShoppingListsRepository {
    suspend fun getShoppingLists(): Flow<List<ShoppingListModel>>
    suspend fun addShoppingList(shoppingListModel: ShoppingListModel)

    //TODO:
    //suspend fun deleteSoppingList(id: Int)
    //suspend fun getShoppingListById(id: Int): ShoppingListEntity?
}