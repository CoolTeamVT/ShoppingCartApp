package com.main.domain.usecases.GetUsecases

import com.main.domain.models.ShoppingListModel
import com.main.domain.repositories.ShoppingListsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetFromShoppingListDBUsecase {
    suspend fun execute (params: None) : Flow<List<ShoppingListModel>>

}
class GetFromShoppingListDBUsecaseImpl @Inject constructor(
    private val shoppingListsRepository: ShoppingListsRepository
) : BasicGetUsecase<List<ShoppingListModel>, None>() {
    override suspend fun execute(params: None): Flow<List<ShoppingListModel>> {
        return shoppingListsRepository.getShoppingLists()
    }

}