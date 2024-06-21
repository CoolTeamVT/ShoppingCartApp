package com.main.data.repository

import com.main.data.ShoppingLists.ShoppingListDao
import com.main.data.ShoppingLists.ShoppingListEntity
import com.main.domain.repository.ShoppingListsRepository
import kotlinx.coroutines.flow.Flow

class ShoppingListsRepositoryImpl(private val shoppingListDao: ShoppingListDao) : ShoppingListsRepository {
    override suspend fun getShoppingLists(): Flow<List<ShoppingListEntity>> {
        return shoppingListDao.getShoppingList()
    }

    override suspend fun addShoppingList(shoppingList: ShoppingListEntity) {
        shoppingListDao.insertShoppingList(shoppingList)
    }
}