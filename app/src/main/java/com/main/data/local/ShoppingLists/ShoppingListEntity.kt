package com.main.data.local.ShoppingLists

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "shoppingLists_db"
)
data class ShoppingListEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "date") val data : String
) {
    companion object {
        //TODO: fun from(shoppingListModel: ShoppingListModel): ShoppingListEntity
        //TODO: fun to(): ShoppingListModel
    }
}

