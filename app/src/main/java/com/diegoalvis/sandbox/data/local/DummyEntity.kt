package com.diegoalvis.sandbox.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DummyEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int
)