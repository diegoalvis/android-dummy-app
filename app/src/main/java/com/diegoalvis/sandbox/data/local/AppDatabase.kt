package com.diegoalvis.sandbox.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


const val DATABASE_VERSION = 1

@Database(entities = [DummyEntity::class], version = DATABASE_VERSION)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "my-database"
    }

    abstract fun dummyDao(): DummyDao

}


inline fun <reified T : RoomDatabase> getDb(context: Context, databaseName: String): T {
    return Room.databaseBuilder(context, T::class.java, databaseName).build()
}