package com.main.data.local.FridgeInventory

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(
    tableName = "fridgeInventory_db"
)
data class FridgeInventoryEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo("fridgeInventory_name")val name: String?
)
