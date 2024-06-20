package com.main.data.FridgeInventory

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(
    tableName = "fridgeInventory_db"
)
data class FridgeInventoryEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)
