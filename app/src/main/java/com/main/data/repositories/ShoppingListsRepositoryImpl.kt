package com.main.data.repositories

import com.main.data.local.ShoppingListsDB.ShoppingListDao
import com.main.data.local.utils.fromModelToEntity
import com.main.data.local.utils.toShoppingListModel
import com.main.domain.models.ShoppingListModel
import com.main.domain.repositories.ShoppingListsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class ShoppingListsRepositoryImpl(
    private val shoppingListDao: ShoppingListDao
) : ShoppingListsRepository {
    override suspend fun getShoppingLists(): Flow<List<ShoppingListModel>> {
        return withContext(Dispatchers.IO) {
            return@withContext shoppingListDao.getShoppingList().map { entityList ->
                entityList.map { entity ->
                    entity.toShoppingListModel()
                }
            }
        }
    }

    override suspend fun addShoppingList(shoppingListModel: ShoppingListModel) {
        withContext(Dispatchers.IO) {
            shoppingListDao.insertShoppingList(shoppingListModel.fromModelToEntity())
        }
    }
}