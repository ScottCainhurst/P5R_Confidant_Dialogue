   package com.android.example.p5rconfidantdialoguev2.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.android.example.p5rconfidantdialoguev2.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

   // Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = [dialogueText::class], version = 1, exportSchema = false)
abstract class ConfidantRoomDatabase : RoomDatabase() {

       abstract fun confidantDao(): ConfidantDao

       companion object {
           private const val DATABASE_NAME = "Confidant"

           fun buildDatabase(context: Context): ConfidantRoomDatabase {
               return Room.databaseBuilder(
                       context,
                       ConfidantRoomDatabase::class.java,
                       DATABASE_NAME
               )
                       .allowMainThreadQueries()
                       .build()
           }
       }
   }
